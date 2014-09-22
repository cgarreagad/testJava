package ec.gob.sri.dimm.factory.editing;

import org.eclipse.jface.viewers.CellEditor;
import org.eclipse.jface.viewers.ColumnViewer;
import org.eclipse.jface.viewers.ComboBoxCellEditor;
import org.eclipse.jface.viewers.EditingSupport;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TextCellEditor;

import ec.gob.sri.dimm.abt.modelo.obj.beneficiosAnticipoIR.Concepto;

public class SaldosEditingSupport extends EditingSupport {

	
	

	private final TableViewer viewer;
	private CellEditor textEditor;

	private CellEditor dropDownEditor;
	
	public SaldosEditingSupport(TableViewer viewer) {
		super(viewer);
		this.viewer = viewer;
	    textEditor = new TextCellEditor(viewer.getTable());
	    
	    String[] elements = new String[10];

		for (int i = 0; i < 10; i++) {
			elements[i] = i+"";
		}

		dropDownEditor = new ComboBoxCellEditor(viewer.getTable(),elements);
	
	}
	

	@Override
	protected CellEditor getCellEditor(Object element) {
		
		if (element instanceof Concepto)
		 return textEditor;
		return dropDownEditor;
	}

	@Override
	protected boolean canEdit(Object element) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object getValue(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setValue(Object element, Object value) {
		// TODO Auto-generated method stub

	}

}
