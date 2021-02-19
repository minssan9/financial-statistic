package com.service.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QKrBankData is a Querydsl query type for KrBankData
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QKrBankData extends EntityPathBase<KrBankData> {

    private static final long serialVersionUID = 1746923761L;

    public static final QKrBankData krBankData = new QKrBankData("krBankData");

    public final StringPath createdDate = createString("createdDate");

    public final StringPath dataValue = createString("dataValue");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath itemCode1 = createString("itemCode1");

    public final StringPath itemCode2 = createString("itemCode2");

    public final StringPath itemCode3 = createString("itemCode3");

    public final StringPath itemName1 = createString("itemName1");

    public final StringPath itemName2 = createString("itemName2");

    public final StringPath itemName3 = createString("itemName3");

    public final StringPath statCode = createString("statCode");

    public final StringPath statName = createString("statName");

    public final StringPath unitName = createString("unitName");

    public QKrBankData(String variable) {
        super(KrBankData.class, forVariable(variable));
    }

    public QKrBankData(Path<? extends KrBankData> path) {
        super(path.getType(), path.getMetadata());
    }

    public QKrBankData(PathMetadata metadata) {
        super(KrBankData.class, metadata);
    }

}

