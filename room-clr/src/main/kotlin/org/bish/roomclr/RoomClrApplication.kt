package org.bish.roomclr

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.web.client.RestTemplate

@SpringBootApplication
class RoomClrApplication {

	private final val LOG = LoggerFactory.getLogger(this.javaClass)

	@Bean
	fun restTemplate(builder: RestTemplateBuilder): RestTemplate {
		return builder.build()
	}

	@Bean
	fun run(restTemplate: RestTemplate): CommandLineRunner {
		return CommandLineRunner {
			LOG.info("Starting CLR App")
			val rooms: ResponseEntity<List<Room>> = restTemplate.exchange("http://localhost:8080/api/rooms",
				HttpMethod.GET, null,
				object : ParameterizedTypeReference<List<Room>>() {}
			)
			rooms.body?.forEach { room: Room -> LOG.info(room.toString()) }
			LOG.info("Finishing CLR App")
		}
	}
}

fun main(args: Array<String>) {
	runApplication<RoomClrApplication>(*args)
}

