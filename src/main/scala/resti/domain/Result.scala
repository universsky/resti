package resti.domain

import java.lang.Long
import javax.persistence.{Entity, GeneratedValue, Id}

import scala.beans.BeanProperty

/**
  * Created by jack on 4/1/16.
  */
@Entity
class Result {

  @Id
  @BeanProperty
  @GeneratedValue
  var id: Long = _

  var testCaseId: Long = _

  /**
    * before sql execute result
    */
  var beforeSqlResult : String = _

  /**
    * after sql execute result
    */
  var afterSqlResult : String = _

  /**
    * run the testcase , output
    */
  var output : String = _

}
