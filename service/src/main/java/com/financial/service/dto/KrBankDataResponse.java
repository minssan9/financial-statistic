package com.financial.service.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import lombok.Data;

@Data
public class KrBankDataResponse implements Serializable {

    @SerializedName("StatisticSearch")
    @Expose
    public StatisticSearch statisticSearch;


}

