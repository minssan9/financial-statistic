package com.minssan9.financial.krbank.Dto;


data class ApiResult(
    var unit_name : String,
    var stat_name : String,
    var item_code1 : String,
    var stat_code : String,
    var item_code2 : String,
    var item_code3 : String,
    var item_name1 : String,
    var item_name2 : String,
    var data_value : Double,
    var item_name3 : String,
    var time : String
)

