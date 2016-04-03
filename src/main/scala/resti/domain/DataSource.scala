package resti.domain

import java.lang.Long
import javax.persistence.{Entity, GeneratedValue, Id}

import org.hibernate.validator.constraints.NotEmpty

import scala.beans.BeanProperty

/**
  * Created by jack on 4/1/16.
  */
@Entity
class DataSource {

  @Id
  @GeneratedValue
  @BeanProperty
  var id: Long = _
  @BeanProperty
  @NotEmpty
  var url: String = _
  @BeanProperty
  @NotEmpty
  var username: String = _
  @BeanProperty
  @NotEmpty
  var password: String = _
  @BeanProperty
  @NotEmpty
  var dirverClass: String = _

}
