package org.bish.roomwebapp.controllers

import org.bish.roomwebapp.models.Staff
import org.bish.roomwebapp.service.StaffService
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller
@RequestMapping("/staff")
class StaffController(val staffService: StaffService) {

    @GetMapping
    fun getAllStaff(model: Model): String {
        model.addAttribute("staff", staffService.getAllStaff())
        return "staff"
    }
}