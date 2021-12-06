package demo.jpa.holiday.repository;

import org.springframework.data.jpa.repository.JpaRepository
import demo.jpa.holiday.model.HolidayMonthEntity
import java.util.*

interface HolidayMonthJpaRepository : JpaRepository<HolidayMonthEntity, Int> {

    fun findTopByYearAndMonth(year: Int, month: Int): Optional<HolidayMonthEntity>

}
