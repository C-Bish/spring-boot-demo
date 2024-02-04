package org.bish.roomwebapp.controllers

import org.bish.roomwebapp.models.Room
import org.bish.roomwebapp.models.Staff
import org.bish.roomwebapp.service.RoomService
import org.bish.roomwebapp.service.StaffService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/staff")
class StaffRestController(val staffService: StaffService) {

    @GetMapping
    fun getAllStaff(): List<Staff> {
        return staffService.getAllStaff()
    }

}