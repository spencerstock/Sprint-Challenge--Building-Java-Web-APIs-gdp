package com.example.sprintchallengebuildingjavawebapisgdp.controller



import com.example.sprintchallengebuildingjavawebapisgdp.CheckCountry
import com.example.sprintchallengebuildingjavawebapisgdp.SprintChallengeBuildingJavaWebApisGdpApplication
import com.example.sprintchallengebuildingjavawebapisgdp.exception.ResourceNotFoundException
import com.example.sprintchallengebuildingjavawebapisgdp.models.Country
import com.example.sprintchallengebuildingjavawebapisgdp.models.MessageDetail
import mu.KotlinLogging
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.ModelAndView
import java.text.SimpleDateFormat
import java.util.*

@RestController
@RequestMapping("/countries")
class CountryController {

    companion object{
        private val logger = KotlinLogging.logger{}
    }


    // localhost:8080/countries/names
    val allCountries: ResponseEntity<*>
        @GetMapping(value = ["/names"], produces = ["application/json"])
        get() {
            com.example.sprintchallengebuildingjavawebapisgdp.controller.CountryController.logger.info { "countries/names accessed" +
                    " on ${SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date())}" }
            val message = MessageDetail("/countries/names accessed on" +
                    " ${SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date())}", 7, false)
            return ResponseEntity(com.example.sprintchallengebuildingjavawebapisgdp.SprintChallengeBuildingJavaWebApisGdpApplication.Companion.ourCountryList.countryList.sortedBy { it.name }, HttpStatus.OK)
        }

    // localhost:8080/countries/economy
    val allEconomies: ResponseEntity<*>
        @GetMapping(value = ["/economy"], produces = ["application/json"])
        get() {
            com.example.sprintchallengebuildingjavawebapisgdp.controller.CountryController.logger.info { "countries/economy accessed" +
                    " on ${SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date())}" }
            val message = MessageDetail("/countries/economy accessed on" +
                    " ${SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date())}", 7, false)
            return ResponseEntity(com.example.sprintchallengebuildingjavawebapisgdp.SprintChallengeBuildingJavaWebApisGdpApplication.Companion.ourCountryList.countryList.sortedBy { -it.gdp }, HttpStatus.OK)
        }


    // localhost:8080/countries/country/{id}
    @Throws(ResourceNotFoundException::class)
    @GetMapping(value = ["/country/{id}"], produces = ["application/json"])
    fun getCountryDetail(@PathVariable id: Long): ResponseEntity<*> {
       com.example.sprintchallengebuildingjavawebapisgdp.controller.CountryController.logger.info { "countries/country/$id accessed on ${SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date())}" }
        val message = MessageDetail("/countries/country/$id accessed on" +
                " ${SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date())}", 2, true)

        val rtnCountry = com.example.sprintchallengebuildingjavawebapisgdp.SprintChallengeBuildingJavaWebApisGdpApplication.Companion.ourCountryList.findCountry(CheckCountry.invoke
        { c: Country -> c.id == id }) ?: throw ResourceNotFoundException("Country with id $id not found")

        return ResponseEntity(rtnCountry, HttpStatus.OK)
    }



    @GetMapping(value = ["/economy/table"], produces = ["application/json"])
    fun displayCountryTable(): ModelAndView {
        logger.info { "economy/table accessed on " +
                " ${SimpleDateFormat("dd MMM yyyy HH:mm:ss:SSS Z").format(Date())}" }
        val mav = ModelAndView()
        mav.viewName = "countries"
        mav.addObject("countryList", SprintChallengeBuildingJavaWebApisGdpApplication.ourCountryList.countryList.sortedBy { -it.gdp })

        return mav
    }

}