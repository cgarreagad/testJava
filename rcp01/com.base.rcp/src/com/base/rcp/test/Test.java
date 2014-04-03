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
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();

        test.show();
    }

    public void show() {
        Display display = new Display();
        // Create a shell with no trim
        //final Shell shell = new Shell(display, SWT.NO_TRIM);
        final Shell shell = new Shell(display);
        shell.setForeground(display.getSystemColor(SWT.COLOR_WHITE));

        //set the transparent canvas on the shell
        Canvas canvas = new Canvas(shell, SWT.NO_BACKGROUND);

        //create an area to paint the text
        Rectangle size = new Rectangle(0, 0, 500, 500);
        canvas.setBounds(size);

        Region region = canvas.getRegion();

        //mucking about with fonts
        Font font = display.getSystemFont();

        FontData[] fd = font.getFontData();

        fd[0].setHeight(24);
        fd[0].setStyle(SWT.BOLD);

        Font bigFont = new Font(display, fd[0]);
        canvas.setFont(bigFont);

        // define the shape of the shell using setRegion
        shell.setRegion(region);
        shell.setSize(size.width, size.height);

        ImageData id = new ImageData("Eclipse_Icon_by_TZR_observer.png");
        final Image image = new Image(display, "Eclipse_Icon_by_TZR_observer.png");
        canvas.addPaintListener(new PaintListener() {
            public void paintControl(PaintEvent e) {
               // e.gc.drawString("Hello", 10, 10, true);
                e.gc.drawImage(image, 100, 100);
            }
        });
        
      //the image has been created, with transparent regions. Now set the active region
        //so that mouse click (enter, exit etc) events only fire when they occur over
        //visible pixels. If you're not worried about this ignore the code that follows
        Region region1 = new Region();
        Rectangle pixel = new Rectangle(100, 100, 1, 1);
        for (int y = 0; y < id.height; y++)
        {
            for (int x = 0; x < id.width; x++)
            {
                if (id.getAlpha(x,y) > 0)
                {
                    pixel.x = id.x + x;
                    pixel.y = id.y + y;
                    region1.add(pixel);
                }
            }
        }
        canvas.setRegion(region1);
        
        Button b = new Button(shell, SWT.PUSH);
    	//b.setBackground(shell.getBackground());
    	b.setText("close");
    	b.pack();
    	b.setLocation(250, 200);

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        region.dispose();
        display.dispose();
    }
}