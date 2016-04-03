package resti.domain

import java.lang.Long
import javax.persistence.{Entity, GeneratedValue, Id}

import org.hibernate.validator.constraints.NotEmpty

import scala.beans.BeanProperty

/**
  * Created by jack on 4/1/16.
  */
@Entity
class TestCase {

  @Id
  @GeneratedValue
  @NotEmpty
  @BeanProperty
  var id: Long = _

  @BeanProperty
  var name: String = _

  /**
    * the api login session, ref LoginSession
    */
  @BeanProperty
  var loginSessionId: Long = _

  @BeanProperty
  var httpApiId: Long = _

  /**
    * { tedh033221ef,120084,2012839 } mapping the api paramsKeys order
    */
  @BeanProperty
  var paramsValues: String = _

  /**
    * when execute the before/after sql, choose the datasource
    */
  @BeanProperty
  var dataSourceId: Long = _

  /**
    * before method, the sql transaction
    */
  @BeanProperty
  var beforeSql: String = _

  /**
    * after method, the sql transaction
    */
  @BeanProperty
  var afterSql: String = _

  @BeanProperty
  var owner: String = _

}
