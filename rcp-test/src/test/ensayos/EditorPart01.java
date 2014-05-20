package test.ensayos;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.EditorPart;
import org.eclipse.jface.action.Action;
import org.eclipse.jface.action.IAction;
import org.eclipse.nebula.widgets.cdatetime.CDateTime;
import org.eclipse.nebula.widgets.cdatetime.CDT;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.swt.widgets.Table;
import org.eclipse.swt.widgets.Button;

import rcptest.MessagePopupAction;

public class EditorPart01 extends EditorPart {

	public static final String ID = "test.ensayos.EditorPart01"; //$NON-NLS-1$
	private final FormToolkit formToolkit = new FormToolkit(Display.getDefault());
	private Table table;
	private IAction action;

	public EditorPart01() {
	}

	/**
	 * Create contents of the editor part.
	 * @param parent
	 */
	@Override
	public void createPartControl(Composite parent) {
		Composite container = new Composite(parent, SWT.NONE);
		container.setLayout(new FillLayout(SWT.HORIZONTAL));
		
		Form frmNewForm = formToolkit.createForm(container);
		formToolkit.paintBordersFor(frmNewForm);
		frmNewForm.setText("New Form");
		frmNewForm.getBody().setLayout(new FormLayout());
		
		frmNewForm.getToolBarManager().add(new Action("This is the toolbar") { });
		
		IWorkbenchAction printAction = ActionFactory.PRINT.create(getSite().getWorkbenchWindow());
		frmNewForm.getToolBarManager().add(printAction);
		
		Action myAction = new Action("XXX", null) {
		    @Override
		    public void run() {
		        // Perform action
		    }
		};
		
		MessagePopupAction msg = new MessagePopupAction("ssss",getSite().getWorkbenchWindow());
		
		frmNewForm.getToolBarManager().add(myAction);
		frmNewForm.getToolBarManager().add(msg);
		
		
		
		Section sctnNewSection = formToolkit.createSection(frmNewForm.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		
		FormData fd_sctnInfoSujetoPadre = new FormData();
		fd_sctnInfoSujetoPadre.bottom = new FormAttachment(0, 267);
		fd_sctnInfoSujetoPadre.right = new FormAttachment(100);
		fd_sctnInfoSujetoPadre.top = new FormAttachment(0);
		fd_sctnInfoSujetoPadre.left = new FormAttachment(0);
		sctnNewSection.setLayoutData(fd_sctnInfoSujetoPadre);
		
		
		sctnNewSection.setLayoutData(fd_sctnInfoSujetoPadre);
		formToolkit.paintBordersFor(sctnNewSection);
		sctnNewSection.setText("New Section");
		sctnNewSection.setExpanded(true);
		
		table = formToolkit.createTable(sctnNewSection, SWT.NONE);
		formToolkit.paintBordersFor(table);
		sctnNewSection.setClient(table);
		table.setHeaderVisible(true);
		table.setLinesVisible(true);
		
		Section sctnNewSection_1 = formToolkit.createSection(frmNewForm.getBody(), Section.TWISTIE | Section.TITLE_BAR);
		FormData fd_sctnNewSection_1 = new FormData();
		fd_sctnNewSection_1.top = new FormAttachment(sctnNewSection, 6);
		fd_sctnNewSection_1.left = new FormAttachment(sctnNewSection, 0, SWT.LEFT);
		sctnNewSection_1.setLayoutData(fd_sctnNewSection_1);
		formToolkit.paintBordersFor(sctnNewSection_1);
		sctnNewSection_1.setText("New Section");

	}

	@Override
	public void setFocus() {
		// Set the focus
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// Do the Save operation
	}

	@Override
	public void doSaveAs() {
		// Do the Save As operation
	}

	@Override
	public void init(IEditorSite site, IEditorInput input)
			throws PartInitException {
		// Initialize the editor part
	}

	@Override
	public boolean isDirty() {
		return false;
	}

	@Override
	public boolean isSaveAsAllowed() {
		return false;
	}
}
