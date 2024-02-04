package org.bish.roomcleanernotifier

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.stereotype.Component

@Component
class Runner(final val rabbitTemplate: RabbitTemplate, final val objectMapper: ObjectMapper,
             @Autowired val context: ConfigurableApplicationContext): CommandLineRunner {

    override fun run(vararg args: String?) {
        val index = (Math.random() * (28-1)) + 1
        val payload = AsyncPayload()
        payload.id = index.toLong()
        payload.model = "ROOM"
        rabbitTemplate.convertAndSend("operations", "landon.rooms.cleaner",
            objectMapper.writeValueAsString(payload))
        context.close()
    }
}