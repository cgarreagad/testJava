/**
 * This class is generated by jOOQ
 */
package com.iks.data.jooq.tables.records;

/**
 * This class is generated by jOOQ.
 *
 * Tabla que almacena las empresas registrada en el ARCH-STC
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class EmpresasRecord extends org.jooq.impl.UpdatableRecordImpl<com.iks.data.jooq.tables.records.EmpresasRecord> implements org.jooq.Record4<java.lang.Integer, java.lang.String, byte[], java.lang.String> {

	private static final long serialVersionUID = -465056683;

	/**
	 * Setter for <code>ikas.empresas.idempresas</code>.
	 */
	public void setIdempresas(java.lang.Integer value) {
		setValue(0, value);
	}

	/**
	 * Getter for <code>ikas.empresas.idempresas</code>.
	 */
	public java.lang.Integer getIdempresas() {
		return (java.lang.Integer) getValue(0);
	}

	/**
	 * Setter for <code>ikas.empresas.codigo_arch</code>.
	 */
	public void setCodigoArch(java.lang.String value) {
		setValue(1, value);
	}

	/**
	 * Getter for <code>ikas.empresas.codigo_arch</code>.
	 */
	public java.lang.String getCodigoArch() {
		return (java.lang.String) getValue(1);
	}

	/**
	 * Setter for <code>ikas.empresas.password_arch</code>.
	 */
	public void setPasswordArch(byte[] value) {
		setValue(2, value);
	}

	/**
	 * Getter for <code>ikas.empresas.password_arch</code>.
	 */
	public byte[] getPasswordArch() {
		return (byte[]) getValue(2);
	}

	/**
	 * Setter for <code>ikas.empresas.estado</code>.
	 */
	public void setEstado(java.lang.String value) {
		setValue(3, value);
	}

	/**
	 * Getter for <code>ikas.empresas.estado</code>.
	 */
	public java.lang.String getEstado() {
		return (java.lang.String) getValue(3);
	}

	// -------------------------------------------------------------------------
	// Primary key information
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Record1<java.lang.Integer> key() {
		return (org.jooq.Record1) super.key();
	}

	// -------------------------------------------------------------------------
	// Record4 type implementation
	// -------------------------------------------------------------------------

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Integer, java.lang.String, byte[], java.lang.String> fieldsRow() {
		return (org.jooq.Row4) super.fieldsRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Row4<java.lang.Integer, java.lang.String, byte[], java.lang.String> valuesRow() {
		return (org.jooq.Row4) super.valuesRow();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.Integer> field1() {
		return com.iks.data.jooq.tables.Empresas.EMPRESAS.IDEMPRESAS;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field2() {
		return com.iks.data.jooq.tables.Empresas.EMPRESAS.CODIGO_ARCH;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<byte[]> field3() {
		return com.iks.data.jooq.tables.Empresas.EMPRESAS.PASSWORD_ARCH;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.Field<java.lang.String> field4() {
		return com.iks.data.jooq.tables.Empresas.EMPRESAS.ESTADO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.Integer value1() {
		return getIdempresas();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value2() {
		return getCodigoArch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public byte[] value3() {
		return getPasswordArch();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.lang.String value4() {
		return getEstado();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmpresasRecord value1(java.lang.Integer value) {
		setIdempresas(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmpresasRecord value2(java.lang.String value) {
		setCodigoArch(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmpresasRecord value3(byte[] value) {
		setPasswordArch(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmpresasRecord value4(java.lang.String value) {
		setEstado(value);
		return this;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public EmpresasRecord values(java.lang.Integer value1, java.lang.String value2, byte[] value3, java.lang.String value4) {
		return this;
	}

	// -------------------------------------------------------------------------
	// Constructors
	// -------------------------------------------------------------------------

	/**
	 * Create a detached EmpresasRecord
	 */
	public EmpresasRecord() {
		super(com.iks.data.jooq.tables.Empresas.EMPRESAS);
	}

	/**
	 * Create a detached, initialised EmpresasRecord
	 */
	public EmpresasRecord(java.lang.Integer idempresas, java.lang.String codigoArch, byte[] passwordArch, java.lang.String estado) {
		super(com.iks.data.jooq.tables.Empresas.EMPRESAS);

		setValue(0, idempresas);
		setValue(1, codigoArch);
		setValue(2, passwordArch);
		setValue(3, estado);
	}
}
