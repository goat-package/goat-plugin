package com.sysma.goat.eclipse_plugin.ui;

import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import com.sysma.goat.eclipse_plugin.ui.Console;
import com.sysma.goat.eclipse_plugin.ui.RunComponent;
import com.sysma.goat.eclipse_plugin.ui.RunServer;
import java.util.Collections;
import java.util.function.Consumer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IPath;
import org.eclipse.debug.ui.ILaunchShortcut;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.ConsolePlugin;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsoleManager;
import org.eclipse.ui.console.IConsoleView;
import org.eclipse.ui.console.IOConsole;
import org.eclipse.xtext.xbase.lib.CollectionLiterals;
import org.eclipse.xtext.xbase.lib.Conversions;
import org.eclipse.xtext.xbase.lib.Exceptions;
import org.eclipse.xtext.xbase.lib.Functions.Function1;
import org.eclipse.xtext.xbase.lib.IterableExtensions;

@SuppressWarnings("all")
public class RunProject implements ILaunchShortcut {
  private void showConsoleView(final IOConsole myConsole) {
    try {
      final IWorkbench wb = PlatformUI.getWorkbench();
      final IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
      if ((win != null)) {
        final IWorkbenchPage page = win.getActivePage();
        if ((page != null)) {
          final String id = IConsoleConstants.ID_CONSOLE_VIEW;
          IViewPart _showView = page.showView(id);
          final IConsoleView view = ((IConsoleView) _showView);
          view.display(myConsole);
        }
      }
    } catch (final Throwable _t) {
      if (_t instanceof PartInitException) {
        final PartInitException e = (PartInitException)_t;
        e.printStackTrace();
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
  }
  
  /**
   * See https://wiki.eclipse.org/FAQ_How_do_I_write_to_the_console_from_a_plug-in%3F
   */
  private Console findConsole(final String name) {
    Console _xblockexpression = null;
    {
      final ConsolePlugin plugin = ConsolePlugin.getDefault();
      final IConsoleManager conMan = plugin.getConsoleManager();
      final IConsole[] existing = conMan.getConsoles();
      final Function1<IConsole, Boolean> _function = new Function1<IConsole, Boolean>() {
        public Boolean apply(final IConsole it) {
          return Boolean.valueOf(it.getName().equals(name));
        }
      };
      final Iterable<IConsole> existConsole = IterableExtensions.<IConsole>filter(((Iterable<IConsole>)Conversions.doWrapArray(existing)), _function);
      Console _xifexpression = null;
      int _length = ((Object[])Conversions.unwrapArray(existConsole, Object.class)).length;
      boolean _greaterThan = (_length > 0);
      if (_greaterThan) {
        IConsole _head = IterableExtensions.<IConsole>head(existConsole);
        _xifexpression = ((Console) _head);
      } else {
        Console _xblockexpression_1 = null;
        {
          final Console myConsole = new Console(name, null);
          conMan.addConsoles(((IConsole[])Conversions.unwrapArray(Collections.<Console>unmodifiableSet(CollectionLiterals.<Console>newHashSet(myConsole)), IConsole.class)));
          _xblockexpression_1 = myConsole;
        }
        _xifexpression = _xblockexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return _xblockexpression;
  }
  
  public void launch(final ISelection selection, final String mode) {
    IProject project_ = null;
    try {
      final IStructuredSelection structured = ((IStructuredSelection) selection);
      int _size = structured.size();
      boolean _equals = (_size == 1);
      if (_equals) {
        Object _firstElement = structured.getFirstElement();
        project_ = ((IProject) _firstElement);
      }
    } catch (final Throwable _t) {
      if (_t instanceof ClassCastException) {
        final ClassCastException cce = (ClassCastException)_t;
      } else {
        throw Exceptions.sneakyThrow(_t);
      }
    }
    if ((project_ == null)) {
      throw new UnsupportedOperationException("Launch on a project!");
    }
    final IProject project = project_;
    final IPath projectPath = project.getLocation();
    final IPath srcDir = project.getProjectRelativePath().append("src");
    final Consumer<IFile> _function = new Consumer<IFile>() {
      public void accept(final IFile it) {
        final IPath fPath = it.getProjectRelativePath().makeRelativeTo(srcDir);
        final Console console = RunProject.this.findConsole(fPath.toString());
        new RunServer(projectPath, fPath, console).launch();
        RunProject.this.showConsoleView(console);
      }
    };
    RunProject.getServers(project.getFolder(srcDir)).forEach(_function);
    final Consumer<IFile> _function_1 = new Consumer<IFile>() {
      public void accept(final IFile it) {
        final IPath fPath = it.getProjectRelativePath().makeRelativeTo(srcDir);
        final Console console = RunProject.this.findConsole(fPath.toString());
        new RunComponent(projectPath, fPath, console).launch();
        RunProject.this.showConsoleView(console);
      }
    };
    RunProject.getComponents(project.getFolder(srcDir)).forEach(_function_1);
  }
  
  private static Iterable<IFile> getServers(final IFolder srcDir) {
    try {
      final Function1<IResource, Boolean> _function = new Function1<IResource, Boolean>() {
        public Boolean apply(final IResource it) {
          return Boolean.valueOf(((it instanceof IFile) && Objects.equal(((IFile) it).getFileExtension(), "ginf")));
        }
      };
      final Function1<IResource, IFile> _function_1 = new Function1<IResource, IFile>() {
        public IFile apply(final IResource it) {
          return ((IFile) it);
        }
      };
      Iterable<IFile> _map = IterableExtensions.<IResource, IFile>map(IterableExtensions.<IResource>filter(((Iterable<IResource>)Conversions.doWrapArray(srcDir.members())), _function), _function_1);
      final Function1<IResource, Boolean> _function_2 = new Function1<IResource, Boolean>() {
        public Boolean apply(final IResource it) {
          return Boolean.valueOf((it instanceof IFolder));
        }
      };
      final Function1<IResource, Iterable<IFile>> _function_3 = new Function1<IResource, Iterable<IFile>>() {
        public Iterable<IFile> apply(final IResource it) {
          return RunProject.getServers(((IFolder) it));
        }
      };
      Iterable<IFile> _flatten = Iterables.<IFile>concat(IterableExtensions.<IResource, Iterable<IFile>>map(IterableExtensions.<IResource>filter(((Iterable<IResource>)Conversions.doWrapArray(srcDir.members())), _function_2), _function_3));
      return Iterables.<IFile>concat(_map, _flatten);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  private static Iterable<IFile> getComponents(final IFolder srcDir) {
    try {
      final Function1<IResource, Boolean> _function = new Function1<IResource, Boolean>() {
        public Boolean apply(final IResource it) {
          return Boolean.valueOf(((it instanceof IFile) && Objects.equal(((IFile) it).getFileExtension(), "goat")));
        }
      };
      final Function1<IResource, IFile> _function_1 = new Function1<IResource, IFile>() {
        public IFile apply(final IResource it) {
          return ((IFile) it);
        }
      };
      Iterable<IFile> _map = IterableExtensions.<IResource, IFile>map(IterableExtensions.<IResource>filter(((Iterable<IResource>)Conversions.doWrapArray(srcDir.members())), _function), _function_1);
      final Function1<IResource, Boolean> _function_2 = new Function1<IResource, Boolean>() {
        public Boolean apply(final IResource it) {
          return Boolean.valueOf((it instanceof IFolder));
        }
      };
      final Function1<IResource, Iterable<IFile>> _function_3 = new Function1<IResource, Iterable<IFile>>() {
        public Iterable<IFile> apply(final IResource it) {
          return RunProject.getComponents(((IFolder) it));
        }
      };
      Iterable<IFile> _flatten = Iterables.<IFile>concat(IterableExtensions.<IResource, Iterable<IFile>>map(IterableExtensions.<IResource>filter(((Iterable<IResource>)Conversions.doWrapArray(srcDir.members())), _function_2), _function_3));
      return Iterables.<IFile>concat(_map, _flatten);
    } catch (Throwable _e) {
      throw Exceptions.sneakyThrow(_e);
    }
  }
  
  public void launch(final IEditorPart editor, final String mode) {
    throw new UnsupportedOperationException();
  }
}
