package fr.esgi.project

import scala.io.StdIn
import com.typesafe.config.{Config, ConfigFactory}
import Error.BadDataException
import io.{Read, Write}
import domain.Input.Input
import domain.output.{OutputData, OutputItem}
import parser.input.InputParser.{inputParser}
import parser.output.OutputParser.{outputJsonParser, OutputCsvParser}
import core.Exec.exec

object Main extends Greeting with App {

  val conf: Config = ConfigFactory.load()
  var rawData = Read.readFile(conf.getString("application.input-file"))

  val res: Either[BadDataException, Input] = inputParser(rawData)

  res match {
      case Left(s) => println(s)
      case Right(s) => {
        println(res.right.get)
        val resultat = res.right.get.input.map(exec)
        println(resultat)
        
        Write.writeFile(conf.getString("application.output-file"), outputJsonParser(OutputData(res.right.get.size, resultat)))
        Write.writeFile("output.csv", OutputCsvParser(OutputData(res.right.get.size, resultat)))
      }
  }
  
}

trait Greeting {
  lazy val greeting: String = "hello"

  case class MyException(msg: String) extends Exception

  @SuppressWarnings(Array("org.wartremover.warts.Throw"))
  def dangerous(): Unit = {
    throw new MyException("boooom")
  }
}
