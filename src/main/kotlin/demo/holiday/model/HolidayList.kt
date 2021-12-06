package demo.holiday.model

import demo.jpa.holiday.model.HolidayDayEntity
import demo.jpa.holiday.model.HolidayMonthEntity
import demo.openapi.datagokr.model.SpcdeInfoItem
import demo.redis.holiday.model.HolidayMonthHash
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class HolidayList {

    val year: Int

    val month: Int

    val day: Int

    val name: String?

    constructor(month: HolidayMonthEntity, day: HolidayDayEntity) {
        this.year = month.year
        this.month = month.month
        this.day = day.day
        this.name = day.name
    }

    constructor(month: HolidayMonthHash, day: HolidayMonthHash.Day) {
        this.year = month.year
        this.month = month.month
        this.day = day.day
        this.name = day.name
    }

    constructor(item: SpcdeInfoItem) {
        val date = LocalDate.parse(item.locdate, DateTimeFormatter.BASIC_ISO_DATE)
        this.year = date.year
        this.month = date.dayOfMonth
        this.day = date.dayOfMonth
        this.name = item.dateName
    }

}
