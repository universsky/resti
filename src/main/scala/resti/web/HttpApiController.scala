package resti.web

import java.lang.Long
import javax.validation.Valid

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.access.prepost.PreAuthorize
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.validation.BindingResult
import org.springframework.web.bind.annotation.{PathVariable, RequestMapping, RequestMethod, ResponseBody}
import resti.domain.HttpApi
import resti.service.{HttpApiRepository, TestCaseRepository}

@Controller
@RequestMapping(Array("/httpapi"))
class HttpApiController @Autowired()(private val httpApiRepository: HttpApiRepository,
                                     private val testCaseRepository: TestCaseRepository
                                    ) {

  @RequestMapping(method = Array(RequestMethod.GET))
  def list(model: Model) = {
    val apis = httpApiRepository.findAll()
    model.addAttribute("httpApis", apis)
    "httpapi/list"
  }

  @RequestMapping(value = Array("listJson"), method = Array(RequestMethod.GET))
  @ResponseBody
  def listJson() = {
    httpApiRepository.findAll()
  }

  @RequestMapping(Array("/edit/{id}"))
  def edit(@PathVariable("id") id: Long, model: Model) = {
    model.addAttribute("httpApi", httpApiRepository.findOne(id))
    "httpapi/edit"
  }

  /**
    * list the test cases under this api
    *
    * @param id
    * @param model
    * @return
    */
  @RequestMapping(Array("/testcase/{id}"))
  def listTestCase(@PathVariable("id") id: Long, model: Model) = {
    model.addAttribute("testcases", testCaseRepository.findByHttpApiId(id))
    "httpapi/listTestCase"
  }

  @RequestMapping(method = Array(RequestMethod.GET), params = Array("form"))
  def createForm(model: Model) = {
    model.addAttribute("httpApi", new HttpApi())
    "httpapi/create"
  }

  @RequestMapping(value = Array("/new"), method = Array(RequestMethod.POST))
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_USER')")
  def create(@Valid httpApi: HttpApi, bindingResult: BindingResult) = {
    if (bindingResult.hasErrors()) {
      "httpapi/create"
    } else {
      httpApiRepository.save(httpApi)
      "redirect:/httpapi"
    }
  }

  @RequestMapping(value = Array("/update"), method = Array(RequestMethod.POST))
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  def update(@Valid httpApi: HttpApi, bindingResult: BindingResult) = {
    if (bindingResult.hasErrors()) {
      "httpapi/edit"
    } else {
      println("[httpApi]====" + httpApi.product)
      httpApiRepository.save(httpApi)
      "redirect:/httpapi"
    }
  }

  @RequestMapping(value = Array("/delete/{id}"))
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  def delete(@PathVariable("id") id: Long) = {
    httpApiRepository.delete(id)
    "redirect:/httpapi"
  }

}