package org.bish.roomwebapp.models

import jakarta.persistence.*

@Entity
@Table(name="ROOM")
data class Room(
    @Id
    @Column(name="ROOM_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    @Column(name="ROOM_NUMBER")
    val number: String? = null,
    @Column(name="NAME")
    val name: String? = null,
    @Column(name="BED_INFO")
    val info: String? = null
)