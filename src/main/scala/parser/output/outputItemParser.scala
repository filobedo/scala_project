package fr.esgi.project
package parser.output

import Error.BadDataException
import domain.Structure.{Orientation, Instruction, FileType}
import domain.Input.{InputItem}
import domain.output.{OutputItem}

object OutputItemParser {
    def JsonItemOutputParser(data: OutputItem): String = {
        s"""
        {
            "debut": {
                "point": {
                    "x": ${data.startStateState.position._1},
                    "y": ${data.startStateState.position._2}
                },
                "direction": "${data.startStateState.orientation}"
            },
            "instructions": ${data.instructions.mkString("[\"", "\",\"", "\"]")},
            "fin": {
                "point": {
                    "x": ${data.endState.position._1},
                    "y": ${data.endState.position._2}
                },
                "direction": "${data.endState.orientation}"
            }
        }"""
    }

    def CsvOutputParser(data: OutputItem): String = {
        s"${data.startStateState.position._1};${data.startStateState.position._2};${data.startStateState.orientation};${data.endState.position._1};${data.endState.position._2};${data.endState.orientation};${data.instructions.mkString("")}"
    }
}

