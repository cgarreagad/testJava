/**
 * This class is generated by jOOQ
 */
package com.iks.data.jooq.tables;

/**
 * This class is generated by jOOQ.
 *
 * Esta tabla almacena el historial de anulaciones
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class DetalleAnulacion extends org.jooq.impl.TableImpl<com.iks.data.jooq.tables.records.DetalleAnulacionRecord> {

	private static final long serialVersionUID = -386426991;

	/**
	 * The singleton instance of <code>ikas.detalle_anulacion</code>
	 */
	public static final com.iks.data.jooq.tables.DetalleAnulacion DETALLE_ANULACION = new com.iks.data.jooq.tables.DetalleAnulacion();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.iks.data.jooq.tables.records.DetalleAnulacionRecord> getRecordType() {
		return com.iks.data.jooq.tables.records.DetalleAnulacionRecord.class;
	}

	/**
	 * The column <code>ikas.detalle_anulacion.iddetalle_anulacion</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleAnulacionRecord, java.lang.Integer> IDDETALLE_ANULACION = createField("iddetalle_anulacion", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_anulacion.id_detalle</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleAnulacionRecord, java.lang.Integer> ID_DETALLE = createField("id_detalle", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>ikas.detalle_anulacion.id_empresa</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.DetalleAnulacionRecord, java.lang.Integer> ID_EMPRESA = createField("id_empresa", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>ikas.detalle_anulacion</code> table reference
	 */
	public DetalleAnulacion() {
		this("detalle_anulacion", null);
	}

	/**
	 * Create an aliased <code>ikas.detalle_anulacion</code> table reference
	 */
	public DetalleAnulacion(java.lang.String alias) {
		this(alias, com.iks.data.jooq.tables.DetalleAnulacion.DETALLE_ANULACION);
	}

	private DetalleAnulacion(java.lang.String alias, org.jooq.Table<com.iks.data.jooq.tables.records.DetalleAnulacionRecord> aliased) {
		this(alias, aliased, null);
	}

	private DetalleAnulacion(java.lang.String alias, org.jooq.Table<com.iks.data.jooq.tables.records.DetalleAnulacionRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.iks.data.jooq.Ikas.IKAS, aliased, parameters, "Esta tabla almacena el historial de anulaciones");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.iks.data.jooq.tables.records.DetalleAnulacionRecord, java.lang.Integer> getIdentity() {
		return com.iks.data.jooq.Keys.IDENTITY_DETALLE_ANULACION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.iks.data.jooq.tables.records.DetalleAnulacionRecord> getPrimaryKey() {
		return com.iks.data.jooq.Keys.KEY_DETALLE_ANULACION_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.iks.data.jooq.tables.records.DetalleAnulacionRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.iks.data.jooq.tables.records.DetalleAnulacionRecord>>asList(com.iks.data.jooq.Keys.KEY_DETALLE_ANULACION_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<com.iks.data.jooq.tables.records.DetalleAnulacionRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<com.iks.data.jooq.tables.records.DetalleAnulacionRecord, ?>>asList(com.iks.data.jooq.Keys.DA_FK_EMP);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.iks.data.jooq.tables.DetalleAnulacion as(java.lang.String alias) {
		return new com.iks.data.jooq.tables.DetalleAnulacion(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.iks.data.jooq.tables.DetalleAnulacion rename(java.lang.String name) {
		return new com.iks.data.jooq.tables.DetalleAnulacion(name, null);
	}
}
