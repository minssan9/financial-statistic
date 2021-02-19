package com.service.document;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.service.domain.KrBankData;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@Document
@Data
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

        public EcosDataMongo(KrBankData krBankData){
                this.unit_name = krBankData.getUnitName();
                this.stat_name = krBankData.getStatName();
                this.item_code1 = krBankData.getItemCode1();
                this.stat_code = krBankData.getStatCode();
                this.item_code2 = krBankData.getItemCode2();
                this.item_code3 = krBankData.getItemCode3();
                this.item_name1 = krBankData.getItemName1();
                this.item_name2 = krBankData.getItemName2();
                this.data_value = krBankData.getDataValue();
                this.item_name3 = krBankData.getItemName3();
                this.time = krBankData.getCreatedDate();
        }
}
