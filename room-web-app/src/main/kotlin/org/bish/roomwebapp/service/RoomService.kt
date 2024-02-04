package org.bish.roomwebapp.service

import org.bish.roomwebapp.data.RoomRepository
import org.bish.roomwebapp.models.Room
import org.springframework.stereotype.Service

@Service
class RoomService(val roomRepository: RoomRepository) {

    fun getAllRooms(): List<Room> {
        return roomRepository.findAll()
    }

    fun getById(id: Long): Room {
        return roomRepository.findById(id).get()
    }
}