/**
 * This class is generated by jOOQ
 */
package dev.christian.jooq.gen.tables;

/**
 * This class is generated by jOOQ.
 */
@javax.annotation.Generated(value    = { "http://www.jooq.org", "3.3.2" },
                            comments = "This class is generated by jOOQ")
@java.lang.SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class User extends org.jooq.impl.TableImpl<dev.christian.jooq.gen.tables.records.UserRecord> {

	private static final long serialVersionUID = -1842677756;

	/**
	 * The singleton instance of <code>jooq_test.user</code>
	 */
	public static final dev.christian.jooq.gen.tables.User USER = new dev.christian.jooq.gen.tables.User();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<dev.christian.jooq.gen.tables.records.UserRecord> getRecordType() {
		return dev.christian.jooq.gen.tables.records.UserRecord.class;
	}

	/**
	 * The column <code>jooq_test.user.id_user</code>.
	 */
	public final org.jooq.TableField<dev.christian.jooq.gen.tables.records.UserRecord, java.lang.Integer> ID_USER = createField("id_user", org.jooq.impl.SQLDataType.INTEGER, this, "");

	/**
	 * The column <code>jooq_test.user.nombre</code>.
	 */
	public final org.jooq.TableField<dev.christian.jooq.gen.tables.records.UserRecord, java.lang.String> NOMBRE = createField("nombre", org.jooq.impl.SQLDataType.VARCHAR.length(50), this, "");

	/**
	 * Create a <code>jooq_test.user</code> table reference
	 */
	public User() {
		this("user", null);
	}

	/**
	 * Create an aliased <code>jooq_test.user</code> table reference
	 */
	public User(java.lang.String alias) {
		this(alias, dev.christian.jooq.gen.tables.User.USER);
	}

	private User(java.lang.String alias, org.jooq.Table<dev.christian.jooq.gen.tables.records.UserRecord> aliased) {
		this(alias, aliased, null);
	}

	private User(java.lang.String alias, org.jooq.Table<dev.christian.jooq.gen.tables.records.UserRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, dev.christian.jooq.gen.JooqTest.JOOQ_TEST, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public dev.christian.jooq.gen.tables.User as(java.lang.String alias) {
		return new dev.christian.jooq.gen.tables.User(alias, this);
	}

	/**
	 * Rename this table
	 */
	public dev.christian.jooq.gen.tables.User rename(java.lang.String name) {
		return new dev.christian.jooq.gen.tables.User(name, null);
	}
}