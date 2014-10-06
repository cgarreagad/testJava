package ec.gob.sri.dimm.factory.editing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.CodingErrorAction;

import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Item;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

import ec.gob.sri.dimm.abt.modelo.obj.saldos.ConceptoCodigo;
import ec.gob.sri.dimm.factory.editors.EditorFormTest;
import ec.gob.sri.dimm.factory.editors.pages.PaginaSaldoFavor2;

public class ConceptoCellModifier implements ICellModifier {
	private Viewer viewer;
	public ConceptoCellModifier(Viewer tableViewer) {
		 this.viewer = tableViewer;
	}

	@Override
	public boolean canModify(Object element, String property) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object getValue(Object element, String property) {
		ConceptoCodigo c = (ConceptoCodigo) element;
		if (property.equals("Concepto")){
			return c.getConcepto();
		}else if (property.equals("Valor")){
			return ""+c.getValor();
		}else if (property.equals("Mensaje")){
			return c.getSelect();
		}else{
			return null;
		}
	}

	@Override
	public void modify(Object element, String property, Object value) {
		System.out.println("--->"+value);
	    if (element instanceof Item)
	        element = ((Item) element).getData();
	    
		ConceptoCodigo c = (ConceptoCodigo) element;
		if (property.equals("Concepto")){
			c.setConcepto(value.toString());
		}else if (property.equals("Valor")){
			String valor =value.toString().replace(",", ".");
			if (!valor.contains(".")){
				valor=valor.concat(".00");
			}
			if (validarValor(valor,element)){
				c.setValor(value.toString());
				c.setMensaje("");
			}else{
				c.setValor("0");
			}
			
		}/*else if (property.equals("Seleccion")){
			c.setSelect( Boolean.valueOf( value.toString()));
		}*/

		viewer.refresh();
		refrescateBoton();
		
		
	}
	private void refrescateBoton() {
		  Display.getDefault().asyncExec(new Runnable() {
		      public void run() {
		    	  IWorkbench wb = PlatformUI.getWorkbench();
		    	   IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		    	   if (win!=null){
		    		   IWorkbenchPage page = win.getActivePage();
				    	  IEditorPart a= page.getActiveEditor();
				    	  // ((PaginaSaldoFavor2) page).setValorSuma(BigDecimal.TEN);
				    	  EditorFormTest form =(EditorFormTest) a;
				    	  
				    	  //((PaginaSaldoFavor2)form.getActivePageInstance()).setValorSuma(BigDecimal.TEN);
				    	  ((PaginaSaldoFavor2)form.getActivePageInstance()).recalcularSuma();
		    	   }
		    	   
		    	  
		    	 
		      }
		    });
		
	}

	private boolean validarValor(String valor, Object element) {
		
		boolean result=valor.matches("[0-9]{1,12}\\.[0-9]{1,2}");
		if (result==false){
			MessageDialog.openError(new Shell(), "Error", " El valor="+valor+ " No es permitido. Sólo se admite 12 enteros y dos decimales");
			((ConceptoCodigo) element).setMensaje(" El valor="+valor+ " No es permitido. Sólo se admite 12 enteros y dos decimales");
			
		}
		return result;
	}

}
