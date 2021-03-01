package com.core.document;

import com.core.domain.EcosData;
import javax.persistence.Id;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Document
public class EcosMongoData extends EcosData{
        @Id
        private ObjectId _id;

}
