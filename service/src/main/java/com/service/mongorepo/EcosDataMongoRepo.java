package com.service.mongorepo;

import com.service.domain.KrBankData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public
interface EcosDataMongoRepo extends MongoRepository<KrBankData, ObjectId> {

}
