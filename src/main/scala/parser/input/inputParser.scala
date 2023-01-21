package fr.esgi.project
package parser.input

import Error.BadDataException
import domain.Structure.{Orientation, Instruction, FileType}
import domain.Input.Input
import InputItemParser.parseItem


object InputParser {
    def parser(rawData: List[String]): Either[BadDataException, Input] = {

        if (!isValidMapSize(rawData.head)) {
            return Left(BadDataException("Bad map size value"))
        } else {
            val size = parseSize(rawData(0))
            val inputItem = rawData.tail.grouped(2).toList

            val inputItemParsed = inputItem.map(parseItem)

            inputItemParsed.find(_.isLeft) match {
                case Some(s) => Left(s.left.get)
                case None => Right(Input(size, inputItemParsed.map(_.right.get)))
            }
        }

    }

    private def isValidMapSize(mapSize: String): Boolean = {
      val values = mapSize.split(" ")
      values.length == 2 && values.forall(_.forall(_.isDigit))
    }

    private def parseSize(size: String): (Int, Int) = {
        val sizeList = size.split(" ")
        (sizeList(0).toInt, sizeList(1).toInt)
    }

}