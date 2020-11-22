package com.minssan9.financial.krbank.Domain

import lombok.Data
import javax.persistence.Entity
import javax.persistence.Id

@Entity
@Data
class KbData{
    @Id
    var id : Long = 0

    var unit_name : String = ""
    var item_code1 : String = ""
    var stat_code : String = ""
    var item_code2 : String = ""
    var item_code3 : String = ""
    var item_name1 : String = ""
    var item_name2 : String = ""
    var data_value : Double = 0.0
    var item_name3 : String = ""
    var time : String = ""
}
