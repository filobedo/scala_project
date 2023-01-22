package fr.esgi.project
package domain

import Structure.{Orientation, Instruction, FileType}
import domain.State.State

object Input {
    case class Input(size: (Int, Int), input: List[InputItem])
    case class InputItem(currentState: State, instructions: List[Instruction.Instruction])
        
}