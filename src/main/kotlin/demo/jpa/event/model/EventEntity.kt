package demo.jpa.event.model

import javax.persistence.*

@Table(name = "event", schema = "test")
@Entity
open class EventEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    open var id: Int? = null

    @Column(name = "text")
    open var text: String? = null

}