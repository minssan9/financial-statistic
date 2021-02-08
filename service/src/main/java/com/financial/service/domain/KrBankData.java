package com.voyagerss.financial.domain;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@NoArgsConstructor
@Table(name = "krbankdata")
public class KrBankData  implements Serializable {
        @Column(name = "id")
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        Long id;

        @SerializedName("UNIT_NAME")  @Expose @Column(name = "UNIT_NAME")         String unit_name;
        @SerializedName("STAT_NAME")  @Expose @Column(name = "STAT_NAME")         String stat_name;
        @SerializedName("ITEM_CODE1") @Expose @Column(name = "ITEM_CODE1")         String item_code1;
        @SerializedName("STAT_CODE")  @Expose @Column(name = "STAT_CODE")         String stat_code;
        @SerializedName("ITEM_CODE2") @Expose @Column(name = "ITEM_CODE2")         String item_code2;
        @SerializedName("ITEM_CODE3") @Expose @Column(name = "ITEM_CODE3")         String item_code3;
        @SerializedName("ITEM_NAME1") @Expose @Column(name = "ITEM_NAME1")         String item_name1;
        @SerializedName("ITEM_NAME2") @Expose @Column(name = "ITEM_NAME2")         String item_name2;
        @SerializedName("DATA_VALUE") @Expose @Column(name = "DATA_VALUE")         String data_value;
        @SerializedName("ITEM_NAME3") @Expose @Column(name = "ITEM_NAME3")         String item_name3;
        @SerializedName("TIME")       @Expose @Column(name = "TIME")                String  time;
}
