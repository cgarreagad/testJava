/**
 * 
 */
package com.test.prim.beans;

import java.io.Serializable;



import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

//import org.apache.log4j.Logger;

/**
 * @author cgad070313
 *
 */
@ManagedBean(name="logincontrol")
@SessionScoped
public class LoginController implements Serializable {

	private String username;
	private String password;
	//private static final Logger log = Logger.getLogger(LoginController.class);
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String login(){
		System.out.println("Logeando: username="+username+" password:"+password);
		
		return "home";
		
	}

}
