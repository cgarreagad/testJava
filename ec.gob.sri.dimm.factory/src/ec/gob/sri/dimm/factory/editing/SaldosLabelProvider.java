package ec.gob.sri.dimm.factory.editing;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import ec.gob.sri.dimm.abt.modelo.obj.saldos.ConceptoCodigo;

public class SaldosLabelProvider extends LabelProvider implements IColorProvider {

	@Override
	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return Display.getCurrent().getSystemColor(SWT.COLOR_GREEN); 
	}

 @Override
public String getText(Object element) {
	// ConceptoCodigo c = (ConceptoCodigo) element;
	return element.toString();
}
 

}
