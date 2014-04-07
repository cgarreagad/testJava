package com.metro.test.ui;

import java.awt.MouseInfo;
import java.util.ArrayList;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ControlAdapter;
import org.eclipse.swt.events.ControlEvent;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.events.MouseMoveListener;
import org.eclipse.swt.events.PaintEvent;
import org.eclipse.swt.events.PaintListener;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.events.SelectionListener;
import org.eclipse.swt.events.ShellAdapter;
import org.eclipse.swt.events.ShellEvent;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Cursor;
import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.eclipse.swt.widgets.Monitor;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

public class MetroShell extends Shell {
	protected Color accentColor;
	protected Color borderColor;

	protected CustomCanvas btnClose, btnMinimize, btnMaximize;
	protected Composite cmpContent;
	protected Composite cmpTitleBar;
	protected boolean drawStatusBar;
	protected boolean isMaximized;
	protected boolean isWindowMoving;

	protected boolean isWindowResizing;
	private MenuBar menuBar;
	protected Point oldPos = new Point(0, 0);
	protected Point oldSize = new Point(0, 0);
	protected Rectangle prevSize;
	private boolean resizeable;
	protected ResizeDirection resizeDirection;
	ArrayList<Shadow> shadows = new ArrayList<>();
	ArrayList<Shadow> shadowsBottom = new ArrayList<>();
	ArrayList<Shadow> shadowsLeft = new ArrayList<>();
	ArrayList<Shadow> shadowsRight = new ArrayList<>();
	ArrayList<Shadow> shadowsTop = new ArrayList<>();
	protected boolean isActive;

	public boolean isWindowActive() {
		return isActive;
	}

	public MetroShell() {
		super(SWT.NO_TRIM | SWT.DOUBLE_BUFFERED);
		InitVariables();
	}

	public MetroShell(Display display, int style) {
		super(display, style | SWT.NO_TRIM | SWT.DOUBLE_BUFFERED);
		InitVariables();
	}

	public MetroShell(Shell parent, int style) {
		super(parent, style | SWT.NO_TRIM | SWT.DOUBLE_BUFFERED);
		InitVariables();
	}

	protected void btnClose_MouseUp(MouseEvent arg0) {
		ToggleShadow(false);
		this.dispose();
	}

	protected void btnClose_PaintControl(PaintEvent arg0) {
		GC gc = arg0.gc;
		if (!btnClose.isEnabled())
			gc.setAlpha(60);
		if (btnClose.isMouseOver())
			gc.setForeground(getAccentColor());
		else
			gc.setForeground(getForeground());
		gc.setLineWidth(2);
		gc.drawLine(0, 0, 10, 10);
		gc.drawLine(10, 0, 0, 10);
	}

	protected void btnMaximize_MouseUp(MouseEvent arg0) {
		setMaximized(!isMaximized);
	}

	protected void btnMaximize_PaintControl(PaintEvent arg0) {
		GC gc = arg0.gc;
		if (!btnMaximize.isEnabled())
			gc.setAlpha(60);
		if (btnMaximize.isMouseOver())
			gc.setForeground(getAccentColor());
		else
			gc.setForeground(getForeground());

		gc.setBackground(getBackground());
		gc.setLineWidth(2);
		if (getMaximized()) {
			gc.drawRectangle(4, 1, 7, 5);

			gc.drawRectangle(0, 4, 8, 6);
			gc.fillRectangle(1, 5, 6, 4);

		} else
			gc.drawRectangle(0, 1, 10, 9);
	}

	protected void btnMinimize_MouseUp(MouseEvent arg0) {
		setMinimized(true);

	}

	protected void btnMinimize_PaintControl(PaintEvent arg0) {
		GC gc = arg0.gc;
		if (!btnMinimize.isEnabled())
			gc.setAlpha(60);
		if (btnMinimize.isMouseOver())
			gc.setForeground(getAccentColor());
		else
			gc.setForeground(getForeground());
		gc.setLineWidth(2);
		gc.drawLine(0, 10, 10, 10);
	}

