package com.example.sprintchallengebuildingjavawebapisgdp.models

import java.io.Serializable

data class MessageDetail(val text: String? =null ,
                         val priority: Int? = null,
                         val secret: Boolean? = null): Serializable {
    override fun toString(): String {
        return "MessageDetail(text=$text, priority=$priority, secret=$secret)"
    }
}