package fr.esgi.project
package parser.input

import Error.BadDataException
import domain.Structure.{Orientation, Instruction, FileType}
import domain.Input.{Input, InputItem, State}

object InputItemParser {

    def parseItem(input: List[String]): Either[BadDataException, InputItem] = {
        if (isValidPosition(input.head)) {
            Right(InputItem(parsePosition(input.head), parseInstructions(input(1))));
        } else {
            Left(BadDataException("Bad instructions value"))
        }
        

    }

    private def isValidPosition(position: String): Boolean = {
        val values = position.split(" ")
        values.length == 3 && values(0).forall(_.isDigit) && values(1).forall(_.isDigit) && values(2).forall(_.isLetter)
    }

    private def parsePosition(position: String): State = {
        val positionList = position.split(" ")
        State((positionList(0).toInt, positionList(1).toInt), Orientation.withName(positionList(2)))
    }
    

    private def parseInstructions(instruction: String): List[Instruction.Instruction] = {
        instruction.split("").map(Instruction.withName).toList
    }
}