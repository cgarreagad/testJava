package ec.gob.sri.dimm.factory.editing;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.nio.charset.CodingErrorAction;

import org.eclipse.jface.viewers.ICellModifier;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.widgets.Item;

import ec.gob.sri.dimm.abt.modelo.obj.saldos.ConceptoCodigo;

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
			return c.getConcepto().intValue();
		}else if (property.equals("Valor")){
			return ""+c.getValor();
		}else if (property.equals("Seleccion")){
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
			c.setConcepto(new BigInteger(value.toString()));
		}else if (property.equals("Valor")){
			c.setValor(new BigDecimal(value.toString()));
		}else if (property.equals("Seleccion")){
			c.setSelect( Boolean.valueOf( value.toString()));
		}

		viewer.refresh();
	}

}
