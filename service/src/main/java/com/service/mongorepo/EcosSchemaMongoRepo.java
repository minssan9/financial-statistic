package com.service.mongorepo;

import com.service.domain.EcosDataMongo;
import com.service.domain.EcosSchemaMongo;
import com.service.domain.KrBankData;
import com.service.domain.KrBankSchema;
import org.bson.types.ObjectId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface EcosSchemaMongoRepo extends MongoRepository<EcosSchemaMongo, ObjectId> {
//    EcosDataMongo

}
