/**
 * This class is generated by jOOQ
 */
package com.iks.data.jooq.tables;

/**
 * This class is generated by jOOQ.
 *
 * Tabla que almacena los detalles de la operacion denominada TRANSACION
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DetalleTransaccion extends org.jooq.impl.TableImpl<com.iks.data.jooq.tables.records.DetalleTransaccionRecord> {

	private static final long serialVersionUID = 1269511652;

	/**
	 * The singleton instance of <code>ikas.detalle_transaccion</code>
	 */
	public static final com.iks.data.jooq.tables.DetalleTransaccion DETALLE_TRANSACCION = new com.iks.data.jooq.tables.DetalleTransaccion();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.iks.data.jooq.tables.records.DetalleTransaccionRecord> getRecordType() {
		return com.iks.data.jooq.tables.records.DetalleTransaccionRecord.class;
	}

	/**
	 * The column <code>ikas.detalle_transaccion.id_det_transaccion</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.Integer> ID_DET_TRANSACCION = createField("id_det_transaccion", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.secuencial</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.String> SECUENCIAL = createField("secuencial", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.terminal</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.String> TERMINAL = createField("terminal", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.numero_confirmacion</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.Double> NUMERO_CONFIRMACION = createField("numero_confirmacion", org.jooq.impl.SQLDataType.FLOAT, this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.fecha</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.sql.Date> FECHA = createField("fecha", org.jooq.impl.SQLDataType.DATE.nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.tipo</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.String> TIPO = createField("tipo", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.id_empresa</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.Integer> ID_EMPRESA = createField("id_empresa", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.contraparte</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.String> CONTRAPARTE = createField("contraparte", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.cod_producto</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.String> COD_PRODUCTO = createField("cod_producto", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.cantidad</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.Double> CANTIDAD = createField("cantidad", org.jooq.impl.SQLDataType.FLOAT.nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.tipo_transporte</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.String> TIPO_TRANSPORTE = createField("tipo_transporte", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.cedula_chofer</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.String> CEDULA_CHOFER = createField("cedula_chofer", org.jooq.impl.SQLDataType.VARCHAR.length(10), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.placa</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.String> PLACA = createField("placa", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.guia_remision</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.String> GUIA_REMISION = createField("guia_remision", org.jooq.impl.SQLDataType.VARCHAR.length(45), this, "");

	/**
	 * The column <code>ikas.detalle_transaccion.id_cabacera</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.Integer> ID_CABACERA = createField("id_cabacera", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>ikas.detalle_transaccion</code> table reference
	 */
	public DetalleTransaccion() {
		this("detalle_transaccion", null);
	}

	/**
	 * Create an aliased <code>ikas.detalle_transaccion</code> table reference
	 */
	public DetalleTransaccion(java.lang.String alias) {
		this(alias, com.iks.data.jooq.tables.DetalleTransaccion.DETALLE_TRANSACCION);
	}

	private DetalleTransaccion(java.lang.String alias, org.jooq.Table<com.iks.data.jooq.tables.records.DetalleTransaccionRecord> aliased) {
		this(alias, aliased, null);
	}

	private DetalleTransaccion(java.lang.String alias, org.jooq.Table<com.iks.data.jooq.tables.records.DetalleTransaccionRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.iks.data.jooq.Ikas.IKAS, aliased, parameters, "Tabla que almacena los detalles de la operacion denominada TRANSACION");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, java.lang.Integer> getIdentity() {
		return com.iks.data.jooq.Keys.IDENTITY_DETALLE_TRANSACCION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.iks.data.jooq.tables.records.DetalleTransaccionRecord> getPrimaryKey() {
		return com.iks.data.jooq.Keys.KEY_DETALLE_TRANSACCION_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.iks.data.jooq.tables.records.DetalleTransaccionRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.iks.data.jooq.tables.records.DetalleTransaccionRecord>>asList(com.iks.data.jooq.Keys.KEY_DETALLE_TRANSACCION_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<com.iks.data.jooq.tables.records.DetalleTransaccionRecord, ?>>asList(com.iks.data.jooq.Keys.DT_FK_EMP, com.iks.data.jooq.Keys.DT_FK_CT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.iks.data.jooq.tables.DetalleTransaccion as(java.lang.String alias) {
		return new com.iks.data.jooq.tables.DetalleTransaccion(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.iks.data.jooq.tables.DetalleTransaccion rename(java.lang.String name) {
		return new com.iks.data.jooq.tables.DetalleTransaccion(name, null);
	}
}
