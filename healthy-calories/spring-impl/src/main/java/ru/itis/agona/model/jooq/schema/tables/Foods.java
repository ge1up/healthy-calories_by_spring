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
import org.jooq.Function8;
import org.jooq.Name;
import org.jooq.Record;
import org.jooq.Records;
import org.jooq.Row8;
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
import ru.itis.agona.model.jooq.schema.tables.records.FoodsRecord;


/**
 * This class is generated by jOOQ.
 */
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class Foods extends TableImpl<FoodsRecord> {

    private static final long serialVersionUID = 1L;

    /**
     * The reference instance of <code>public.foods</code>
     */
    public static final Foods FOODS_ENTITY = new Foods();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<FoodsRecord> getRecordType() {
        return FoodsRecord.class;
    }

    /**
     * The column <code>public.foods.id</code>.
     */
    public final TableField<FoodsRecord, UUID> ID = createField(DSL.name("id"), SQLDataType.UUID.nullable(false), this, "");

    /**
     * The column <code>public.foods.name</code>.
     */
    public final TableField<FoodsRecord, String> NAME = createField(DSL.name("name"), SQLDataType.VARCHAR(50), this, "");

    /**
     * The column <code>public.foods.proteins</code>.
     */
    public final TableField<FoodsRecord, Short> PROTEINS = createField(DSL.name("proteins"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.foods.fats</code>.
     */
    public final TableField<FoodsRecord, Short> FATS = createField(DSL.name("fats"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.foods.carbohydrates</code>.
     */
    public final TableField<FoodsRecord, Short> CARBOHYDRATES = createField(DSL.name("carbohydrates"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.foods.calories_number</code>.
     */
    public final TableField<FoodsRecord, Short> CALORIES_NUMBER = createField(DSL.name("calories_number"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.foods.type_of_food</code>.
     */
    public final TableField<FoodsRecord, Short> TYPE_OF_FOOD = createField(DSL.name("type_of_food"), SQLDataType.SMALLINT, this, "");

    /**
     * The column <code>public.foods.category_id</code>.
     */
    public final TableField<FoodsRecord, UUID> CATEGORY_ID = createField(DSL.name("category_id"), SQLDataType.UUID, this, "");

    private Foods(Name alias, Table<FoodsRecord> aliased) {
        this(alias, aliased, null);
    }

    private Foods(Name alias, Table<FoodsRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""), TableOptions.table());
    }

    /**
     * Create an aliased <code>public.foods</code> table reference
     */
    public Foods(String alias) {
        this(DSL.name(alias), FOODS_ENTITY);
    }

    /**
     * Create an aliased <code>public.foods</code> table reference
     */
    public Foods(Name alias) {
        this(alias, FOODS_ENTITY);
    }

    /**
     * Create a <code>public.foods</code> table reference
     */
    public Foods() {
        this(DSL.name("foods"), null);
    }

    public <O extends Record> Foods(Table<O> child, ForeignKey<O, FoodsRecord> key) {
        super(child, key, FOODS_ENTITY);
    }

    @Override
    public Schema getSchema() {
        return aliased() ? null : Public.PUBLIC;
    }

    @Override
    public UniqueKey<FoodsRecord> getPrimaryKey() {
        return Keys.FOODS_PKEY;
    }

    @Override
    public List<ForeignKey<FoodsRecord, ?>> getReferences() {
        return Arrays.asList(Keys.FOODS__FK_CATEGORY_ID);
    }

    private transient FoodCategories _foodCategories;

    /**
     * Get the implicit join path to the <code>public.food_categories</code>
     * table.
     */
    public FoodCategories foodCategories() {
        if (_foodCategories == null)
            _foodCategories = new FoodCategories(this, Keys.FOODS__FK_CATEGORY_ID);

        return _foodCategories;
    }

    @Override
    public Foods as(String alias) {
        return new Foods(DSL.name(alias), this);
    }

    @Override
    public Foods as(Name alias) {
        return new Foods(alias, this);
    }

    @Override
    public Foods as(Table<?> alias) {
        return new Foods(alias.getQualifiedName(), this);
    }

    /**
     * Rename this table
     */
    @Override
    public Foods rename(String name) {
        return new Foods(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Foods rename(Name name) {
        return new Foods(name, null);
    }

    /**
     * Rename this table
     */
    @Override
    public Foods rename(Table<?> name) {
        return new Foods(name.getQualifiedName(), null);
    }

    // -------------------------------------------------------------------------
    // Row8 type methods
    // -------------------------------------------------------------------------

    @Override
    public Row8<UUID, String, Short, Short, Short, Short, Short, UUID> fieldsRow() {
        return (Row8) super.fieldsRow();
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Function)}.
     */
    public <U> SelectField<U> mapping(Function8<? super UUID, ? super String, ? super Short, ? super Short, ? super Short, ? super Short, ? super Short, ? super UUID, ? extends U> from) {
        return convertFrom(Records.mapping(from));
    }

    /**
     * Convenience mapping calling {@link SelectField#convertFrom(Class,
     * Function)}.
     */
    public <U> SelectField<U> mapping(Class<U> toType, Function8<? super UUID, ? super String, ? super Short, ? super Short, ? super Short, ? super Short, ? super Short, ? super UUID, ? extends U> from) {
        return convertFrom(toType, Records.mapping(from));
    }
}