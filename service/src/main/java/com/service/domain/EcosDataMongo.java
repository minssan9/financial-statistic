package com.service.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Document
public class EcosDataMongo  {
        @Id
        private ObjectId _id;

        private String unit_name;
        private String stat_name;
        private String item_code1;
        private String stat_code;
        private String item_code2;
        private String item_code3;
        private String item_name1;
        private String item_name2;
        private String data_value;
        private String item_name3;
        private String  time;
}
