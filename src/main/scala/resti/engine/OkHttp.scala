package resti.engine

import java.util.HashMap

object OkHttp {

  def get(url: String, headers: HashMap[String,String], rawJsonStr: String): String = {
    scala.io.Source.fromURL(url).mkString
  }

  def postJson(url: String, headers: HashMap[String,String], rawJsonStr: String): String = {

    ""

  }

  def postForm(url: String, headers: HashMap[String,String], rawJsonStr: String): String = {

    ""

  }


}