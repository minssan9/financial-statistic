package com.core.mongorepo;

import com.core.document.EcosMongoData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface EcosDataMongoRepo extends MongoRepository<EcosMongoData, ObjectId> {

}
