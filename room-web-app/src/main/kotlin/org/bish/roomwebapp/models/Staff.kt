package org.bish.roomwebapp.models

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name="EMPLOYEE")
data class Staff (
    @Id
    @Column(name="EMPLOYEE_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val idNumber: String? = UUID.randomUUID().toString(),
    @Column(name="FIRST_NAME")
    val firstName: String? = null,
    @Column(name="LAST_NAME")
    val lastName: String? = null,
    @Column(name="POSITION")
    @Enumerated(value=EnumType.STRING)
    val position: Position? = null
)