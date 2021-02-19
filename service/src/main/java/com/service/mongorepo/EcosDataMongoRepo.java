package com.service.mongorepo;

import com.service.document.EcosDataMongo;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface EcosDataMongoRepo extends MongoRepository<EcosDataMongo, ObjectId> {

}
