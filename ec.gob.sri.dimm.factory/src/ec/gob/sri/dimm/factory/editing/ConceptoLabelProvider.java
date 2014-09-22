package ec.gob.sri.dimm.factory.editing;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;


import pruebas.AgeRange2;


import ec.gob.sri.dimm.abt.modelo.obj.saldos.ConceptoCodigo;

public class ConceptoLabelProvider implements ITableLabelProvider, IColorProvider {

	@Override
	public void addListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isLabelProperty(Object element, String property) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void removeListener(ILabelProviderListener listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Image getColumnImage(Object element, int columnIndex) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		ConceptoCodigo c = (ConceptoCodigo) element;
		switch (columnIndex) {
	    case 0:
	    	 return AgeRange2.INSTANCES[c.getConcepto().intValue()];
	      //return c.getConcepto().toString();
	    case 1:
	      return c.getValor().toString();
	    case 2:
	      return Boolean.toString(true);
	    }
	    return null;
	}

	@Override
	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND); 
	}

	

}
