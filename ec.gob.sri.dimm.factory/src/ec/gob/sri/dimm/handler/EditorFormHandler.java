package ec.gob.sri.dimm.handler;



import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.handlers.HandlerUtil;

import ec.gob.sri.dimm.abt.modelo.obj.ModeloBeneficiosTributarios;
import ec.gob.sri.dimm.abt.ui.editores.EditorABT;
import ec.gob.sri.dimm.abt.ui.editores.InputEditorABT;
import ec.gob.sri.dimm.factory.editors.EditorFormTest;
import ec.gob.sri.dimm.factory.editors.EditorTest;
import ec.gob.sri.dimm.factory.editors.MyEditorInputTest;



public class EditorFormHandler extends AbstractHandler implements IHandler {

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindow(event);
		IWorkbenchPage page = window.getActivePage();
		
//		MyEditorInputTest input = new MyEditorInputTest();
		InputEditorABT datosInput = new InputEditorABT("0923146120001", "2014", "TEST");
		try {
			//page.openEditor(input, EditorFormTest.ID);
			
			ModeloBeneficiosTributarios modeloDatos = new ModeloBeneficiosTributarios();
			modeloDatos.setPeriodoInformado(Integer.parseInt("2014"));
			modeloDatos.getDatosInformante().setTipoIdentificacion("R");
			modeloDatos.getDatosInformante().setNumeroIdentificacion("0923146120001");
			modeloDatos.getDatosInformante().setRazonSocial("TEST");
			datosInput.setModeloDatos(modeloDatos);
			
			//page.openEditor(datosInput, EditorFormTest.ID);
			
			page.openEditor(datosInput, EditorABT.ID);
			
			
			
			
		} catch (PartInitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}



}
