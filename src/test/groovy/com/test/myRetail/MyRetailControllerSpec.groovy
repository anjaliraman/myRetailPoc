package com.test.myRetail

import com.poc.myRetail.controller.MyRetailController
import com.poc.myRetail.dto.Price
import com.poc.myRetail.dto.Product
import com.poc.myRetail.service.MyRetailService
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.setup.MockMvcBuilders
import spock.lang.Ignore
import spock.lang.Specification
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get

class MyRetailControllerSpec extends Specification{

    def myRetailController = new MyRetailController()
    def myRetailService = Mock(MyRetailService)
    def MockMvc mockMvc
    def setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(myRetailController).build()
        myRetailController.myRetailService = myRetailService
    }


    def 'get product by id'() {
        given:
        def productObj = new Product(15117729, "The Big Lebowski (Blu-ray)", new Price(17.99, "USD"))
        def productJson = '{"id":15117729,"name":"The Big Lebowski (Blu-ray)","current_price":{"value":17.99,"currency_code":"USD"}}'
        when: 'products url si hit'
        def response = mockMvc.perform(get("/products/15117729")).andReturn().response

        then: "result returned"
        //response.status == OK.value()
        response.contentType.contains('application/json')
        response.contentType == 'application/json;charset=UTF-8'

        response.contentAsString == productJson

        1 * myRetailService.getProductDetailsById(15117729) >> productObj

    }


}
