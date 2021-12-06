package demo.openapi.datagokr.model

import javax.xml.bind.annotation.XmlAccessType
import javax.xml.bind.annotation.XmlAccessorType
import javax.xml.bind.annotation.XmlRootElement

@XmlRootElement(name = "header")
@XmlAccessorType(XmlAccessType.FIELD)
data class SpcdeInfoHeader(
    val resultCode: String? = null, val resultMsg: String? = null
)
