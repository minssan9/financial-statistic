package com.service.mongorepo;

import com.service.document.EcosSchemaMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface EcosSchemaMongoRepo extends MongoRepository<EcosSchemaMongo, ObjectId> {
//    EcosDataMongo

}
