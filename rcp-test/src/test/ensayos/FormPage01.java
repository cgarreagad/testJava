package test.ensayos;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.SWT;

public class FormPage01 extends FormPage {
	private Table table;

	/**
	 * Create the form page.
	 * @param id
	 * @param title
	 */
	public FormPage01(String id, String title) {
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
	public FormPage01(FormEditor editor, String id, String title) {
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
		form.setText("Empty FormPage");
		
		Composite body = form.getBody();
		toolkit.decorateFormHeading(form.getForm());
		toolkit.paintBordersFor(body);
		managedForm.getForm().getBody().setLayout(new FormLayout());
		
		
		FormData fd_cEditorSujetos = new FormData();
		fd_cEditorSujetos.bottom = new FormAttachment(100, -5);
		fd_cEditorSujetos.right = new FormAttachment(100, -5);
		fd_cEditorSujetos.top = new FormAttachment(0, 5);
		fd_cEditorSujetos.left = new FormAttachment(0, 5);
		managedForm.getForm().getBody().setLayoutData(fd_cEditorSujetos);
		
		
		
		
		
		
		Section sctnNewSection = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		FormData fd_sctnInfoSujetoPadre = new FormData();
		fd_sctnInfoSujetoPadre.right = new FormAttachment(100);
		fd_sctnInfoSujetoPadre.top = new FormAttachment(0);
		fd_sctnInfoSujetoPadre.left = new FormAttachment(0);
		sctnNewSection.setLayoutData(fd_sctnInfoSujetoPadre);
		//sctnNewSection.setBounds(10, 10, 362, 89);
		managedForm.getToolkit().paintBordersFor(sctnNewSection);
		sctnNewSection.setText("New Section");
		
		table = managedForm.getToolkit().createTable(sctnNewSection, SWT.NONE);
		sctnNewSection.setClient(table);
		managedForm.getToolkit().paintBordersFor(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Section sctnNewSection_1 = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.TWISTIE | Section.TITLE_BAR);
		FormData fd_sctnNewSection_1 = new FormData();
		fd_sctnNewSection_1.top = new FormAttachment(sctnNewSection, 6);
		fd_sctnNewSection_1.left = new FormAttachment(sctnNewSection, 0, SWT.LEFT);
		sctnNewSection_1.setLayoutData(fd_sctnNewSection_1);
		managedForm.getToolkit().paintBordersFor(sctnNewSection_1);
		sctnNewSection_1.setText("New Section");
	}
}
