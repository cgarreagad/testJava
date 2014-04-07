package com.metro.test.ui;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;


public class Shadow extends Shell {

	/**
	 * Create the shell.
	 * @param display
	 */
	public Shadow(Display display) {
		super(display, SWT.NO_TRIM | SWT.ON_TOP);
		initGUI();
	}

	/**
	 * Create contents of the shell.
	 */
	protected void initGUI() {
		setBackground(SWTResourceManager.getColor(0, 0, 0));
		setAlpha(10);
	}

	@Override
	protected void checkSubclass() {
	}

}
