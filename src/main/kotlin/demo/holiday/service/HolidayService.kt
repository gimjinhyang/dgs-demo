package demo.holiday.service

import demo.holiday.model.HolidayDay
import demo.holiday.model.HolidayMonth
import demo.jpa.holiday.model.HolidayMonthEntity
import demo.jpa.holiday.repository.HolidayMonthJpaRepository
import demo.openapi.datagokr.model.SpcdeInfoItem
import demo.openapi.datagokr.service.SpcdeInfoService
import demo.redis.holiday.model.HolidayMonthHash
import demo.redis.holiday.repository.HolidayMonthRedisRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class HolidayService(
    val holidayMonthJpaRepository: HolidayMonthJpaRepository,
    val holidayMonthRedisRepository: HolidayMonthRedisRepository,
    val spcdeInfoService: SpcdeInfoService,
) {

    fun getOne(year: Int, month: Int): HolidayMonth {
        val hash = getMonthHash(year, month)
        if (hash.isPresent) {
            return HolidayMonth(hash.get())
        }

        val entity = getMonthEntity(year, month)
        if (entity.isPresent) {
            saveMonthHash(entity.get())
            return HolidayMonth(entity.get())
        }

        val itemList = spcdeInfoService.getHoliDeInfo(year, month)
        saveMonthEntity(year, month, itemList)
        return HolidayMonth(year, month, itemList)
    }

    private fun saveMonthEntity(year: Int, month: Int, itemList: MutableList<SpcdeInfoItem>) {
        val entity = HolidayMonthEntity(year, month, itemList)
        holidayMonthJpaRepository.save(entity)
    }

    private fun saveMonthHash(entity: HolidayMonthEntity) {
        val hash = HolidayMonthHash(entity)
        holidayMonthRedisRepository.save(hash)
    }

    private fun getMonthHash(year: Int, month: Int): Optional<HolidayMonthHash> {
        return holidayMonthRedisRepository.findById("$year$month")
    }

    private fun getMonthEntity(year: Int, month: Int): Optional<HolidayMonthEntity> {
        return holidayMonthJpaRepository.findTopByYearAndMonth(year, month)
    }

    fun getDayList(year: Int, month: Int): List<HolidayDay> {
        val hash = getMonthHash(year, month)
        if (hash.isPresent) {
            return hash.get().dayList.map { HolidayDay(it) }.toList()
        }

        val entity = getMonthEntity(year, month)
        if (entity.isPresent) {
            saveMonthHash(entity.get())
            return entity.get().dayList.map { HolidayDay(it) }.toList()
        }

        val itemList = spcdeInfoService.getHoliDeInfo(year, month)
        saveMonthEntity(year, month, itemList)
        return itemList.map { HolidayDay(it) }.toList()
    }


}