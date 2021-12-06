package demo.jpa.event.repository;

import org.springframework.data.jpa.repository.JpaRepository
import demo.jpa.event.model.EventEntity

interface EventRepository : JpaRepository<EventEntity, Int> {

}
