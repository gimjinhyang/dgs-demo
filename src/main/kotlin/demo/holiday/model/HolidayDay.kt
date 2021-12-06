package demo.holiday.model

import demo.jpa.holiday.model.HolidayDayEntity
import demo.openapi.datagokr.model.SpcdeInfoItem
import demo.redis.holiday.model.HolidayMonthHash
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HolidayDay {

    val day: Int

    val name: String?

    constructor(day: HolidayDayEntity) {
        this.day = day.day
        this.name = day.name
    }

    constructor(day: HolidayMonthHash.Day) {
        this.day = day.day
        this.name = day.name
    }

    constructor(item: SpcdeInfoItem) {
        val date = LocalDate.parse(item.locdate, DateTimeFormatter.BASIC_ISO_DATE)
        this.day = date.dayOfMonth
        this.name = item.dateName
    }

}
