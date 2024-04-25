/*
 * This file is generated by jOOQ.
 */
package ru.itis.agona.model.jooq.schema.tables;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;

import org.jooq.Field;
import org.jooq.ForeignKey;
import org.jooq.Function4;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row4;
import org.jooq.Schema;
import org.jooq.SelectField;
import org.jooq.Table;
import org.jooq.TableField;
import org.jooq.TableOptions;
import org.jooq.UniqueKey;
import org.jooq.impl.DSL;
import org.jooq.impl.SQLDataType;
import org.jooq.impl.TableImpl;

import ru.itis.agona.model.jooq.schema.Keys;
import ru.itis.agona.model.jooq.schema.Public;
import ru.itis.agona.model.jooq.schema.tables.records.FavoriteDishesRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class FavoriteDishes extends TableImpl<FavoriteDishesRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.favorite_dishes</code>
     */
    public static final FavoriteDishes FAVORITE_DISHES_ENTITY = new FavoriteDishes();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FavoriteDishesRecord> getRecordType() {
        return FavoriteDishesRecord.class;
    }

    /**
     * The column <code>public.favorite_dishes.id</code>.
     */
    public final TableField<FavoriteDishesRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.favorite_dishes.user_id</code>.
     */
    public final TableField<FavoriteDishesRecord, UUID> USER_ID = createField(DSL.name("user_id"), SQLDataType.UUID, this, "");

    /**
     * The column <code>public.favorite_dishes.times_eaten</code>.
     */
    public final TableField<FavoriteDishesRecord, Short> TIMES_EATEN = createField(DSL.name("times_eaten"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.favorite_dishes.average_weight</code>.
     */
    public final TableField<FavoriteDishesRecord, Short> AVERAGE_WEIGHT = createField(DSL.name("average_weight"), SQLDataType.SMALLINT, this, "");

    private FavoriteDishes(Name alias, Table<FavoriteDishesRecord> aliased) {
        this(alias, aliased, null);
    }

    private FavoriteDishes(Name alias, Table<FavoriteDishesRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.favorite_dishes</code> table reference
     */
    public FavoriteDishes(String alias) {
        this(DSL.name(alias), FAVORITE_DISHES_ENTITY);
    }

    /**
     * Create an aliased <code>public.favorite_dishes</code> table reference
     */
    public FavoriteDishes(Name alias) {
        this(alias, FAVORITE_DISHES_ENTITY);
    }

    /**
     * Create a <code>public.favorite_dishes</code> table reference
     */
    public FavoriteDishes() {
        this(DSL.name("favorite_dishes"), null);
    }

    public <O extends Record> FavoriteDishes(Table<O> child, ForeignKey<O, FavoriteDishesRecord> key) {
        super(child, key, FAVORITE_DISHES_ENTITY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<FavoriteDishesRecord> getPrimaryKey() {
        return Keys.FAVORITE_DISHES_PKEY;
    }

    @Override
    public List<ForeignKey<FavoriteDishesRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FAVORITE_DISHES__FK_USER_ID);
    }

    private transient Users _users;

    /**
     * Get the implicit join path to the <code>public.users</code> table.
     */
    public Users users() {
        if (_users == null)
            _users = new Users(this, Keys.FAVORITE_DISHES__FK_USER_ID);

        return _users;
    }

    @Override
    public FavoriteDishes as(String alias) {
        return new FavoriteDishes(DSL.name(alias), this);
    }

    @Override
    public FavoriteDishes as(Name alias) {
        return new FavoriteDishes(alias, this);
    }

    @Override
    public FavoriteDishes as(Table<?> alias) {
        return new FavoriteDishes(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public FavoriteDishes rename(String name) {
        return new FavoriteDishes(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public FavoriteDishes rename(Name name) {
        return new FavoriteDishes(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public FavoriteDishes rename(Table<?> name) {
        return new FavoriteDishes(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row4 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row4<UUID, UUID, Short, Short> fieldsRow() {
        return (Row4) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function4<? super UUID, ? super UUID, ? super Short, ? super Short, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function4<? super UUID, ? super UUID, ? super Short, ? super Short, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}