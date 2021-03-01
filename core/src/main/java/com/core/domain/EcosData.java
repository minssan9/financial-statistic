package com.core.domain;

import com.google.gson.annotations.Expose;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Field;

@NoArgsConstructor
@Data
@Entity
@Table(name = "ecosdata")
public class EcosData {
        @Column(name = "id")
        @Id
        @GeneratedValue
        Long id;

        @Field("unitName")  @Expose @Column(name = "UNIT_NAME")         String unitName;
        @Field("statName")  @Expose @Column(name = "STAT_NAME")         String statName;
        @Field("statCode")  @Expose @Column(name = "STAT_CODE")         String statCode;
        @Field("itemCode1") @Expose @Column(name = "ITEM_CODE1")         String itemCode1;
        @Field("itemCode2") @Expose @Column(name = "ITEM_CODE2")         String itemCode2;
        @Field("itemCode3") @Expose @Column(name = "ITEM_CODE3")         String itemCode3;
        @Field("itemName1") @Expose @Column(name = "ITEM_NAME1")         String itemName1;
        @Field("itemName2") @Expose @Column(name = "ITEM_NAME2")         String itemName2;
        @Field("itemName3") @Expose @Column(name = "ITEM_NAME3")         String itemName3;
        @Field("dataValue") @Expose @Column(name = "DATA_VALUE")         String dataValue;
        @Field("createdDate")       @Expose @Column(name = "createdDate")        String  createdDate;
}


//@Entity
//@Table(name = "krbankdata")
//class EcosMysqlData extends EcosData     {
//        @Column(name = "id")
//        @Id
//        @GeneratedValue
//        Long id;
//
//        @SerializedName("UNIT_NAME")  @Expose @Column(name = "UNIT_NAME")         String unitName;
//        @SerializedName("STAT_NAME")  @Expose @Column(name = "STAT_NAME")         String statName;
//        @SerializedName("STAT_CODE")  @Expose @Column(name = "STAT_CODE")         String statCode;
//        @SerializedName("ITEM_CODE1") @Expose @Column(name = "ITEM_CODE1")         String itemCode1;
//        @SerializedName("ITEM_CODE2") @Expose @Column(name = "ITEM_CODE2")         String itemCode2;
//        @SerializedName("ITEM_CODE3") @Expose @Column(name = "ITEM_CODE3")         String itemCode3;
//        @SerializedName("ITEM_NAME1") @Expose @Column(name = "ITEM_NAME1")         String itemName1;
//        @SerializedName("ITEM_NAME2") @Expose @Column(name = "ITEM_NAME2")         String itemName2;
//        @SerializedName("ITEM_NAME3") @Expose @Column(name = "ITEM_NAME3")         String itemName3;
//        @SerializedName("DATA_VALUE") @Expose @Column(name = "DATA_VALUE")         String dataValue;
//        @SerializedName("TIME")       @Expose @Column(name = "createdDate")        String  createdDate;
//}
