/**
 * This class is generated by jOOQ
 */
package com.iks.data.jooq.tables;

/**
 * This class is generated by jOOQ.
 *
 * Tabla q almacena los tipos de operaciones del sistema arch
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class TipoOperacion extends org.jooq.impl.TableImpl<com.iks.data.jooq.tables.records.TipoOperacionRecord> {

	private static final long serialVersionUID = 2070027899;

	/**
	 * The singleton instance of <code>ikas.tipo_operacion</code>
	 */
	public static final com.iks.data.jooq.tables.TipoOperacion TIPO_OPERACION = new com.iks.data.jooq.tables.TipoOperacion();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<com.iks.data.jooq.tables.records.TipoOperacionRecord> getRecordType() {
		return com.iks.data.jooq.tables.records.TipoOperacionRecord.class;
	}

	/**
	 * The column <code>ikas.tipo_operacion.idtipo_operacion</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.TipoOperacionRecord, java.lang.Integer> IDTIPO_OPERACION = createField("idtipo_operacion", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>ikas.tipo_operacion.nombre</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.TipoOperacionRecord, java.lang.String> NOMBRE = createField("nombre", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>ikas.tipo_operacion.descripcion</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.TipoOperacionRecord, java.lang.String> DESCRIPCION = createField("descripcion", org.jooq.impl.SQLDataType.VARCHAR.length(45).nullable(false), this, "");

	/**
	 * The column <code>ikas.tipo_operacion.estado</code>.
	 */
	public final org.jooq.TableField<com.iks.data.jooq.tables.records.TipoOperacionRecord, java.lang.String> ESTADO = createField("estado", org.jooq.impl.SQLDataType.CHAR.length(1), this, "");

	/**
	 * Create a <code>ikas.tipo_operacion</code> table reference
	 */
	public TipoOperacion() {
		this("tipo_operacion", null);
	}

	/**
	 * Create an aliased <code>ikas.tipo_operacion</code> table reference
	 */
	public TipoOperacion(java.lang.String alias) {
		this(alias, com.iks.data.jooq.tables.TipoOperacion.TIPO_OPERACION);
	}

	private TipoOperacion(java.lang.String alias, org.jooq.Table<com.iks.data.jooq.tables.records.TipoOperacionRecord> aliased) {
		this(alias, aliased, null);
	}

	private TipoOperacion(java.lang.String alias, org.jooq.Table<com.iks.data.jooq.tables.records.TipoOperacionRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, com.iks.data.jooq.Ikas.IKAS, aliased, parameters, "Tabla q almacena los tipos de operaciones del sistema arch");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Identity<com.iks.data.jooq.tables.records.TipoOperacionRecord, java.lang.Integer> getIdentity() {
		return com.iks.data.jooq.Keys.IDENTITY_TIPO_OPERACION;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<com.iks.data.jooq.tables.records.TipoOperacionRecord> getPrimaryKey() {
		return com.iks.data.jooq.Keys.KEY_TIPO_OPERACION_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<com.iks.data.jooq.tables.records.TipoOperacionRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<com.iks.data.jooq.tables.records.TipoOperacionRecord>>asList(com.iks.data.jooq.Keys.KEY_TIPO_OPERACION_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public com.iks.data.jooq.tables.TipoOperacion as(java.lang.String alias) {
		return new com.iks.data.jooq.tables.TipoOperacion(alias, this);
	}

	/**
	 * Rename this table
	 */
	public com.iks.data.jooq.tables.TipoOperacion rename(java.lang.String name) {
		return new com.iks.data.jooq.tables.TipoOperacion(name, null);
	}
}