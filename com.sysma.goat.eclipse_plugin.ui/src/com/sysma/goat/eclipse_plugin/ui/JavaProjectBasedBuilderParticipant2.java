package com.sysma.goat.eclipse_plugin.ui;

import java.util.List;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.builder.BuilderParticipant;
import org.eclipse.xtext.generator.IFileSystemAccess;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.IResourceDescription;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
 
import com.google.inject.Inject;
import com.sysma.goat.eclipse_plugin.generator.IGeneratorMulti;
 
public class JavaProjectBasedBuilderParticipant2 extends BuilderParticipant {
  @Inject
  private ResourceDescriptionsProvider resourceDescriptionsProvider;
 
  @Inject
  private IContainer.Manager containerManager;
 
  @Inject (optional=true)
  private IGeneratorMulti generator;
 
  protected ThreadLocal<Boolean> buildSemaphor = new ThreadLocal<Boolean>();
 
  @Override
  public void build(IBuildContext context, IProgressMonitor monitor) throws CoreException {
    buildSemaphor.set(false);
    super.build(context, monitor);
  }
 
  @Override
  protected void handleChangedContents(Delta delta, IBuildContext context, IFileSystemAccess fileSystemAccess) throws CoreException {
    super.handleChangedContents(delta, context, fileSystemAccess);
    if (!buildSemaphor.get() && generator != null) {
      invokeGenerator(delta, context, fileSystemAccess);
    }
  }
 
  /*
  @Override
  protected void handleDeletion(Delta delta, IBuildContext context, IFileSystemAccess fileSystemAccess) {
    super.handleDeletion(delta, context, fileSystemAccess);
    if (!buildSemaphor.get() && generator != null) {
      invokeGenerator(delta, context, fileSystemAccess);
    }
  }*/
 
  private void invokeGenerator (Delta delta, IBuildContext context, IFileSystemAccess fileSystemAccess) {
    buildSemaphor.set(true);
    Resource resource = context.getResourceSet().getResource(delta.getUri(), true);
    if (shouldGenerate(resource, context)) {
      IResourceDescriptions index = resourceDescriptionsProvider.createResourceDescriptions();
      IResourceDescription resDesc = index.getResourceDescription(resource.getURI());
      List<IContainer> visibleContainers = containerManager.getVisibleContainers(resDesc, index);
      for (IContainer c : visibleContainers) {
        for (IResourceDescription rd : c.getResourceDescriptions()) {
          context.getResourceSet().getResource(rd.getURI(), true);
        }
      }
 
      generator.doGenerate(context.getResourceSet(), fileSystemAccess);
    }
  }
}