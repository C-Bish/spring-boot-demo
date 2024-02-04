package org.bish.roomwebapp.data

import org.bish.roomwebapp.models.Staff
import org.springframework.data.jpa.repository.JpaRepository

interface StaffRepository : JpaRepository<Staff, Long> {

}