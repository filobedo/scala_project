package fr.esgi.project
package domain

import Structure.{Orientation, Instruction, FileType}

object Input {
    case class Input(size: (Int, Int), input: List[InputItem])
    
    case class InputItem(startPosition: StartPosition, instructions: List[Instruction.Instruction])

    case class StartPosition(x: Int, y: Int, orientation: Orientation.Orientation)
}