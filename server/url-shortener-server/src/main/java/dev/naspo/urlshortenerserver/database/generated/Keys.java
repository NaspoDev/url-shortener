/*
 * This file is generated by jOOQ.
 */
package dev.naspo.urlshortenerserver.database.generated;


import dev.naspo.urlshortenerserver.database.generated.tables.Urls;
import dev.naspo.urlshortenerserver.database.generated.tables.records.UrlsRecord;

import org.jooq.TableField;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.Internal;


/**
 * A class modelling foreign key relationships and constraints of tables in
 * url_shortener.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes", "this-escape" })
public class Keys {

    // -------------------------------------------------------------------------
    // UNIQUE and PRIMARY KEY definitions
    // -------------------------------------------------------------------------

    public static final UniqueKey<UrlsRecord> KEY_URLS_PRIMARY = Internal.createUniqueKey(Urls.URLS, DSL.name("KEY_urls_PRIMARY"), new TableField[] { Urls.URLS.ID }, true);
}