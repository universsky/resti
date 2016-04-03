package resti.domain

import javax.persistence.{Entity, GeneratedValue, Id}

import scala.beans.BeanProperty

/**
  * Created by jack on 4/1/16.
  */
@Entity
class Assertion {

  @Id
  @BeanProperty
  @GeneratedValue
  var id: Long = _
  @BeanProperty
  var testCaseId: Long = _
  @BeanProperty
  var key: String = _

  /**
    * =,!=, contains, !contains, >, < , >=, <=
    */
  @BeanProperty
  var operator: String = _
  @BeanProperty
  var expectValue: String = _
  @BeanProperty
  var assertResult : Boolean = _

}
