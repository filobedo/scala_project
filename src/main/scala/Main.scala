package fr.esgi.project

import scala.io.StdIn
import com.typesafe.config.{Config, ConfigFactory}

import io.{Read, Write}

object Main extends Greeting with App {

  val conf: Config = ConfigFactory.load()
  var res = Read.readFile(conf.getString("application.input-file"))
  Write.writeFile(conf.getString("application.output-file"), res)
  println(res)
}

trait Greeting {
  lazy val greeting: String = "hello"

  case class MyException(msg: String) extends Exception

  @SuppressWarnings(Array("org.wartremover.warts.Throw"))
  def dangerous(): Unit = {
    throw new MyException("boooom")
  }
}
