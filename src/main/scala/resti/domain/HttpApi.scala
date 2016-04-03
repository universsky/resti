package resti.domain

import java.lang.Long
import javax.persistence.{Entity, GeneratedValue, Id}

import org.hibernate.validator.constraints.NotEmpty

import scala.beans.BeanProperty

@Entity
class HttpApi {

  @Id
  @GeneratedValue
  @BeanProperty
  var id: Long = _

  @BeanProperty
  @NotEmpty
  var name: String = _

  @BeanProperty
  @NotEmpty
  var product: String = _

  @BeanProperty
  @NotEmpty
  var module: String = _

  @BeanProperty
  @NotEmpty
  var uri: String = _

  @BeanProperty
  @NotEmpty
  var host: String = _

  @BeanProperty
  @NotEmpty
  var paramsType: String = _ // 'json'  'header'  'form'

  @BeanProperty
  var paramsKeys: String = _ // , separate : deviceId,accessToken, platform

  /**
    * get,post
    */
  @BeanProperty
  var requestMethod: String = _

  @BeanProperty
  var owner: String = _


}