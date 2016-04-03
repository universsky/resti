package resti.domain

import java.lang.Long
import javax.persistence.{Entity,Id,GeneratedValue}

import org.hibernate.validator.constraints.NotEmpty

import scala.beans.BeanProperty


/**
  * Created by jack on 4/1/16.
  */
@Entity
class LoginSession {

  @Id
  @GeneratedValue
  @BeanProperty
  var id: Long = _

  /**
    * login url
    */
  @BeanProperty
  @NotEmpty
  var loginUrl: String = _

  /**
    * paramsType: form,json,header
    */
  @BeanProperty
  @NotEmpty
  var paramsType: String = _

  /**
    * login params content , eg: {"username":"guangjian","password":"111111"}
    */
  @BeanProperty
  @NotEmpty
  var paramsContent: String = _

  /**
    * login response
    */
  @BeanProperty
  var loginResponse: String = _

}
