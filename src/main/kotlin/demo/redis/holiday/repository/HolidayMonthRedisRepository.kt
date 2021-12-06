package demo.redis.holiday.repository;

import demo.redis.holiday.model.HolidayMonthHash
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface HolidayMonthRedisRepository : CrudRepository<HolidayMonthHash, String> {

}
