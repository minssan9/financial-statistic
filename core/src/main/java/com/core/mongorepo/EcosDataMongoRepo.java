package com.core.mongorepo;

import com.core.domain.EcosData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface EcosDataMongoRepo extends MongoRepository<EcosData, ObjectId> {

}
