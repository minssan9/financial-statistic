package com.voyagerss.financial.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.voyagerss.financial.domain.KrBankData;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class StatisticSearch implements Serializable {

    @SerializedName("list_total_count")
    @Expose
    public int listTotalCount;
    @SerializedName("row")
    @Expose
    public List<KrBankData> row = null;
}
