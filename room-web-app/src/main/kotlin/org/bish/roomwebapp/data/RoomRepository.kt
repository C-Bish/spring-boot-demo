package org.bish.roomwebapp.data

import org.bish.roomwebapp.models.Room
import org.springframework.data.jpa.repository.JpaRepository

interface RoomRepository : JpaRepository<Room, Long> {

}