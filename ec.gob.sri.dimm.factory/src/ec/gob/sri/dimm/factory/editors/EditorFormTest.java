/**
 * 
 */
package ec.gob.sri.dimm.factory.editors;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.forms.editor.SharedHeaderFormEditor;

import ec.gob.sri.dimm.abt.ui.editores.EditorABT;
import ec.gob.sri.dimm.abt.ui.paginas.PaginaReduccionIR;
import ec.gob.sri.dimm.factory.editors.pages.ErrorMessagesPage;
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
	ErrorMessagesPage mse;
	PaginaReduccionIR p3;
	@Override
	protected void addPages() {
		System.out.println("*************************** pages ******************************");
		p1= new PaginaSaldoFavor2(this, "PAGINA_SALDOS", "Pagina Saldos a Favor");
		p2= new PaginaSaldoFavor(this, "PAGINA_SALDOS", "Pagina Saldos a Favor");
		p2.setModeloDatos(modeloDatos.getSaldoFavor());
		p2.inicializarModeloValores();
		
		p3 = new PaginaReduccionIR(this, "Pagina Reducciones","Reducciones Impuesto a la Renta");
		p3.setModeloDatos(modeloDatos.getReduccionIR());
		p3.inicializarModeloValores();
		
		mse= new ErrorMessagesPage(this);
		try {
			addPage(p1);
			addPage(p2);
			addPage(mse);
			addPage(p3);
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
