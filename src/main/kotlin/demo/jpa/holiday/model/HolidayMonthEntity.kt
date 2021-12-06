package demo.jpa.holiday.model

import demo.openapi.datagokr.model.SpcdeInfoItem
import javax.persistence.*

@Table(name = "holiday_month", schema = "test")
@Entity
class HolidayMonthEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "holiday_month_id", nullable = false, updatable = false)
    var holidayMonthId: Int? = null

    @Column(name = "year", updatable = false)
    val year: Int

    @Column(name = "month", updatable = false)
    val month: Int

    @OneToMany(mappedBy = "month", fetch = FetchType.LAZY, cascade = [CascadeType.PERSIST])
    val dayList: MutableList<HolidayDayEntity> = mutableListOf()


    constructor(year: Int, month: Int, itemList: MutableList<SpcdeInfoItem>) {
        this.year = year
        this.month = month

        if (!itemList.isNullOrEmpty()) {
            itemList.forEach {
                this.dayList.add(HolidayDayEntity(it, this))
            }
        }
    }

}