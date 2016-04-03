package resti.web

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.{RequestMapping, RequestMethod}
import resti.service.HttpApiRepository

@Controller
@RequestMapping(Array("/product"))
class ProductController @Autowired()(private val httpApiRepository: HttpApiRepository) {

  @RequestMapping(method = Array(RequestMethod.GET))
  def list(model: Model) = {
    val products = httpApiRepository.findProducts()
    model.addAttribute("products", products)
    "product/list"
  }

}