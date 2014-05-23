package dev.christian.jooq.snipets;

import java.sql.Connection;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.jooq.Configuration;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;
import org.jooq.impl.DefaultConfiguration;


import static org.jooq.impl.DSL.*;
import static dev.christian.jooq.gen.Tables.*;


public class BeginTest {
	
	public static final Logger log = Logger.getLogger(BeginTest.class);
	private static Connection conection;
	private static Configuration conf;
	private static DSLContext context;

	public static void main(String[] args) {
		 PropertyConfigurator.configure("log4j.properties");
		 
		  conection=UtilConnection.getInstance().getConexion();
			 conf = new DefaultConfiguration().set(conection).set(SQLDialect.MYSQL);
			 context = DSL.using(conf);
		 
		//howSqlBuilder();
	howSqlBuilderWithCodeGen();
			 
			 
			 UtilConnection.getInstance().cerrarConexion();

	}

	private static void howSqlBuilderWithCodeGen() {

		String sql = context.select(BOOK.TITLE, AUTHOR.FIRST_NAME, AUTHOR.LAST_NAME)
                .from(BOOK)
                .join(AUTHOR)
                .on(BOOK.AUTHOR_ID.equal(AUTHOR.ID))
                .where(BOOK.PUBLISHED_IN.equal(1948))
                .getSQL();
		log.info("SQL="+sql);
	}
	private static void howSqlBuilder() {
		
		
		String sql = context.select(field("BOOK.TITLE"), field("AUTHOR.FIRST_NAME"), field("AUTHOR.LAST_NAME"))
                .from(table("BOOK"))
                .join(table("AUTHOR"))
                .on(field("BOOK.AUTHOR_ID").equal(field("AUTHOR.ID")))
                .where(field("BOOK.PUBLISHED_IN").equal(1948))
                .getSQL();
		log.info("SQL="+sql);
	}

}
