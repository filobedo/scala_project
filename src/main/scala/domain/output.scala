package fr.esgi.project
package domain

import Structure.{Orientation, Instruction, FileType}
import domain.State.State

object output {
    case class OutputData(size: (Int, Int), output: List[OutputItem])
    case class OutputItem(startStateState: State, endState: State, instructions: List[Instruction.Instruction])
}