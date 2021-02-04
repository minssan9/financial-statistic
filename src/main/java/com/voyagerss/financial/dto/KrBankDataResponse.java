package com.voyagerss.financial.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.voyagerss.financial.domain.KrBankData;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class KrBankDataResponse implements Serializable {

    @SerializedName("StatisticSearch")
    @Expose
    public StatisticSearch statisticSearch;


}

