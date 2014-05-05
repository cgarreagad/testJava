/**
 * 
 */
package com.iks.data.jooq.dao;

import java.sql.Connection;
import java.util.logging.Logger;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import com.iks.data.jooq.tables.records.UsuariosRecord;

import static com.iks.data.jooq.Tables.*;

/**
 * @author cgad070313
 *
 */
public class UsuariosDao {

	
	private Connection conect;
	private static final Logger log = Logger.getLogger("UsuariosDao");
	
	/**
	 * 
	 */
	public UsuariosDao(Connection con) {
		this.conect=con;
	}
	
	public void todos(){
		log.info("Consultar todos");
		DSLContext context = DSL.using(conect,SQLDialect.MYSQL);
		/*Result<Record> res = context.select().from(USUARIOS).fetch();
		for (Record row: res){
			log.info("ID="+row.getValue(USUARIOS.ID_USER));
			
		}*/
		
		for (UsuariosRecord usr:context.fetch(USUARIOS)){
			log.info("-->USERID:"+usr.getIdUser());
		}
		
	}

}
