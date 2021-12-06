package demo.controller

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/event")
class EventController {

    @GetMapping("/list")
    fun getEventList(model: Model): String {
        model["title"] = "Event !!"
        return "event/list"
    }

}