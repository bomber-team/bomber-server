package bomber.models

import java.sql.Timestamp
import javax.persistence.*

@Entity
@Table(name = "devices")
class Device {
    @Id
    @GeneratedValue
    @Column(name = "id")
    val id: Long? = null

    @Column(name = "ip", nullable = false)
    lateinit var ip: String

    @Column(name = "name", nullable = false)
    lateinit var name: String

    @Column(name = "lastActivity", nullable = false)
    lateinit var lastActivity: Timestamp
}