	@Override
	protected void checkSubclass() {
		// Disable the check that prevents subclassing of SWT components
	}

	protected void cmpContent_PaintControl(PaintEvent arg0) {
		if (isDrawStatusBar()) {
			GC gc = arg0.gc;
			gc.setBackground(getBorderColor());
			gc.setForeground(getBorderColor());
			gc.fillRectangle(0, cmpContent.getSize().y - 17,
					cmpContent.getSize().x, 17);
		}
	}

	protected void cmpTitleBar_mouseDown(MouseEvent arg0) {
		if (!isMaximized && (arg0.button == 1)) {
			oldPos.x = arg0.x;
			oldPos.y = arg0.y;
			isWindowMoving = true;
			SetShadowsAlpha(3);
			cmpTitleBar.setCursor(new Cursor(getDisplay(), SWT.CURSOR_SIZEALL));
		}
	}

	protected void cmpTitleBar_mouseMove(MouseEvent arg0) {
		if (isWindowMoving) {
			UpdateShadowsPositon(MouseInfo.getPointerInfo().getLocation().x
					- oldPos.x, MouseInfo.getPointerInfo().getLocation().y
					- oldPos.y);
			this.setLocation(MouseInfo.getPointerInfo().getLocation().x
					- oldPos.x, MouseInfo.getPointerInfo().getLocation().y
					- oldPos.y);
		}

		if (isMaximized && ((arg0.stateMask & SWT.BUTTON1) != 0)
				&& MouseInfo.getPointerInfo().getLocation().y > 10) {
			oldPos.x = (int) (((float) arg0.x / getSize().x) * prevSize.x);
			oldPos.y = (int) (((float) arg0.y / getSize().y) * prevSize.y);
			setMaximized(false, MouseInfo.getPointerInfo().getLocation().x
					- oldPos.x, MouseInfo.getPointerInfo().getLocation().y
					- oldPos.y);
			isWindowMoving = true;
			SetShadowsAlpha(3);
			cmpTitleBar.setCursor(new Cursor(getDisplay(), SWT.CURSOR_SIZEALL));
		}
	}

	protected void cmpTitleBar_mouseUp(MouseEvent arg0) {
		isWindowMoving = false;
		SetShadowsAlpha(30);
		UpdateShadowsPositon(getLocation().x, getLocation().y);
		cmpTitleBar.setCursor(new Cursor(getDisplay(), SWT.CURSOR_ARROW));
		if (MouseInfo.getPointerInfo().getLocation().y < 10) {
			setMaximized(true);
		} else if (MouseInfo.getPointerInfo().getLocation().x < 10) {
			setLocation(getMonitor().getClientArea().x, getMonitor()
					.getClientArea().y);
			setSize(getMonitor().getClientArea().width / 2, getMonitor()
					.getClientArea().height);
			UpdateShadowsPositon(getLocation().x, getLocation().y);
			UpdateShadowsSize();
		} else if (MouseInfo.getPointerInfo().getLocation().x > getDisplay()
				.getPrimaryMonitor().getClientArea().width - 10) {
			setLocation(getMonitor().getClientArea().x
					+ getCurrentMonitor().getClientArea().width / 2,
					getCurrentMonitor().getClientArea().y);
			setSize(getMonitor().getClientArea().width / 2, getMonitor()
					.getClientArea().height);
			UpdateShadowsPositon(getLocation().x, getLocation().y);
			UpdateShadowsSize();
		}
	}

	protected void cmpTitleBar_paintControl(PaintEvent arg0) {
		GC gc = arg0.gc;
		gc.setAdvanced(true);
		gc.setAntialias(SWT.ON);
		gc.setForeground(getForeground());
		gc.setFont(getFont());
		if (getImage() != null)
			gc.drawImage(getImage(), 0, 0, getImage().getBounds().width,
					getImage().getBounds().height, 0, 0, 16, 16);
		gc.drawText(
				getText(),
				(getSize().x - 50 - (getImage() == null ? 16 : 0)) / 2
						- gc.stringExtent(getText()).x / 2, 0);
	}

