package com.sysma.goat.eclipse_plugin.ui

import org.eclipse.debug.ui.ILaunchShortcut
import org.eclipse.jface.viewers.ISelection
import org.eclipse.ui.IEditorPart
import org.eclipse.core.resources.IProject
import org.eclipse.jface.viewers.IStructuredSelection
import org.eclipse.core.resources.IFolder
import org.eclipse.core.resources.IFile
import org.eclipse.ui.PlatformUI
import org.eclipse.ui.console.IConsoleConstants
import org.eclipse.ui.PartInitException
import org.eclipse.ui.console.IOConsole
import org.eclipse.ui.console.ConsolePlugin
import org.eclipse.ui.console.IConsoleView

class RunProject implements ILaunchShortcut {
	
	def private showConsoleView(IOConsole myConsole){
		try {
			val wb = PlatformUI.getWorkbench();
		    val win = wb.getActiveWorkbenchWindow();
		    if(win !== null) {
		    	val page = win.getActivePage();
		    	if(page !== null) {
		    		val id = IConsoleConstants.ID_CONSOLE_VIEW;
	    		    val view = page.showView(id) as IConsoleView;
	    		    view.display(myConsole);
		    	}
		    }
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/*
		See https://wiki.eclipse.org/FAQ_How_do_I_write_to_the_console_from_a_plug-in%3F
	 */
   def private Console findConsole(String name) {
      val plugin = ConsolePlugin.getDefault()
      val conMan = plugin.getConsoleManager()
      val existing = conMan.getConsoles()
      val existConsole = existing.filter[it.name.equals(name)]
      if(existConsole.length > 0)
      	 existConsole.head as Console
  	  else {
  	  	val myConsole = new Console(name, null)
      	conMan.addConsoles(#{myConsole})
      	myConsole
  	  }
   }
	
	override launch(ISelection selection, String mode) {
		var IProject project_
		try {
			val structured = selection as IStructuredSelection
			if (structured.size == 1) {
				project_ = structured.getFirstElement as IProject;
			}
		} catch(ClassCastException cce) {}
		if(project_ === null)
			throw new UnsupportedOperationException("Launch on a project!")
			
		val project = project_
		val projectPath = project.location
		val srcDir = project.projectRelativePath.append("src")
		
		getServers(project.getFolder(srcDir)).forEach[
			val fPath = it.projectRelativePath.makeRelativeTo(srcDir)
			val console = findConsole(fPath.toString)
			new RunServer(projectPath, fPath, console).launch()
			showConsoleView(console)
		]
		
		getComponents(project.getFolder(srcDir)).forEach[
			val fPath = it.projectRelativePath.makeRelativeTo(srcDir)
			val console = findConsole(fPath.toString)
			new RunComponent(projectPath, fPath, console).launch()
			showConsoleView(console)
		]
	}
	
	def private static Iterable<IFile> getServers(IFolder srcDir){
		srcDir.members.
			filter[it instanceof IFile && (it as IFile).fileExtension == "ginf"].
			map[it as IFile]
			+
		srcDir.members.
			filter[it instanceof IFolder].
			map[getServers(it as IFolder)].flatten
	}
	
	def private static Iterable<IFile> getComponents(IFolder srcDir){
		srcDir.members.
			filter[it instanceof IFile && (it as IFile).fileExtension == "goat"].
			map[it as IFile]
			+
		srcDir.members.
			filter[it instanceof IFolder].
			map[getComponents(it as IFolder)].flatten
	}
	
	override launch(IEditorPart editor, String mode) {
		throw new UnsupportedOperationException()
	}
	
}
