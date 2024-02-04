package org.bish.roomclr

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
class FizzBuzzClrApplication {

	private final val LOG = LoggerFactory.getLogger(this.javaClass)
	
	@Bean
	fun run(): CommandLineRunner {
		return CommandLineRunner {
			LOG.info("Starting CLR App")

			for(x in 1..100) {
				if (x % 3 == 0 && x % 5 == 0) {
					LOG.info("$x fizz buzz")
				} else if (x % 3 == 0) {
					LOG.info("$x fizz")
				} else if (x % 5 == 0) {
					LOG.info("$x buzz")
				} else {
					LOG.info("$x")
				}
			}

			LOG.info("Finishing CLR App")
		}
	}
}

fun main(args: Array<String>) {
	runApplication<FizzBuzzClrApplication>(*args)
}

