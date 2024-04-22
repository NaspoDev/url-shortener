/*
 * This file is generated by jOOQ.
 */
package dev.naspo.urlshortenerserver.database.generated.tables;


import dev.naspo.urlshortenerserver.database.generated.Keys;
import dev.naspo.urlshortenerserver.database.generated.UrlShortener;
import dev.naspo.urlshortenerserver.database.generated.tables.records.UrlsRecord;

import java.util.Collection;

import org.jooq.Condition;
import org.jooq.Field;
import org.jooq.Identity;
import org.jooq.Name;
import org.jooq.PlainSQL;
import org.jooq.QueryPart;
import org.jooq.SQL;
import org.jooq.Schema;
import org.jooq.Select;
import org.jooq.Stringly;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Urls extends TableImpl<UrlsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>url_shortener.urls</code>
     */
    public static final Urls URLS = new Urls();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<UrlsRecord> getRecordType() {
        return UrlsRecord.class;
    }

    /**
     * The column <code>url_shortener.urls.id</code>.
     */
    public final TableField<UrlsRecord, Integer> ID = createField(DSL.name("id"), SQLDataType.INTEGER.nullable(false).identity(true), this, "");

    /**
     * The column <code>url_shortener.urls.original_url</code>.
     */
    public final TableField<UrlsRecord, String> ORIGINAL_URL = createField(DSL.name("original_url"), SQLDataType.VARCHAR(2048).nullable(false), this, "");

    /**
     * The column <code>url_shortener.urls.token</code>.
     */
    public final TableField<UrlsRecord, String> TOKEN = createField(DSL.name("token"), SQLDataType.VARCHAR(5).nullable(false), this, "");

    private Urls(Name alias, Table<UrlsRecord> aliased) {
        this(alias, aliased, (Field<?>[]) null, null);
    }

    private Urls(Name alias, Table<UrlsRecord> aliased, Field<?>[] parameters, Condition where) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table(), where);
    }

    /**
     * Create an aliased <code>url_shortener.urls</code> table reference
     */
    public Urls(String alias) {
        this(DSL.name(alias), URLS);
    }

    /**
     * Create an aliased <code>url_shortener.urls</code> table reference
     */
    public Urls(Name alias) {
        this(alias, URLS);
    }

    /**
     * Create a <code>url_shortener.urls</code> table reference
     */
    public Urls() {
        this(DSL.name("urls"), null);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : UrlShortener.URL_SHORTENER;
    }

    @Override
    public Identity<UrlsRecord, Integer> getIdentity() {
        return (Identity<UrlsRecord, Integer>) super.getIdentity();
    }

    @Override
    public UniqueKey<UrlsRecord> getPrimaryKey() {
        return Keys.KEY_URLS_PRIMARY;
    }

    @Override
    public Urls as(String alias) {
        return new Urls(DSL.name(alias), this);
    }

    @Override
    public Urls as(Name alias) {
        return new Urls(alias, this);
    }

    @Override
    public Urls as(Table<?> alias) {
        return new Urls(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Urls rename(String name) {
        return new Urls(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Urls rename(Name name) {
        return new Urls(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Urls rename(Table<?> name) {
        return new Urls(name.getQualifiedName(), null);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Urls where(Condition condition) {
        return new Urls(getQualifiedName(), aliased() ? this : null, null, condition);
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Urls where(Collection<? extends Condition> conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Urls where(Condition... conditions) {
        return where(DSL.and(conditions));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Urls where(Field<Boolean> condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Urls where(SQL condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Urls where(@Stringly.SQL String condition) {
        return where(DSL.condition(condition));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Urls where(@Stringly.SQL String condition, Object... binds) {
        return where(DSL.condition(condition, binds));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    @PlainSQL
    public Urls where(@Stringly.SQL String condition, QueryPart... parts) {
        return where(DSL.condition(condition, parts));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Urls whereExists(Select<?> select) {
        return where(DSL.exists(select));
    }

    /**
     * Create an inline derived table from this table
     */
    @Override
    public Urls whereNotExists(Select<?> select) {
        return where(DSL.notExists(select));
    }
}
