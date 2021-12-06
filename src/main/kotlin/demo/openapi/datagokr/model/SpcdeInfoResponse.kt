package demo.openapi.datagokr.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlElement
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "response")
@XmlAccessorType(XmlAccessType.FIELD)
data class SpcdeInfoResponse(
    @field:XmlElement(name = "header") val header: SpcdeInfoHeader? = null,
    @field:XmlElement(name = "body") val body: SpcdeInfoBody? = null
)