package com.sysma.goat.eclipse_plugin.ui;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.console.IConsole;
import org.eclipse.ui.console.IConsoleConstants;
import org.eclipse.ui.console.IConsolePageParticipant;
import org.eclipse.ui.part.IPageBookViewPage;
import org.eclipse.ui.part.IPageSite;

public class ConsoleActions implements IConsolePageParticipant {

    private IPageBookViewPage page;
    private Action stop;
    private IActionBars bars;
    //private IConsole console;
    private Process process;

    @Override
    public void init(final IPageBookViewPage page, final IConsole console) {
        //this.console = console;
        this.page = page;
        IPageSite site = page.getSite();
        this.bars = site.getActionBars();

        createTerminateButton();
        //createRemoveButton();

        //bars.getMenuManager().add(new Separator());
        //bars.getMenuManager().add(remove);

        IToolBarManager toolbarManager = bars.getToolBarManager();

        toolbarManager.appendToGroup(IConsoleConstants.LAUNCH_GROUP, stop);
        //toolbarManager.appendToGroup(IConsoleConstants.LAUNCH_GROUP,remove);

        bars.updateActionBars();
        ((Console)console).setObserver(this);

    }

    public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
		new Thread(new Runnable() {
			@Override
			public void run() {
				Display.getDefault().syncExec(new Runnable(){
					public void run() {
						updateVis();
					}
				});
				while(true) {
					try {
						process.waitFor();
						break;
					} catch(InterruptedException x) {}
				}
				Display.getDefault().syncExec(new Runnable(){
					public void run() {
						updateVis();
					}
				});
			}
		}).start();
		
	}

	private void createTerminateButton() {
        ImageDescriptor imageDescriptor = ImageDescriptor.createFromImage(PlatformUI.getWorkbench().getSharedImages().getImage(ISharedImages.IMG_ELCL_STOP)); 
        this.stop = new Action("Terminate", imageDescriptor) {
            public void run() {
            	process.children().forEach(p -> p.destroy());
                process.destroy();
            }
        };
    }

    @Override
    public void dispose() {
        stop = null;
        bars = null;
        page = null;
    }

    @SuppressWarnings("unchecked")
	@Override
    public Object getAdapter(@SuppressWarnings("rawtypes") Class adapter) {
        return null;
    }

    @Override
    public void activated() {
        updateVis();
    }

    @Override
    public void deactivated() {
        updateVis();
    }

    private void updateVis() {
        if (page == null)
            return;
        boolean isEnabled = process != null && process.isAlive();
        stop.setEnabled(isEnabled);
        bars.updateActionBars();
    }


}
