package demo.openapi.datagokr.model

import demo.openapi.datagokr.model.SpcdeInfoItems
import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "body")
@XmlAccessorType(XmlAccessType.FIELD)
data class SpcdeInfoBody(
    @field:XmlElement(name = "items") val items: SpcdeInfoItems? = null,
    val numOfRows: Int? = null,
    val pageNo: Int? = null,
    val totalCount: Int? = null
)
