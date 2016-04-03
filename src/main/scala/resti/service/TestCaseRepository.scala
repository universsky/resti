package resti.service

import java.lang.Long

import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.PagingAndSortingRepository
import resti.domain.TestCase

/**
  * Created by jack on 4/1/16.
  */
trait TestCaseRepository extends PagingAndSortingRepository[TestCase, Long] {

  @Query(value = "select * from test_case where http_api_id = ?1", nativeQuery = true)
  def findByHttpApiId(httpApiId: Long): java.util.List[TestCase]

  def findAll(pageable: Pageable): Page[TestCase]

}
