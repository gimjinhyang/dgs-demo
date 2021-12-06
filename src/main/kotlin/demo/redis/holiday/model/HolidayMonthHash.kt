package demo.redis.holiday.model

import demo.jpa.holiday.model.HolidayDayEntity
import demo.jpa.holiday.model.HolidayMonthEntity
import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash(value = "holiday_month", timeToLive = 60 * 60 * 24)
class HolidayMonthHash {

    @Id
    var id: String = ""

    var year: Int = 0

    var month: Int = 0

    var dayList: MutableList<Day> = mutableListOf()


    class Day {

        var day: Int = 0

        var name: String = ""

        constructor()

        constructor(entity: HolidayDayEntity) {
            this.day = entity.day
            this.name = entity.name
        }


    }


    constructor()

    constructor(entity: HolidayMonthEntity) {
        this.id = "${entity.year}${entity.month}"
        this.year = entity.year
        this.month = entity.month

        entity.dayList.forEach {
            this.dayList.add(Day(it))
        }
    }


}
