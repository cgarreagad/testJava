package com.base.rcp.test;

import org.eclipse.swt.*;
import org.eclipse.swt.graphics.*;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.events.*;
public class Talpha {
        /**
         * @param args
         */
        public static void main(String[] args) {
                // TODO Auto-generated method stub
                final Display display = new Display();
                final Shell shell = new Shell(display);
                shell.setBackground(display.getSystemColor(SWT.COLOR_BLUE));
                Canvas canvas = new Canvas(shell, SWT.NO_BACKGROUND);
                // paintlistener， 。
                canvas.addPaintListener(new PaintListener() {
                        public void paintControl(PaintEvent e) {
                                GC gc = e.gc;
                        // 
                        ImageData imageData = new ImageData("Nuvola_mimetypes_java_jar.png");
                                 // Alpha。
                   byte[] alphaValues = new byte[imageData.height * imageData.width];
                                for (int j = 0; j < imageData.height; j++) {
                                        for (int i = 0; i < imageData.width; i++) {
                              alphaValues[j * imageData.width + i] = (byte) (255 - 255
                                                                * i / imageData.width);
                                        }
                                }
                                imageData.alphaData = alphaValues;
                                Image image = new Image(display, imageData);
                         //                                
                        gc.drawImage(image,0,0);
                        }
                });
                FillLayout fillLayout = new FillLayout();
                fillLayout.type = SWT.VERTICAL;
                shell.setLayout(fillLayout);
                shell.setSize(200, 600);
                shell.open();
                while (!shell.isDisposed()) {
                        if (!display.readAndDispatch())
                                display.sleep();
                }
                display.dispose();
        }
}