package org.bish.roomwebapp.service

import org.bish.roomwebapp.data.StaffRepository
import org.bish.roomwebapp.models.Staff
import org.springframework.stereotype.Service

@Service
class StaffService(val staffRepository: StaffRepository) {

    fun getAllStaff(): List<Staff> {
        return staffRepository.findAll()
    }
}