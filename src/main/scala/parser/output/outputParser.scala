package fr.esgi.project
package parser.output

import Error.BadDataException
import domain.Structure.{Orientation, Instruction, FileType}
import domain.Input.Input
import domain.output.{OutputData, OutputItem}
import parser.output.OutputItemParser.{JsonItemOutputParser}

object OutputParser {
    def outputJsonParser(data: OutputData): String = {
        s"""
        |{
        |    "Limite": {
        |        "x": ${data.size._1},
        |        "y": ${data.size._2}
        |    },
        |    "tondeuse": [${data.output.map(JsonItemOutputParser).mkString(",\n")}
        |    ]
        |}
        """.stripMargin
    }

    def OutputCsvParser(data: OutputData): String = {
        s"""
        |début_x;début_y;début_direction;fin_x;fin_y;fin_direction;instructions
        |${data.output.map(OutputItemParser.CsvOutputParser).mkString("\n")}
        """.stripMargin
    }
}

