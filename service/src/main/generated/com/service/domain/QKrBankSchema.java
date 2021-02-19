package com.service.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QKrBankSchema is a Querydsl query type for KrBankSchema
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QKrBankSchema extends EntityPathBase<KrBankSchema> {

    private static final long serialVersionUID = -107544280L;

    public static final QKrBankSchema krBankSchema = new QKrBankSchema("krBankSchema");

    public final StringPath cycle = createString("cycle");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath orgname = createString("orgname");

    public final StringPath pstatcode = createString("pstatcode");

    public final StringPath searchFlag = createString("searchFlag");

    public final StringPath statcode = createString("statcode");

    public final StringPath statname = createString("statname");

    public QKrBankSchema(String variable) {
        super(KrBankSchema.class, forVariable(variable));
    }

    public QKrBankSchema(Path<? extends KrBankSchema> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKrBankSchema(PathMetadata metadata) {
        super(KrBankSchema.class, metadata);
    }

}

