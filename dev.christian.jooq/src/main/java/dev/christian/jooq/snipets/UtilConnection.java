/**
 * 
 */
package dev.christian.jooq.snipets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;



/**
 * @author cgad070313
 * Singleton tipo LAZY, utilitario de conexiones con la base de datos
 */
public class UtilConnection {
	
	private static Connection con;
	private static volatile UtilConnection instance; 
	private static final Logger log = Logger.getLogger("UtilConnection");

	public Connection getConexion(){
		return con;
	}
	
	public Boolean cerrarConexion(){
		log.info("Cerrando conexi�n...");
		if (con != null) {
			 try {
				 con.close();
				 return true;
			 } catch (SQLException ignore) {
				 ignore.printStackTrace();
			 }
			}
		return false;
		}
	
	public UtilConnection() {
		conectar();
	}
	
	public void conectar() {
		log.info("Conectando....");
		String username="root";
		String password="654321";
		String db="jooq_test";
		String ip="localhost";
		String port="3306";
		String url="jdbc:mysql://"+ip+":"+port+"/"+db;
		
		try {
			if (con==null){
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				con = DriverManager.getConnection(url, username, password);
				log.info("Conexion creada!!");
			}else{
			    log.info("La conexion ya se encuentra abierta");	
			}
			
			

		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException | SQLException e) {
			
			e.printStackTrace();
		}/*finally{
			if (con != null) {
				 try {
				 con.close();
				 } catch (SQLException ignore) {
					 ignore.printStackTrace();
				 }
				}
			}*/
		
	}

	public static UtilConnection getInstance(){
		if (instance==null){
			synchronized (UtilConnection.class) {
				instance = new UtilConnection();
			}
		}
		
		return instance;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		log.info("Test Log");
		UtilConnection.getInstance();
		UtilConnection.getInstance().conectar();
		if (UtilConnection.getInstance().getConexion()==null){
			System.out.println("--->NULO");
		}else{
			/*UsuariosDao daoU = new UsuariosDao(UtilConnection.getInstance().getConexion());
			daoU.todos();
			UtilConnection.getInstance().cerrarConexion();*/
			
		}

	}

}
