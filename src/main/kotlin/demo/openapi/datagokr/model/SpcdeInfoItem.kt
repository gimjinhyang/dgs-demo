package demo.openapi.datagokr.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
data class SpcdeInfoItem(
    val locdate: String? = null,
    val seq: Int? = null,
    val dateKind: String? = null,
    val isHoliday: String? = null,
    val dateName: String? = null
)