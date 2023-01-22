package fr.esgi.project
package domain

import Structure.{Orientation, Instruction, FileType}

object Input {
    case class Input(size: (Int, Int), input: List[InputItem])
    
    case class InputItem(currentState: State, instructions: List[Instruction.Instruction])

    case class State(position: (Int, Int), orientation: Orientation.Orientation) {
        def setPosition(position: (Int, Int)): State = {
            this.copy(position = position)
        }

        def setOrientation(orientation: Orientation.Orientation): State = {
            this.copy(orientation = orientation)
        }
    }
}