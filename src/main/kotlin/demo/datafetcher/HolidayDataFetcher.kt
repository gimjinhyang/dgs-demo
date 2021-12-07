package demo.datafetcher

import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsData
import com.netflix.graphql.dgs.DgsDataFetchingEnvironment
import com.netflix.graphql.dgs.DgsQuery
import com.netflix.graphql.dgs.InputArgument
import demo.holiday.model.Holiday
import demo.holiday.model.HolidayDay
import demo.holiday.model.HolidayMonth
import demo.holiday.service.HolidayService

@DgsComponent
class HolidayDataFetcher(val holidayService: HolidayService) {

    @DgsQuery
    fun holidayMonth(@InputArgument year: Int, month: Int): HolidayMonth {
//        return holidayService.getOne(year, month)
        return HolidayMonth(year, month)
    }

    @DgsQuery
    fun holiday(@InputArgument year: Int, month: Int): Holiday {
        return Holiday(year, month)
    }


    //    @DgsData(parentType = "HolidayMonth", field = "dayList")
//    fun getDayList(ddfe: DgsDataFetchingEnvironment): List<HolidayDay> {
//        val month: HolidayMonth = ddfe.getSource()
//        return holidayService.getDayList(month.year, month.month)
//    }


    @DgsData(parentType = "HolidayMonth", field = "dayList")
    fun dayList1(ddfe: DgsDataFetchingEnvironment): List<HolidayDay> {
        val month: HolidayMonth = ddfe.getSource()
        return holidayService.getDayList(month.year, month.month)
    }

    @DgsData(parentType = "Holiday", field = "dayList")
    fun dayList2(ddfe: DgsDataFetchingEnvironment): List<HolidayDay> {
        val holiday: Holiday = ddfe.getSource()
        return holidayService.getDayList(holiday.year, holiday.month)
    }

}