package com.sysma.goat.eclipse_plugin.generator

import org.eclipse.emf.ecore.resource.ResourceSet
import org.eclipse.xtext.generator.IFileSystemAccess
import org.eclipse.xtext.generator.IGenerator

interface IGeneratorMulti extends IGenerator {
    /**
     * @param input - the input for which to generate resources
     * @param fsa - file system access to be used to generate files
     */
    def void doGenerate(ResourceSet input, IFileSystemAccess fsa)
}

