package demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/calendar")
class CalendarController {

    @GetMapping("/view")
    fun getCalendar(model: Model): String {
        return "calendar/view"
    }

}