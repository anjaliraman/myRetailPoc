package com.poc.myRetail

import com.poc.myRetail.dao.MyRetailRepository
import com.poc.myRetail.dto.Price
import com.poc.myRetail.dto.Product
import com.poc.myRetail.model.ProductPriceDao
import com.poc.myRetail.service.MyRetailService
import groovy.json.JsonSlurper
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate
import spock.lang.Specification

class MyRetailServiceSpec extends Specification{
    MyRetailService myRetailService = new MyRetailService()
    MyRetailRepository myRetailRepository = Mock(MyRetailRepository)
    RestTemplate restTemplate = Mock(RestTemplate)
    ResponseEntity responseEntity = Mock(ResponseEntity)

    def setup(){

        myRetailService.myRetailRepository = myRetailRepository
        myRetailService.restTemplate = restTemplate
    }


    def "getProductDetailsById returns value"(){
        given:
        def productObj = new Product(15117729, "The Big Lebowski (Blu-ray)", new Price(17.99, "USD"))
        def prodDao = new ProductPriceDao(15117729,17.99, "USD")
        HttpHeaders headers = new HttpHeaders("Accept":"application/json")
        when: 'product service getProductById is called'
        def response = myRetailService.getProductDetailsById(15117729)


        then: "result returned"
        1 * restTemplate.exchange(_, _, _, _) >> responseEntity
        responseEntity.body >> targetResponse
        1 * myRetailRepository.findOne(15117729) >> prodDao;

        response.name == productObj.name
        response.price.value == productObj.price.value
        response.price.currencyCode == productObj.price.currencyCode

    }



    String targetResponse = """
{
    "product": {
    "deep_red_labels": {
      "total_count": 0,
      "labels": []
    },
    "available_to_promise_network": {
      "product_id": "13860428",
      "id_type": "TCIN",
      "available_to_promise_quantity": 0,
      "street_date": "2011-11-15T06:00:00.000Z",
      "availability": "UNAVAILABLE",
      "online_available_to_promise_quantity": 0,
      "stores_available_to_promise_quantity": 0,
      "availability_status": "OUT_OF_STOCK",
      "multichannel_options": [
        "HOLD"
      ],
      "is_infinite_inventory": false
    },
    "item": {
      "tcin": "13860428",
      "bundle_components": {
        "is_assortment": false,
        "is_kit_master": false,
        "is_standard_item": true,
        "is_component": false
      },
      "dpci": "058-34-0436",
      "upc": "025192110306",
      "product_description": {
        "title": "The Big Lebowski (Blu-ray)",
        "bullet_description": [
          "<B>Movie Genre:</B> Comedy",
          "<B>Software Format:</B> Blu-ray",
          "<B>Movie Studio:</B> Universal Studios"
        ],
        "general_description": "Blu-ray BIG LEBOWSKI, THE Movies"
      },
      "parent_items": "46767107",
      "buy_url": "https://www.target.com/p/the-big-lebowski-blu-ray/-/A-13860428",
      "enrichment": {
        "images": [
          {
            "base_url": "https://target.scene7.com/is/image/Target/",
            "primary": "13860428"
          }
        ],
        "sales_classification_nodes": [
          {
            "node_id": "55ayu",
            "wcs_id": "872533"
          },
          {
            "node_id": "5xswx",
            "wcs_id": "4492"
          },
          {
            "node_id": "5t0ak",
            "wcs_id": "41005"
          }
        ]
      },
      "return_method": "This item can be returned to any Target store or Target.com.",
      "handling": {
        "import_designation_description": "Made in the USA or Imported"
      },
      "recall_compliance": {
        "is_product_recalled": false
      },
      "tax_category": {
        "tax_class": "G",
        "tax_code_id": 99999,
        "tax_code": "99999"
      },
      "display_option": {
        "is_size_chart": false,
        "is_warranty": false
      },
      "fulfillment": {
        "is_po_box_prohibited": true,
        "po_box_prohibited_message": "We regret that this item cannot be shipped to PO Boxes."
      },
      "package_dimensions": {
        "weight": "0.18",
        "weight_unit_of_measure": "POUND",
        "width": "5.33",
        "depth": "6.65",
        "height": "0.46",
        "dimension_unit_of_measure": "INCH"
      },
      "environmental_segmentation": {
        "is_lead_disclosure": false
      },
      "manufacturer": {},
      "product_classification": {
        "product_type": "542",
        "product_type_name": "ELECTRONICS",
        "item_type_name": "Movies",
        "item_type": {
          "category_type": "Item Type: MMBV",
          "type": 300752,
          "name": "Movies"
        }
      },
      "product_brand": {
        "brand": "Universal Home Video"
      },
      "item_state": "READY_FOR_LAUNCH",
      "specifications": [],
      "attributes": {
        "gift_wrapable": "N",
        "has_prop65": "N",
        "is_hazmat": "N",
        "max_order_qty": 10,
        "street_date": "2011-11-15",
        "media_format": "Blu-ray",
        "merch_class": "MOVIES",
        "merch_subclass": 34,
        "return_method": "This item can be returned to any Target store or Target.com."
      },
      "country_of_origin": "US",
      "relationship_type_code": "Title Authority Child",
      "subscription_eligible": false,
      "ribbons": [],
      "tags": [],
      "estore_item_status_code": "A",
      "return_policies": {
        "user": "Regular Guest",
        "policyDays": "30",
        "guestMessage": "This item must be returned within 30 days of the ship date. See return policy for details."
      }
    }
  }
}"""

}
