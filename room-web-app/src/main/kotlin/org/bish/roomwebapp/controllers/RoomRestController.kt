package org.bish.roomwebapp.controllers

import org.bish.roomwebapp.models.Room
import org.bish.roomwebapp.service.RoomService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/rooms")
class RoomRestController(val roomService: RoomService) {

    @GetMapping
    fun getAllRooms(): List<Room> {
        return roomService.getAllRooms()
    }

}