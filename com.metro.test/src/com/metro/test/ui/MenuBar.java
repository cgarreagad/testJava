package com.metro.test.ui;

import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.wb.swt.SWTResourceManager;

public class MenuBar extends Composite {
	protected Menu menu;
	private ArrayList<MenuBarItem> menus = new ArrayList<>();

	public MenuBar(Composite arg0, int arg1) {
		super(arg0, arg1);
		setLayout(new RowLayout());
		setCursor(SWTResourceManager.getCursor(SWT.CURSOR_ARROW));

	}

	@Override
	public void setMenu(Menu menu) {
		this.menu = menu;
		UpdateMenu();
	}


	private void UpdateMenu() {
		for (Control menuItem : menus) {
			menuItem.dispose();
		}
		menus.clear();
		for (MenuItem menuItem : menu.getItems()) {
			menus.add(new MenuBarItem(this, menuItem.getText(), menuItem));
		}
		super.layout(true);
	}
}
