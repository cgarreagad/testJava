/**
 * 
 */
package ec.gob.sri.dimm.factory.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;

import ec.gob.sri.dimm.abt.ui.editores.EditorABT;
import ec.gob.sri.dimm.factory.editors.pages.PaginaSaldoFavor;
import ec.gob.sri.dimm.factory.editors.pages.PaginaSaldoFavor2;

/**
 * @author cgad070313
 *
 */
public class EditorFormTest extends EditorABT {

	public static final String ID = "ec.gob.sri.dimm.factory.editorFormtest";
	
	PaginaSaldoFavor2 p1;
	PaginaSaldoFavor p2;
	@Override
	protected void addPages() {
		p1= new PaginaSaldoFavor2(this, "PAGINA_SALDOS", "Pagina Saldos a Favor");
		p2= new PaginaSaldoFavor(this, "PAGINA_SALDOS", "Pagina Saldos a Favor");
		p2.setModeloDatos(modeloDatos.getSaldoFavor());
		p2.inicializarModeloValores();
		try {
			addPage(p1);
			addPage(p2);
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void doSave(IProgressMonitor monitor) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doSaveAs() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isSaveAsAllowed() {
		// TODO Auto-generated method stub
		return false;
	}

}
