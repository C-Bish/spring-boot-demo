package org.bish.roomwebapp.models

enum class Position {
    HOUSEKEEPING, FRONT_DESK, SECURITY, CONCIERGE;

    override fun toString(): String {
        when (this) {
            CONCIERGE -> return "Concierge"
            HOUSEKEEPING -> return "Housekeeping"
            FRONT_DESK -> return "Front Desk"
            SECURITY -> return "Security"
            else -> return ""
        }
    }
}