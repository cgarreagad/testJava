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
public class Book extends org.jooq.impl.TableImpl<dev.christian.jooq.gen.tables.records.BookRecord> {

	private static final long serialVersionUID = -604918020;

	/**
	 * The singleton instance of <code>jooq_test.book</code>
	 */
	public static final dev.christian.jooq.gen.tables.Book BOOK = new dev.christian.jooq.gen.tables.Book();

	/**
	 * The class holding records for this type
	 */
	@Override
	public java.lang.Class<dev.christian.jooq.gen.tables.records.BookRecord> getRecordType() {
		return dev.christian.jooq.gen.tables.records.BookRecord.class;
	}

	/**
	 * The column <code>jooq_test.book.id</code>.
	 */
	public final org.jooq.TableField<dev.christian.jooq.gen.tables.records.BookRecord, java.lang.Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>jooq_test.book.author_id</code>.
	 */
	public final org.jooq.TableField<dev.christian.jooq.gen.tables.records.BookRecord, java.lang.Integer> AUTHOR_ID = createField("author_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>jooq_test.book.title</code>.
	 */
	public final org.jooq.TableField<dev.christian.jooq.gen.tables.records.BookRecord, java.lang.String> TITLE = createField("title", org.jooq.impl.SQLDataType.VARCHAR.length(400).nullable(false), this, "");

	/**
	 * The column <code>jooq_test.book.published_in</code>.
	 */
	public final org.jooq.TableField<dev.christian.jooq.gen.tables.records.BookRecord, java.lang.Integer> PUBLISHED_IN = createField("published_in", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>jooq_test.book.language_id</code>.
	 */
	public final org.jooq.TableField<dev.christian.jooq.gen.tables.records.BookRecord, java.lang.Integer> LANGUAGE_ID = createField("language_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * Create a <code>jooq_test.book</code> table reference
	 */
	public Book() {
		this("book", null);
	}

	/**
	 * Create an aliased <code>jooq_test.book</code> table reference
	 */
	public Book(java.lang.String alias) {
		this(alias, dev.christian.jooq.gen.tables.Book.BOOK);
	}

	private Book(java.lang.String alias, org.jooq.Table<dev.christian.jooq.gen.tables.records.BookRecord> aliased) {
		this(alias, aliased, null);
	}

	private Book(java.lang.String alias, org.jooq.Table<dev.christian.jooq.gen.tables.records.BookRecord> aliased, org.jooq.Field<?>[] parameters) {
		super(alias, dev.christian.jooq.gen.JooqTest.JOOQ_TEST, aliased, parameters, "");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public org.jooq.UniqueKey<dev.christian.jooq.gen.tables.records.BookRecord> getPrimaryKey() {
		return dev.christian.jooq.gen.Keys.KEY_BOOK_PRIMARY;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.UniqueKey<dev.christian.jooq.gen.tables.records.BookRecord>> getKeys() {
		return java.util.Arrays.<org.jooq.UniqueKey<dev.christian.jooq.gen.tables.records.BookRecord>>asList(dev.christian.jooq.gen.Keys.KEY_BOOK_PRIMARY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public java.util.List<org.jooq.ForeignKey<dev.christian.jooq.gen.tables.records.BookRecord, ?>> getReferences() {
		return java.util.Arrays.<org.jooq.ForeignKey<dev.christian.jooq.gen.tables.records.BookRecord, ?>>asList(dev.christian.jooq.gen.Keys.FK_BOOK_AUTHOR, dev.christian.jooq.gen.Keys.FK_BOOK_LANGUAGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public dev.christian.jooq.gen.tables.Book as(java.lang.String alias) {
		return new dev.christian.jooq.gen.tables.Book(alias, this);
	}

	/**
	 * Rename this table
	 */
	public dev.christian.jooq.gen.tables.Book rename(java.lang.String name) {
		return new dev.christian.jooq.gen.tables.Book(name, null);
	}
}
