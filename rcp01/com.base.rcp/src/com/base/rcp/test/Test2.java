package com.base.rcp.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Font;
import org.eclipse.swt.graphics.FontData;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Shell;

public class Test2 {

    public static void main(String[] args) {
        Test2 test = new Test2();

        test.show();
    }

    public void show() {
        Display display = new Display();
        // Create a shell with no trim
        //final Shell shell = new Shell(display, SWT.NO_TRIM);
        final Shell shell = new Shell(display);
        shell.setForeground(display.getSystemColor(SWT.COLOR_WHITE));

                
        ImageData id = new ImageData("Eclipse_Icon_by_TZR_observer.png");
        final Image image = new Image (display, "Eclipse_Icon_by_TZR_observer.png"); //3rd parameter is transparency mask
       
        Canvas c = new Canvas(shell, SWT.NO_BACKGROUND);
        
      //create an area to paint the text
        Rectangle size = new Rectangle(0, 0, 500, 500);
        c.setBounds(size);
        
        //Canvas c = new Canvas (shell, SWT.TRANSPARENT);
        c.addPaintListener(
            new PaintListener(){
                public void paintControl(PaintEvent e) 
                {
                    e.gc.drawImage(image, 100, 100);
                }
            }
        );
        
        
 
        //the image has been created, with transparent regions. Now set the active region
        //so that mouse click (enter, exit etc) events only fire when they occur over
        //visible pixels. If you're not worried about this ignore the code that follows
        /*Region region = new Region();
        Rectangle pixel = new Rectangle(0, 0, 1, 1);
        for (int y = 0; y < id.height; y++)
        {
            for (int x = 0; x < id.width; x++)
            {
                if (id.getAlpha(x,y) > 0)
                {
                    pixel.x = id.x + x;
                    pixel.y = id.y + y;
                    region.add(pixel);
                }
            }
        }
        c.setRegion(region);
        */
        
        
        

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        //region.dispose();
        display.dispose();
    }
}