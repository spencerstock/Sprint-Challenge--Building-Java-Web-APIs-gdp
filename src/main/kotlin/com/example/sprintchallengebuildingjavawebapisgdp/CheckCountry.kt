package com.example.sprintchallengebuildingjavawebapisgdp

import com.example.sprintchallengebuildingjavawebapisgdp.models.Country


interface CheckCountry {
    fun test(c: Country): Boolean

    companion object {
        operator fun invoke(function: (c: Country) -> Boolean) =
                object  : CheckCountry {
                    override fun test(c: Country): Boolean = function(c)
                }
    }
}
