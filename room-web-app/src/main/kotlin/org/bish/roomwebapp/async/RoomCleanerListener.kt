package org.bish.roomwebapp.async

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.bish.roomwebapp.models.Room
import org.bish.roomwebapp.service.RoomService
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class RoomCleanerListener(val mapper: ObjectMapper, val roomService: RoomService) {

    final val LOG: Logger = LoggerFactory.getLogger(this.javaClass)

    fun receiveMessage(message: String) {
        try {
            val payload: AsyncPayload = mapper.readValue(message, AsyncPayload::class.java)
            if ("ROOM".equals(payload.model)) {
                val room: Room = roomService.getById(payload.id)
                LOG.info("ROOM {}:{} needs to be cleaned", room.number, room.name)
            } else {
                LOG.warn("Unknown model type")
            }
        } catch (e: JsonProcessingException) {
            LOG.error(e.message)
        }
    }
}