package com.metro.test.ui;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Event;
import org.eclipse.swt.widgets.Listener;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class MenuBarItem extends CustomCanvas {
	private Menu menu;
	private String text;

	public MenuBarItem(MenuBar menuBar, String text, MenuItem menuItem) {
		super(menuBar, 0);
		this.text = text;
		setMenu(menuItem);
		setCursor(SWTResourceManager.getCursor(SWT.CURSOR_ARROW));
		initGUI();
	
	}
	
	public void setMenu(MenuItem menuItem) {
		this.menu = menuItem.getMenu();
		//Not sure if it is the best way to handle SWT.Selection.
		for (final Listener listener : menuItem.getListeners(SWT.Selection)) {
			this.addListener(SWT.MouseDown, new Listener() {
				
				@Override
				public void handleEvent(Event arg0) {
					arg0.type=SWT.Selection;
					listener.handleEvent(arg0);
					isMouseDown=false;
				}
			});
		}
	}

	@Override
	public MenuBar getParent() {
		return (MenuBar)super.getParent();
	}

	private void initGUI() {
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				this_mouseDown(arg0);
			}
		});
		addPaintListener(new PaintListener() {
			public void paintControl(PaintEvent arg0) {
				this_paintControl(arg0);
			}
		});
	}


	@Override
	public Point computeSize(int wHint, int hHint, boolean changed) {
		Point size = new Point(0, 0);

		GC gc = new GC(this);

		size = gc.textExtent(getText().toUpperCase());
		size.x += 10;
		size.y += 6;
		return size;
	}

	protected void this_paintControl(PaintEvent arg0) {
		GC gc = arg0.gc;
		gc.setForeground(getParent().getParent().getForeground());
		if (isMouseOver()) {
			gc.setBackground(SWTResourceManager.getColor(220, 220, 220));
			gc.fillRectangle(0, 0, getSize().x, getSize().y);
		}
		if (isMouseDown()) {
			gc.setBackground(SWTResourceManager.getColor(200, 200, 200));
			gc.fillRectangle(0, 0, getSize().x, getSize().y);
		}

		gc.drawText(getText().toUpperCase(), 5, 3);
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	private Menu ReproduceMenu(Menu srcMenu) {
		Menu menu = new Menu(this);
		for (MenuItem menuItem : srcMenu.getItems()) {
			MenuItem m = new MenuItem(menu, menuItem.getStyle());
			
			m.setText(menuItem.getText());
			for (Listener listener : menuItem.getListeners(SWT.Selection)) {
				menu.addListener(SWT.Selection, listener);
			}
			for (Listener listener : menuItem.getListeners(SWT.Arm)) {
				m.addListener(SWT.Arm, listener);
			}
			for (Listener listener : menuItem.getListeners(SWT.Help)) {
				m.addListener(SWT.Help, listener);
			}
				
			if (menuItem.getMenu()!=null) {
				m.setMenu(menuItem.getMenu());
			}
		}
		return menu;
	}

	protected void this_mouseDown(MouseEvent arg0) {
		if (menu != null) {
			Menu menu = ReproduceMenu(this.menu);
			menu.setLocation(toDisplay(0, getSize().y));
			menu.setVisible(true);
	
			
			while (!menu.isDisposed() && menu.isVisible()) {
		          if (!getDisplay().readAndDispatch())
		            getDisplay().sleep();
		        }
		       isMouseDown=false;
		       isMouseOver=false;
		       redraw();
		}

	}
}
