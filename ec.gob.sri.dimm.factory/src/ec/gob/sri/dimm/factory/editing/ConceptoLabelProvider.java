package ec.gob.sri.dimm.factory.editing;

import java.math.BigDecimal;

import org.eclipse.jface.viewers.IBaseLabelProvider;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.jface.viewers.ITableLabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.ISharedImages;
import org.eclipse.ui.PlatformUI;
import org.eclipse.wb.swt.SWTResourceManager;


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
		/*if (columnIndex ==2){
			return getImage(element);
		}else{
			return null;
		}*/
		ConceptoCodigo c = (ConceptoCodigo) element;
		if (c.getMensaje().isEmpty()==Boolean.FALSE && columnIndex ==2){
			return PlatformUI.getWorkbench().getSharedImages().getImage(
					ISharedImages.IMG_OBJS_ERROR_TSK);
//			return SWTResourceManager.getColor(255, 228, 225);
		}else{
			return null;
		}
		//return null;
		
	}
	public Image getImage(Object obj) {
		return PlatformUI.getWorkbench().getSharedImages().getImage(
		ISharedImages.IMG_OBJ_ELEMENT);
		}

	@Override
	public String getColumnText(Object element, int columnIndex) {
		ConceptoCodigo c = (ConceptoCodigo) element;
		switch (columnIndex) {
	    case 0:
	    	 //return AgeRange2.INSTANCES[c.getConcepto().intValue()];
	    	 return "0";
	      //return c.getConcepto().toString();
	    case 1:
	      return c.getValor().toString();
	    case 2:
	      return c.getMensaje();
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
		ConceptoCodigo c = (ConceptoCodigo) element;
//		if (c.getValor().compareTo(new BigDecimal(100))>0){
//			c.setMensaje("Numero muy grande");
//			return new Color(Display.getCurrent(), new RGB(255, 228, 255));
////			return SWTResourceManager.getColor(255, 228, 225);
//		}else{
//			return Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND); 
//		}
		
		
		if (c.getMensaje().isEmpty()==Boolean.FALSE){
			return new Color(Display.getCurrent(), new RGB(255, 228, 255));
//			return SWTResourceManager.getColor(255, 228, 225);
		}else{
			return Display.getCurrent().getSystemColor(SWT.COLOR_INFO_BACKGROUND); 
		}
		
	}

	

	

}
