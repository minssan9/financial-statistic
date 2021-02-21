package com.core.mongorepo;

import com.core.document.EcosMongoSchema;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface EcosSchemaMongoRepo extends MongoRepository<EcosMongoSchema, ObjectId> {
//    EcosDataMongo

}
