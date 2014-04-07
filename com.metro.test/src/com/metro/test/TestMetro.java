package com.metro.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.metro.test.ui.MetroShell;


public class TestMetro {
	
	public static void main(String[] args) {
		Display display = new Display();
		//new MetroShell();
		//display.dispose();
		
		
		 //Shell shell = new Shell(display);
		 MetroShell shell = new MetroShell();

	       // shell.addPaintListener(new ColorsPaintListener());

	        shell.setText("Colors");
	        shell.setSize(360, 120);
	        shell.setLocation(300, 300);
	        shell.open();

	        while (!shell.isDisposed()) {
	            if (!display.readAndDispatch()) {
	                display.sleep();
	            }
	        }
		
		
	}

}
