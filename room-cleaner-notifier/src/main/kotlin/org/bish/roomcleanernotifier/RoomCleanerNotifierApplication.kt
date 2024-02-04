package org.bish.roomcleanernotifier

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class RoomCleanerNotifierApplication {
	final val QUEUE_NAME: String = "room-cleaner"
	final val EXCHANGE_NAME: String = "operations"

	@Bean
	fun queue(): Queue {
		return Queue(QUEUE_NAME, false)
	}

	@Bean
	fun exchange(): TopicExchange {
		return TopicExchange(EXCHANGE_NAME)
	}

	@Bean
	fun binding(queue: Queue, exchange: TopicExchange): Binding {
		return BindingBuilder.bind(queue).to(exchange).with("landon.rooms.cleaner")
	}
}

fun main(args: Array<String>) {
	runApplication<RoomCleanerNotifierApplication>(*args)
}


