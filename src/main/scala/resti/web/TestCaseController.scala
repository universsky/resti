package resti.web

import java.util

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.{PageRequest, Sort}
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation._
import resti.domain.TestCase
import resti.service.TestCaseRepository

/**
  * Created by jack on 4/2/16.
  */
@Controller
@RequestMapping(Array("/testcase"))
class TestCaseController @Autowired()(private val testCaseRepository: TestCaseRepository) {

  @RequestMapping(method = Array(RequestMethod.GET))
  def list(model: Model, @RequestParam(value = "page", defaultValue = "0", required = false) page: Int,
           @RequestParam(value = "count", defaultValue = "20", required = false) count: Int,
           @RequestParam(value = "order", defaultValue = "ASC", required = false) direction: Sort.Direction,
           @RequestParam(value = "sort", defaultValue = "owner", required = false) sortProperty: String) = {
    // val testcases = testCaseRepository.findAll()
    val content = testCaseRepository.findAll(new PageRequest(page, count, new Sort(direction, sortProperty)))
    val iter = content.iterator()

    val testcases = new util.ArrayList[TestCase]()

    while (iter.hasNext) {
      testcases.add(iter.next())
    }

    model.addAttribute("testcases", testcases)
    model.addAttribute("pageIndex", page)
    "testcase/list"
  }

}
