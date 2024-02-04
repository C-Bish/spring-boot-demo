package org.bish.roomwebapp.endpoints

import org.springframework.boot.actuate.endpoint.annotation.Endpoint
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation
import org.springframework.stereotype.Component

@Component
@Endpoint(id="greeting")
class GreetingEndpoint {

    @ReadOperation
    fun getGreeting(): String {
        return "Hello from actuator"
    }
}