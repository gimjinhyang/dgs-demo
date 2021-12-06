package demo.openapi.datagokr.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "items")
@XmlAccessorType(XmlAccessType.FIELD)
data class SpcdeInfoItems(
    @field:XmlElement(name = "item") var item: MutableList<SpcdeInfoItem>? = null
)