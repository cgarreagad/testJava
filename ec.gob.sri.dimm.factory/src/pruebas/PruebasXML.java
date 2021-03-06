package pruebas;

import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

import javax.xml.bind.JAXBException;

import org.w3c.dom.Document;

import ec.gob.sri.dimm.abt.modelo.impl.AdministradorModeloABT;
import ec.gob.sri.dimm.abt.modelo.obj.ModeloBeneficiosTributarios;
import ec.gob.sri.dimm.abt.modelo.obj.saldos.ConceptoCodigo;
import ec.gob.sri.dimm.abt.modelo.obj.saldos.SaldoContribuyente;
import ec.gob.sri.dimm.api.modelo.persistencia.AdministradorPersistencia;
import ec.gob.sri.dimm.data.impl.DataCatalogos;

public class PruebasXML {
	public static void main(String[] args) {
		//saldoContribuyente();
		//formateando();
		pruebaImportancion();
	}

	private static void pruebaImportancion() {
		
		DataCatalogos.inicializarData();
		File archivoXMLSeleccionado=new File("D:\\ABTCB.xml");
		Document documentoXML = AdministradorPersistencia.obtenerDocumento(archivoXMLSeleccionado.getAbsolutePath());
		AdministradorModeloABT administradorModelo = new AdministradorModeloABT();
		ModeloBeneficiosTributarios modeloImportado = administradorModelo.importar(documentoXML);
		System.out.println("ModeloBeneficiosTributarios="+modeloImportado);
		
	}

	private static void formateando() {
		//BigDecimal bg = new BigDecimal("12565645645645");
		BigDecimal bg = BigDecimal.ZERO;
		
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.getDefault());
		otherSymbols.setDecimalSeparator('.');
		//otherSymbols.setGroupingSeparator('.'); 
		
		DecimalFormat df = new DecimalFormat("#0.00",otherSymbols);
		
		//[0-9]{1,12}\\.[0-9]{0,2}
		System.out.println("--->"+df.format(new BigDecimal("14."))+" BG="+bg.toString()+"  "+"14.".matches("[0-9]{1,12}[\\.]{0,1}[0-9]{0,2}"));
		System.out.println("Numero ocurre="+contarOcurrencias("502","."));
		
       // String s = String.format("%.2f",978778);
		
		//System.out.println(s);
		
		String mensajeMoney="%s: Se admiten s�lo 12 enteros y 2 decimales";
		System.out.println(String.format(mensajeMoney, "Utilidad contable"));
		
	}

	private static void saldoContribuyente() {
		SaldoContribuyente saldo = new SaldoContribuyente();
		ConceptoCodigo c = new ConceptoCodigo();
		//c.setConcepto(BigInteger.ONE);
		//c.setValor(BigDecimal.ZERO);
		c.setSelect(true);
		saldo.getConceptosSaldos().getConceptoSaldo().add(c);
		
		try {
			
			System.out.println("--->"+saldo.toXML());
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private static int contarOcurrencias(String sTexto, String sTextoBuscado) {

		int contador=0;
		while (sTexto.indexOf(sTextoBuscado) > -1) {
              sTexto = sTexto.substring(sTexto.indexOf(
                sTextoBuscado)+sTextoBuscado.length(),sTexto.length());
              contador++; 
            }

		return contador;
	}

}
