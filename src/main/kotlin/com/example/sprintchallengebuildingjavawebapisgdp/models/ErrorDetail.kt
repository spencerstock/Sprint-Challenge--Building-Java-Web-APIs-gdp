package com.example.sprintchallengebuildingjavawebapisgdp.models

import com.example.sprintchallengebuildingjavawebapisgdp.exception.ValidationError
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.HashMap

data class ErrorDetail(var title: String? = null, var status: Int? = null, var detail: String? = null,
                       var developerMessage: String? = null,
                       var errors: HashMap<String, List<ValidationError>> = HashMap()) {
    var timestamp: String? = null


    fun setTimestamp(value: Long) {
        timestamp = SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date(value))
    }
}