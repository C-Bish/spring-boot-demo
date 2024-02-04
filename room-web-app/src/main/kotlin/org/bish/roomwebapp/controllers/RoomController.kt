package org.bish.roomwebapp.controllers

import org.bish.roomwebapp.models.Room
import org.bish.roomwebapp.service.RoomService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/rooms")
class RoomController(val roomService: RoomService) {

    @GetMapping
    fun getAllRooms(model: Model): String {
        model.addAttribute("rooms", roomService.getAllRooms())
        return "rooms"
    }
}