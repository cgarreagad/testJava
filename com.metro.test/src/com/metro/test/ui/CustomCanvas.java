package com.metro.test.ui;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseTrackListener;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Composite;

/**
 * Custom Canvas with two little getters: isMouseDown and isMouseOver
 * @author Bandysc
 *
 */
public class CustomCanvas extends Canvas {
	protected boolean isMouseDown;
	protected boolean isMouseOver;

	public CustomCanvas(Composite arg0, int arg1) {
		super(arg0, arg1);
		addMouseListener(new MouseListener() {

			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
			}

			@Override
			public void mouseDown(MouseEvent arg0) {
				isMouseDown = true;
				redraw();
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				isMouseDown = false;
				redraw();
			}
		});
		addMouseTrackListener(new MouseTrackListener() {

			@Override
			public void mouseEnter(MouseEvent arg0) {
				isMouseOver = true;
				redraw();
			}

			@Override
			public void mouseExit(MouseEvent arg0) {
				isMouseOver = false;
				redraw();
			}

			@Override
			public void mouseHover(MouseEvent arg0) {
			}
		});
	}

	public boolean isMouseDown() {
		return isMouseDown;
	}

	public boolean isMouseOver() {
		return isMouseOver;
	}

}
