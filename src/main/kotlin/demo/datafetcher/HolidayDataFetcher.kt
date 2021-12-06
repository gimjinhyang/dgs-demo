package demo.datafetcher

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import demo.holiday.model.HolidayMonth
import demo.holiday.service.HolidayService

@DgsComponent
class HolidayDataFetcher(val holidayService: HolidayService) {

    @DgsQuery
    fun holiday(@InputArgument year: Int, month: Int): HolidayMonth {
        return holidayService.getOne(year, month)
    }

}