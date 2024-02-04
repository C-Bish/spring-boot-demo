package org.bish.roomwebapp.config

import org.bish.roomwebapp.async.RoomCleanerListener
import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.ConnectionFactory
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AsyncConfig {

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

    @Bean
    fun listenerAdapter(listener: RoomCleanerListener): MessageListenerAdapter {
        return MessageListenerAdapter(listener, "receiveMessage")
    }

    @Bean
    fun container(connectionFactory: ConnectionFactory, listenerAdapter: MessageListenerAdapter): SimpleMessageListenerContainer {
        val container: SimpleMessageListenerContainer = SimpleMessageListenerContainer()
        container.connectionFactory = connectionFactory
        container.setQueueNames(QUEUE_NAME)
        container.setMessageListener(listenerAdapter)
        return container
    }
}