	@Override
	public void dispose() {
		super.dispose();
		for (Shadow shadow : shadows) {
			shadow.dispose();
		}
	}

	/**
	 * Create contents of the shell.
	 */
	protected void initGUI() {
		addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent arg0) {
				this_paintControl(arg0);
			}
		});
		addMouseMoveListener(new MouseMoveListener() {
			@Override
			public void mouseMove(MouseEvent arg0) {
				this_mouseMove(arg0);
			}
		});
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent arg0) {
				this_mouseDown(arg0);
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				this_mouseUp(arg0);
			}
		});
		addShellListener(new ShellAdapter() {
			@Override
			public void shellActivated(ShellEvent arg0) {
				this_shellActivated(arg0);
			}

			@Override
			public void shellDeactivated(ShellEvent arg0) {
				this_shellDeactivated(arg0);
			}

			@Override
			public void shellDeiconified(ShellEvent arg0) {
				this_ShellDeiconified(arg0);
			}
		});
		addControlListener(new ControlAdapter() {
			@Override
			public void controlMoved(ControlEvent arg0) {
				this_controlMoved(arg0);
			}
		});

		setSize(350, 200);
		setLayout(new GridLayout(2, false));
		setBackgroundMode(SWT.INHERIT_FORCE);
		setCursor(new Cursor(getDisplay(), SWT.CURSOR_SIZEE));
		initShadows();

		MouseListener windowsMoveMouseAdapter = new MouseListener() {
			@Override
			public void mouseDoubleClick(MouseEvent arg0) {
				setMaximized(!isMaximized);
			}

			@Override
			public void mouseDown(MouseEvent arg0) {
				cmpTitleBar_mouseDown(arg0);
			}

			@Override
			public void mouseUp(MouseEvent arg0) {
				cmpTitleBar_mouseUp(arg0);
			}
		};

		MouseMoveListener windowMoveMouseMoveAdapter = new MouseMoveListener() {
			@Override
			public void mouseMove(MouseEvent arg0) {
				cmpTitleBar_mouseMove(arg0);
			}
		};

		cmpTitleBar = new Composite(this, SWT.DOUBLE_BUFFERED);
		GridData titleBarGridData = new GridData(SWT.FILL, SWT.FILL, true,
				false, 1, 3);
		titleBarGridData.heightHint = 20;
		cmpTitleBar.setLayoutData(titleBarGridData);
		cmpTitleBar.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent arg0) {
				cmpTitleBar_paintControl(arg0);
			}
		});
		cmpTitleBar.addMouseMoveListener(windowMoveMouseMoveAdapter);
		cmpTitleBar.addMouseListener(windowsMoveMouseAdapter);
		cmpTitleBar.setCursor(SWTResourceManager.getCursor(SWT.CURSOR_ARROW));
		cmpTitleBar.setBackgroundMode(SWT.INHERIT_DEFAULT);
		cmpTitleBar.setLayout(new GridLayout(3, false));

		Menu popupMenu = new Menu(cmpTitleBar);
		MenuItem mnuMinimize = new MenuItem(popupMenu, SWT.NONE);
		mnuMinimize.setText("Minimize");
		mnuMinimize.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setMinimized(true);
			}
		});
		MenuItem mnuMaximize = new MenuItem(popupMenu, SWT.NONE);
		mnuMaximize.setText("Maximize");
		mnuMaximize.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				setMaximized(true);
			}
		});
		MenuItem mnuClose = new MenuItem(popupMenu, SWT.NONE);
		mnuClose.setText("Close");
		mnuClose.addSelectionListener(new SelectionListener() {

			@Override
			public void widgetDefaultSelected(SelectionEvent arg0) {

			}

			@Override
			public void widgetSelected(SelectionEvent arg0) {
				System.exit(0);
			}
		});
		cmpTitleBar.setMenu(popupMenu);

		btnMinimize = new CustomCanvas(cmpTitleBar, SWT.NONE);
		btnMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent arg0) {
				btnMinimize_MouseUp(arg0);
			}
		});
		btnMinimize.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent arg0) {
				btnMinimize_PaintControl(arg0);
			}
		});
		GridData gd_btnMinimize = new GridData(SWT.RIGHT, SWT.FILL, true,
				false, 1, 1);
		gd_btnMinimize.widthHint = 16;
		gd_btnMinimize.heightHint = 16;
		btnMinimize.setCursor(new Cursor(getDisplay(), SWT.CURSOR_ARROW));
		btnMinimize.setLayoutData(gd_btnMinimize);

		btnMaximize = new CustomCanvas(cmpTitleBar, SWT.NONE);
		btnMaximize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent arg0) {
				btnMaximize_MouseUp(arg0);
			}
		});
		btnMaximize.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent arg0) {
				btnMaximize_PaintControl(arg0);
			}
		});
		GridData gd_btnMaximize = new GridData(SWT.RIGHT, SWT.FILL, false,
				false, 1, 2);
		gd_btnMaximize.widthHint = 16;
		gd_btnMaximize.heightHint = 16;
		btnMaximize.setCursor(new Cursor(getDisplay(), SWT.CURSOR_ARROW));
		btnMaximize.setLayoutData(gd_btnMaximize);

		btnClose = new CustomCanvas(cmpTitleBar, SWT.NONE);
		GridData gd_btnClose = new GridData(SWT.RIGHT, SWT.FILL, false, false,
				1, 3);
		gd_btnClose.widthHint = 16;
		gd_btnClose.heightHint = 16;
		btnClose.setCursor(new Cursor(getDisplay(), SWT.CURSOR_ARROW));
		btnClose.setLayoutData(gd_btnClose);
		btnClose.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent arg0) {
				btnClose_PaintControl(arg0);
			}
		});
		btnClose.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseUp(MouseEvent arg0) {
				btnClose_MouseUp(arg0);
			}
		});

		menuBar = new MenuBar(this, SWT.DOUBLE_BUFFERED);
		GridData menuGridData = new GridData(SWT.FILL, SWT.FILL, true, false,
				2, 1);

		menuBar.setLayoutData(menuGridData);

		cmpContent = new Composite(this, SWT.DOUBLE_BUFFERED);
		cmpContent.addPaintListener(new PaintListener() {
			@Override
			public void paintControl(PaintEvent arg0) {
				cmpContent_PaintControl(arg0);
			}
		});
		cmpContent.setBackgroundMode(SWT.INHERIT_FORCE);
		cmpContent.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true,
				3, 1));
		cmpContent.setCursor(new Cursor(getDisplay(), SWT.CURSOR_ARROW));

	}

	private void InitVariables() {
		initGUI();
		setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		setBorderColor(SWTResourceManager.getColor(43, 87, 154));
		setForeground(SWTResourceManager.getColor(68, 68, 68));
		setAccentColor(SWTResourceManager.getColor(168, 168, 168));
		setShadowColor(getBorderColor());
		setMinimumSize(200, 150);
		setResizeable(true);
	}

	@Override
	public void layout() {
		UpdateShadowsPositon(getLocation().x, getLocation().y);
		super.layout();
		cmpContent.layout();
	}

	@Override
	public void pack() {
		super.pack();
		UpdateShadowsSize();
	}

	@Override
	public void setMinimized(boolean minimized) {
		if (minimized) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					for (int i = 254; i > 0; i -= 2) {
						final int a = i;
						getDisplay().asyncExec(new Runnable() {

							@Override
							public void run() {
								setAlpha(a);
								if (a == 128)
									SetShadowsAlpha(3);
								if (a == 32)
									SetShadowsAlpha(1);
							}
						});
						try {
							Thread.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}

					getDisplay().asyncExec(new Runnable() {

						@Override
						public void run() {
							superMinimize(true);
						}
					});

				}
			}).start();
		} else {
			superMinimize(false);
		}
	}

	private void superMinimize(boolean m) {
		super.setMinimized(m);
	}

	protected void this_controlMoved(ControlEvent arg0) {
		UpdateShadowsPositon(getLocation().x, getLocation().y);
	}

	protected void this_mouseDown(MouseEvent arg0) {
		if (!isMaximized && isResizeable()) {
			ToggleShadow(false);

			isWindowResizing = true;
			oldPos.x = getLocation().x;
			oldPos.y = getLocation().y;
			oldSize.x = getBounds().width;
			oldSize.y = getBounds().height;
		}
	}

	protected void this_mouseMove(MouseEvent arg0) {
		if (!isMaximized && isResizeable()) {
			int curX = arg0.x;
			int curY = arg0.y;
			int width = getSize().x;
			int height = getSize().y;

			if (!isWindowResizing) {
				resizeDirection = ResizeDirection.None;
				if (curY > height - 6) {
					if (curX < 6)
						resizeDirection = ResizeDirection.SW;
					else if (curX > width - 6)
						resizeDirection = ResizeDirection.SE;
					else
						resizeDirection = ResizeDirection.S;
				} else if (curY < 6) {
					if (curX < 6)
						resizeDirection = ResizeDirection.NW;
					else if (curX > width - 6)
						resizeDirection = ResizeDirection.NE;
					else
						resizeDirection = ResizeDirection.N;
				} else {
					if (curX < 6)
						resizeDirection = ResizeDirection.W;
					else if (curX > getSize().x - 6)
						resizeDirection = ResizeDirection.E;
				}
			}

			setCursor(new Cursor(getDisplay(), resizeDirection.cursor));
			if (isWindowResizing) {
				curX = MouseInfo.getPointerInfo().getLocation().x;
				curY = MouseInfo.getPointerInfo().getLocation().y;
				int newX = -1;
				int newY = -1;
				switch (resizeDirection) {
				case SE:
					width = curX - getLocation().x;
					height = curY - getLocation().y;
					break;
				case S:
					width = getSize().x;
					height = curY - getLocation().y;
					break;
				case E:
					width = curX - getLocation().x;
					height = getSize().y;
					break;
				case SW:
					newX = curX;
					newY = getLocation().y;
					width = oldSize.x + (oldPos.x - curX);
					height = curY - getLocation().y;
					break;
				case W:
					newX = curX;
					newY = getLocation().y;
					width = oldSize.x + (oldPos.x - curX);
					height = getSize().y;
					break;
				case N:
					width = getSize().x;
					height = oldSize.y + oldPos.y - curY;
					newY = curY;
					break;
				case NW:
					newX = curX;
					newY = curY;
					width = oldSize.x + (oldPos.x - curX);
					height = oldSize.y + oldPos.y - curY;
					break;
				case NE:
					width = curX - getLocation().x;
					height = oldSize.y + oldPos.y - curY;
					newY = curY;
					break;
				default:
					break;
				}
				setSize(Math.max(width, this.getMinimumSize().x),
						Math.max(height, this.getMinimumSize().y), false);
				if (newX > -1 && width > 100)
					setLocation(newX, getLocation().y);
				if (newY > -1 && height > 100)
					setLocation(getLocation().x, newY);
			}
		} else {
			setCursor(new Cursor(getDisplay(), SWT.CURSOR_ARROW));
		}
	}

	protected void this_mouseUp(MouseEvent arg0) {
		if (!isMaximized) {
			isWindowResizing = false;
			UpdateShadowsSize();
			SetShadowsAlpha(10);
			UpdateShadowsPositon(getLocation().x, getLocation().y);
			ToggleShadow(true);
		}
	}

	protected void this_paintControl(PaintEvent arg0) {
		GC gc = arg0.gc;
		gc.setBackground(getForeground());
		gc.drawRectangle(getSize().x - 10, getSize().y - 10, 5, 5);
		if (getBorderColor() != null) {
			if (isWindowActive())
				gc.setForeground(getBorderColor());
			else
				gc.setForeground(SWTResourceManager.getColor(128,128,128));
			gc.drawRectangle(0, 0, getSize().x - 1, getSize().y - 1);
		}
		if (isDrawStatusBar()) {
			gc.setBackground(getBorderColor());
			gc.setForeground(getBorderColor());
			gc.fillRectangle(0, getSize().y - 22, getSize().x, 22);
		}
	}

	protected void this_shellActivated(ShellEvent arg0) {
		isActive=true;
		ToggleShadow(true);
		UpdateShadowsPositon(getLocation().x, getLocation().y);
		redraw();
	}

	protected void this_shellDeactivated(ShellEvent arg0) {
		isActive=false;
		ToggleShadow(false);
		redraw();
	}

	protected void this_ShellDeiconified(ShellEvent arg0) {
		setAlpha(255);
		if (!getMaximized())
			SetShadowsAlpha(10);
	}

	// region SHADOWS

	public void setShadowColor(Color color) {
		for (Shadow shadow : shadows) {
			shadow.setBackground(color);
		}
	}

	protected void SetShadowsAlpha(int alpha) {
		for (Shadow shadow : shadows) {
			shadow.setAlpha(alpha);
		}
	}

	protected void ToggleShadow(boolean b) {
		for (Shadow shadow : shadows) {
			shadow.setVisible(b);
		}
	}

	protected void UpdateShadowsPositon(int x, int y) {

		for (int i = 0; i < shadowsBottom.size(); i++) {
			shadowsBottom.get(i).setLocation(x - (shadowsBottom.size() - i),
					y + getSize().y);
			shadowsLeft.get(i).setLocation(x - (shadowsBottom.size() - i), y);
			shadowsRight.get(i).setLocation(x + getSize().x, y);
			shadowsTop.get(i).setLocation(x - (shadowsBottom.size() - i),
					y - (shadowsBottom.size() - i));

		}
	}

	private void UpdateShadowsSize() {
		int max = shadowsBottom.size();
		for (int i = 0; i < shadowsBottom.size(); i++) {
			shadowsRight.get(i).setSize(max - i, getSize().y);
			shadowsLeft.get(i).setSize(max - i, getSize().y);
			shadowsTop.get(i).setSize(getSize().x + (max - i) * 2, max - i);
			shadowsBottom.get(i).setSize(getSize().x + (max - i) * 2, max - i);
		}
	}

	private void initShadows() {
		int SHADOWS = 6;
		for (int i = SHADOWS; i > 0; i--) {
			Shadow temp = new Shadow(getDisplay());
			temp.setSize(getSize().x + i * 2, i);
			temp.setBackground(SWTResourceManager.getColor((i) * 5, (i) * 5,
					(i) * 5));
			shadowsBottom.add(temp);
			shadows.add(temp);
			temp.open();
		}
		for (int i = SHADOWS; i > 0; i--) {
			Shadow temp = new Shadow(getDisplay());
			temp.setSize(getSize().x + i * 2, i);
			temp.setBackground(SWTResourceManager.getColor((i) * 5, (i) * 5,
					(i) * 5));
			shadowsTop.add(temp);
			shadows.add(temp);
			temp.open();
		}

		for (int i = SHADOWS; i > 0; i--) {
			Shadow temp = new Shadow(getDisplay());
			temp.setSize(i, getSize().y);
			temp.setBackground(SWTResourceManager.getColor((i) * 5, (i) * 5,
					(i) * 5));
			shadowsLeft.add(temp);
			shadows.add(temp);
			temp.open();
		}

		for (int i = SHADOWS; i > 0; i--) {
			Shadow temp = new Shadow(getDisplay());
			temp.setSize(i, getSize().y);
			temp.setBackground(SWTResourceManager.getColor((i) * 5, (i) * 5,
					(i) * 5));
			shadowsRight.add(temp);
			shadows.add(temp);
			temp.open();
		}
	}

	// endregion SHADOWS

	// region GETTERS AND SETTERS

	public boolean isDrawStatusBar() {
		return drawStatusBar;
	}

	public boolean isResizeable() {
		return resizeable;
	}

	public void setAccentColor(Color accentColor) {
		this.accentColor = accentColor;
	}

	public void setBorderColor(Color borderColor) {
		this.borderColor = borderColor;
		setShadowColor(borderColor);

	}

	public void setDrawStatusBar(boolean drawStatusBar) {
		this.drawStatusBar = drawStatusBar;
	}

	/*
	 * Bug in GTK. When minimizing the shell is moved to (0, 0).
	 */
	public void setMaximized(boolean maximized, int x, int y) {
		if (!isResizeable())
			return;
		if (maximized) {
			ToggleShadow(false);
			SetShadowsAlpha(0);
			if (!isMaximized) {
				prevSize = getBounds();
			}
			setBounds(getCurrentMonitor().getClientArea());
		} else {
			this.isMaximized = false;
			if (prevSize != null) {
				setBounds(x, y, prevSize.width, prevSize.height);
			}
			UpdateShadowsSize();
			ToggleShadow(true);

		}
		this.isMaximized = maximized;
	}

	@Override
	public void setMaximized(boolean maximized) {
		int x = 0;
		int y = 0;
		if (prevSize != null) {
			x = prevSize.x;
			y = prevSize.y;
		}
		setMaximized(maximized, x, y);
	}

	public void setResizeable(boolean resizeable) {
		this.resizeable = resizeable;
		btnMaximize.setEnabled(resizeable);
	}

	@Override
	public void setBounds(Rectangle rect) {
		if (!isResizeable()) {
			rect.width = getSize().x;
			rect.height = getSize().y;
		}
		super.setBounds(rect);
		UpdateShadowsPositon(rect.x, rect.y);
		UpdateShadowsSize();
	}

	public void setBounds(int x, int y, int width, int height,
			boolean updateShadow) {
		if (!isResizeable()) {
			width = getSize().x;
			height = getSize().y;
		}
		super.setBounds(x, y, width, height);
		if (updateShadow) {
			UpdateShadowsPositon(x, y);
			UpdateShadowsSize();
		}
	}

	@Override
	public void setBounds(int x, int y, int width, int height) {
		setBounds(x, y, width, height, true);
	}

	public void setSize(int width, int height, boolean updateShadow) {
		super.setSize(width, height);
		if (updateShadow)
			UpdateShadowsSize();
	}

	@Override
	public void setSize(int width, int height) {
		setSize(width, height, true);
	}

	@Override
	public void setSize(Point point) {
		super.setSize(point);
		UpdateShadowsSize();
	}

	@Override
	public void setMenuBar(Menu menu) {
		menuBar.setMenu(menu);
	}

	public Color getAccentColor() {
		return accentColor;
	}

	public Color getBorderColor() {
		return borderColor;
	}

	public Composite getCmpTitleBar() {
		return cmpTitleBar;
	}

	public Composite getContent() {
		return cmpContent;
	}

	private Monitor getCurrentMonitor() {
		Monitor monior = null;
		Point mouse = getDisplay().getCursorLocation();
		for (Monitor m : getDisplay().getMonitors()) {
			if (m.getBounds().contains(mouse)) {
				monior = m;
				break;
			}
		}
		return monior;
	}

	@Override
	public boolean getMaximized() {
		return isMaximized;
	}

	// endregion GETTERS AND SETTERS
}
