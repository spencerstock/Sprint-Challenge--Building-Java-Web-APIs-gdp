package com.example.sprintchallengebuildingjavawebapisgdp

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.web.servlet.DispatcherServlet
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@EnableWebMvc
@SpringBootApplication
class SprintChallengeBuildingJavaWebApisGdpApplication {


    companion object {
        lateinit var ourCountryList: CountryList


        @JvmStatic
        fun main(args: Array<String>) {
            ourCountryList = CountryList()
            val ctx = SpringApplication.run(SprintChallengeBuildingJavaWebApisGdpApplication::class.java, *args)

            val dispatcherServlet: DispatcherServlet = ctx.getBean("dispatcherServlet") as DispatcherServlet
            dispatcherServlet.setThrowExceptionIfNoHandlerFound(true)
        }
    }
}