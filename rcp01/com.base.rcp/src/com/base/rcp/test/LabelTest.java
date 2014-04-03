package com.base.rcp.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class LabelTest {
    public static void main(String[] args) 
    {
        final Display display = new Display();
        final Shell shell = new Shell(display);
        shell.setLayout(new FillLayout());
        
       // shell.setBackgroundMode(SWT.INHERIT_FORCE);
        shell.setAlpha(180);
        /*shell = new Shell(SWT.SHELL_TRIM & (~SWT.RESIZE));
        Image img = new Image(display, "./images/myBackground.png");
        shell.setBackgroundImage(img);
        shell.setBackgroundMode(SWT.INHERIT_FORCE);*/
        
        
        /*shell = new Shell(display, SWT.NO_TRIM | SWT.ON_TOP);
        shell.setBounds(display.getClientArea());
        // shell.setFullScreen(true);
        shell.setAlpha(180);
        shell.setForeground(display.getSystemColor(SWT.COLOR_WHITE));
        shell.setBackground(display.getSystemColor(SWT.COLOR_BLACK));
		*/
        
        
        Image image = new Image(display, "Eclipse_Icon_by_TZR_observer.png");

        CLabel label = new CLabel(shell, SWT.BORDER);
        label.setImage(image);
        label.setText("This is a CLabel !!");

        shell.pack();
        shell.open();


        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        if(image != null)
        {
            image.dispose();
            image = null;
        }
        display.dispose();

    }
}