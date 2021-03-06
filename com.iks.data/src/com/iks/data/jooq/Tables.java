/**
 * This class is generated by jOOQ
 */
package com.iks.data.jooq;

/**
 * This class is generated by jOOQ.
 *
 * Convenience access to all tables in ikas
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Tables {

	/**
	 * Tabla de la cabera del proceso de las operaciones de conexion para el sistema ARCH
	 */
	public static final com.iks.data.jooq.tables.CabeceraIkas CABECERA_IKAS = com.iks.data.jooq.tables.CabeceraIkas.CABECERA_IKAS;

	/**
	 * Esta tabla almacena el historial de anulaciones
	 */
	public static final com.iks.data.jooq.tables.DetalleAnulacion DETALLE_ANULACION = com.iks.data.jooq.tables.DetalleAnulacion.DETALLE_ANULACION;

	/**
	 * Tabla que almacena los detalles de la operacion denominada TRANSACION
	 */
	public static final com.iks.data.jooq.tables.DetalleTransaccion DETALLE_TRANSACCION = com.iks.data.jooq.tables.DetalleTransaccion.DETALLE_TRANSACCION;

	/**
	 * Tabla de las transacciones de la operacion denominada como Venta GAS
	 */
	public static final com.iks.data.jooq.tables.DetalleVentaGas DETALLE_VENTA_GAS = com.iks.data.jooq.tables.DetalleVentaGas.DETALLE_VENTA_GAS;

	/**
	 * Tabla que almacena las empresas registrada en el ARCH-STC
	 */
	public static final com.iks.data.jooq.tables.Empresas EMPRESAS = com.iks.data.jooq.tables.Empresas.EMPRESAS;

	/**
	 * tabla de auditoria del sistema
	 */
	public static final com.iks.data.jooq.tables.LogAuditoria LOG_AUDITORIA = com.iks.data.jooq.tables.LogAuditoria.LOG_AUDITORIA;

	/**
	 * Tabla q almacena los tipos de operaciones del sistema arch
	 */
	public static final com.iks.data.jooq.tables.TipoOperacion TIPO_OPERACION = com.iks.data.jooq.tables.TipoOperacion.TIPO_OPERACION;

	/**
	 * Tabla de los usuarios del sistema iKas
	 */
	public static final com.iks.data.jooq.tables.Usuarios USUARIOS = com.iks.data.jooq.tables.Usuarios.USUARIOS;
}
