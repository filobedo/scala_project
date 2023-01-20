package fr.esgi.project
package io

import scala.io.Source

object Read {
  def readFile(path: String): String = {
    val rawData = scala.io.Source.fromFile(path)
    val data = rawData.mkString
    rawData.close()
    data
  }
}