package demo.holiday.model

import demo.jpa.holiday.model.HolidayMonthEntity
import demo.openapi.datagokr.model.SpcdeInfoItem
import demo.redis.holiday.model.HolidayMonthHash

class Holiday {

    val year: Int

    val month: Int

    val dayList: MutableList<HolidayDay> = mutableListOf()

    constructor(month: HolidayMonthEntity) {
        this.year = month.year
        this.month = month.month

        month.dayList.forEach {
            this.dayList.add(HolidayDay(it))
        }
    }

    constructor(month: HolidayMonthHash) {
        this.year = month.year
        this.month = month.month

        month.dayList.forEach {
            this.dayList.add(HolidayDay(it))
        }
    }

    constructor(year: Int, month: Int, itemList: MutableList<SpcdeInfoItem>) {
        this.year = year
        this.month = month

        itemList.forEach {
            this.dayList.add(HolidayDay(it))
        }
    }

    constructor(year: Int, month: Int) {
        this.year = year
        this.month = month
    }

}
