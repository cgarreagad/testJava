/**
 * 
 */
package beans;


import java.io.Serializable;

import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * @author cgad070313
 *
 */
@Named("personaBean")
@ViewScoped
public class PersonaBean implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String nombre;
	private String saludo;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void saludar(){
		System.out.println("SAludando="+nombre);
		this.setSaludo("Hola "+nombre);
	}

	public String getSaludo() {
		return saludo;
	}

	public void setSaludo(String saludo) {
		this.saludo = saludo;
	}

}
