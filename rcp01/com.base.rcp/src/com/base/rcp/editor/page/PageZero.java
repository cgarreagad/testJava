package com.base.rcp.editor.page;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.swt.layout.GridData;

public class PageZero extends FormPage {
	private Text text;

	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public PageZero(String id, String title) {
		super(id, title);
	}

	/**
	 * Create the form page.
	 * @param editor
	 * @param id
	 * @param title
	 * @wbp.parser.constructor
	 * @wbp.eval.method.parameter id "Some id"
	 * @wbp.eval.method.parameter title "Some title"
	 */
	public PageZero(FormEditor editor, String id, String title) {
		super(editor, id, title);
	}

	/**
	 * Create contents of the form.
	 * @param managedForm
	 */
	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		form.setText("<Datos Cabecera>");
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FormLayout());
		
		Composite cpMain = new Composite(managedForm.getForm().getBody(), SWT.NONE);
		cpMain.setLayout(new FormLayout());
		FormData fd_cpMain = new FormData();
		fd_cpMain.left = new FormAttachment(0);
		fd_cpMain.bottom = new FormAttachment(100, 64);
		fd_cpMain.right = new FormAttachment(100);
		fd_cpMain.top = new FormAttachment(0);
		cpMain.setLayoutData(fd_cpMain);
		managedForm.getToolkit().adapt(cpMain);
		managedForm.getToolkit().paintBordersFor(cpMain);
		
		Section sctnDetail = managedForm.getToolkit().createSection(cpMain, Section.TWISTIE | Section.TITLE_BAR);
		FormData fd_sctnDetail = new FormData();
		fd_sctnDetail.top = new FormAttachment(0);
		fd_sctnDetail.left = new FormAttachment(0);
		fd_sctnDetail.right = new FormAttachment(100);
		sctnDetail.setLayoutData(fd_sctnDetail);
		sctnDetail.setBounds(10, 10, 362, 89);
		managedForm.getToolkit().paintBordersFor(sctnDetail);
		
		sctnDetail.setText("<Detalle Section>");
		sctnDetail.setExpanded(true);
		
		Composite cmpDetalleCab = new Composite(sctnDetail, SWT.NONE);
		managedForm.getToolkit().adapt(cmpDetalleCab);
		managedForm.getToolkit().paintBordersFor(cmpDetalleCab);
		sctnDetail.setClient(cmpDetalleCab);
		GridLayout gl_cmpDetalleCab = new GridLayout(2, false);
		gl_cmpDetalleCab.marginWidth = 0;
		gl_cmpDetalleCab.marginHeight = 0;
		gl_cmpDetalleCab.verticalSpacing = 2;
		cmpDetalleCab.setLayout(gl_cmpDetalleCab);
		
		Label lblId = new Label(cmpDetalleCab, SWT.NONE);
		lblId.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, false, false, 1, 1));
		lblId.setBounds(0, 0, 49, 13);
		managedForm.getToolkit().adapt(lblId, true, true);
		lblId.setText("Identificaci\u00F3n");
		
		text = new Text(cmpDetalleCab, SWT.BORDER);
		text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		managedForm.getToolkit().adapt(text, true, true);
	}
}
