package ec.gob.sri.dimm.factory.editors.pages;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.forms.IManagedForm;
import org.eclipse.ui.forms.editor.FormEditor;
import org.eclipse.ui.forms.editor.FormPage;
import org.eclipse.ui.forms.widgets.ColumnLayout;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;


import org.eclipse.swt.SWT;
import org.eclipse.ui.forms.widgets.ColumnLayoutData;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Table;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.TableColumn;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.custom.CLabel;
import org.eclipse.swt.layout.FormLayout;
import org.eclipse.swt.layout.FormData;
import org.eclipse.swt.layout.FormAttachment;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.ui.forms.widgets.ExpandableComposite;



public class PaginaSaldoFavor extends FormPage {
	private Table table;

	public PaginaSaldoFavor(FormEditor editor, String id, String title) {
		super(editor, id, title);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void createFormContent(IManagedForm managedForm) {
		FormToolkit toolkit = managedForm.getToolkit();
		ScrolledForm form = managedForm.getForm();
		Composite body = form.getBody();
		toolkit.paintBordersFor(body);
		ColumnLayout columnLayout = new ColumnLayout();
		columnLayout.maxNumColumns = 1;
		managedForm.getForm().getBody().setLayout(columnLayout);
		
		form.setText("Saldos a Favor del Contribuyente");
		
		
		Section sctnDiferimientos = managedForm.getToolkit().createSection(managedForm.getForm().getBody(), Section.EXPANDED | Section.TITLE_BAR);
		ColumnLayoutData cld_sctnDiferimientos = new ColumnLayoutData();
		cld_sctnDiferimientos.heightHint = 456;
		sctnDiferimientos.setLayoutData(cld_sctnDiferimientos);
		managedForm.getToolkit().paintBordersFor(sctnDiferimientos);
		sctnDiferimientos.setText("Detalle Saldos a Favor");
		
		Composite cmpMain = new Composite(sctnDiferimientos, SWT.NONE);
		managedForm.getToolkit().adapt(cmpMain);
		managedForm.getToolkit().paintBordersFor(cmpMain);
		sctnDiferimientos.setClient(cmpMain);
		cmpMain.setLayout(new FormLayout());
		
		Composite cmpSaldos = new Composite(cmpMain, SWT.NONE);
		cmpSaldos.setLayout(new FormLayout());
		cmpSaldos.setLayoutData(new FormData());
		managedForm.getToolkit().adapt(cmpSaldos);
		managedForm.getToolkit().paintBordersFor(cmpSaldos);
		//TABLA
		
		TableViewer tvSaldos = new TableViewer(cmpSaldos, SWT.BORDER | SWT.FULL_SELECTION);
		table = tvSaldos.getTable();
		table.setLayoutData(new FormData());
		//table.setLayoutData(fd_table);
		table.setLinesVisible(true);
		table.setHeaderVisible(true);
		managedForm.getToolkit().paintBordersFor(table);
		
		TableViewerColumn tableViewerColumn = new TableViewerColumn(tvSaldos, SWT.NONE);
		TableColumn tcConcepto = tableViewerColumn.getColumn();
		tcConcepto.setAlignment(SWT.CENTER);
		tcConcepto.setWidth(325);
		tcConcepto.setText("Concepto");
		
		TableViewerColumn tableViewerColumn_1 = new TableViewerColumn(tvSaldos, SWT.NONE);
		TableColumn tcValor = tableViewerColumn_1.getColumn();
		tcValor.setAlignment(SWT.CENTER);
		tcValor.setWidth(149);
		tcValor.setText("Valor");
		
		TableViewerColumn tableViewerColumn_2 = new TableViewerColumn(tvSaldos, SWT.NONE);
		TableColumn tblclmnEliminar = tableViewerColumn_2.getColumn();
		tblclmnEliminar.setAlignment(SWT.CENTER);
		tblclmnEliminar.setWidth(100);
		tblclmnEliminar.setText("Eliminar");
		
		
		
		/************/
		Label lblLabel = new Label(cmpSaldos, SWT.NONE);
		FormData fd_lblLabel = new FormData();
		fd_lblLabel.top = new FormAttachment(0, 5);
		fd_lblLabel.left = new FormAttachment(0, 5);
		lblLabel.setLayoutData(fd_lblLabel);
		managedForm.getToolkit().adapt(lblLabel, true, true);
		lblLabel.setText("Label");
		
		Composite cmpHelp = new Composite(cmpMain, SWT.NONE);
		FormData fd_cmpHelp = new FormData();
		fd_cmpHelp.right = new FormAttachment(cmpSaldos, 293, SWT.RIGHT);
		fd_cmpHelp.top = new FormAttachment(0);
		fd_cmpHelp.left = new FormAttachment(cmpSaldos, 2);
		cmpHelp.setLayoutData(fd_cmpHelp);
		managedForm.getToolkit().adapt(cmpHelp);
		managedForm.getToolkit().paintBordersFor(cmpHelp);
		
		ExpandableComposite xcmpConcepto = managedForm.getToolkit().createExpandableComposite(cmpHelp, ExpandableComposite.TWISTIE);
		xcmpConcepto.setBounds(0, 0, 166, 13);
		managedForm.getToolkit().paintBordersFor(xcmpConcepto);
		xcmpConcepto.setText("Concepto");
		
	}
}
