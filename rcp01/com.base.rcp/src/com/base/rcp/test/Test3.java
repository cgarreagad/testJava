package com.base.rcp.test;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageData;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.graphics.Region;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;

public class Test3 {

	
	public static void main(String[] args) {
		Display display = new Display();
	    Shell shell = new Shell(display);
	    shell.setLayout(new GridLayout(1, false));
	    shell.setText("StackOverflow");

	    //shell.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
	   // shell.setBackgroundMode(SWT.INHERIT_FORCE);

	    //new Button(shell, SWT.PUSH).setText("Button");
	    //new Label(shell, SWT.NONE).setText("Label");

	    ImageData id = new ImageData("Nuvola_mimetypes_java_jar.png");
	    final Image image = new Image (display, id, id); //3rd parameter is transparency mask
	    Canvas c = new Canvas(shell, SWT.NO_BACKGROUND);
	    //Canvas c = new Canvas (shell, SWT.TRANSPARENT);
	    c.addPaintListener(
	        new PaintListener(){
	            public void paintControl(PaintEvent e) 
	            {
	                e.gc.drawImage(image, 0, 0);
	            }
	        }
	    );
	    
	    Region region = new Region();
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
	    
	    shell.pack();
	    shell.open();

	    while (!shell.isDisposed())
	    {
	        if (!display.readAndDispatch())
	        {
	            display.sleep();
	        }
	    }

	    display.dispose();
	}
	
}
