package fr.esgi.project
package core

import scala.annotation.tailrec
import domain.Input.{Input, InputItem}
import domain.Structure.{Instruction, Orientation}
import domain.State.State
import domain.output.OutputItem


object Exec {
    def exec(input: InputItem): OutputItem = {
        println(s"Position de départ : ${input.currentState}")
        val tempo = run(input.instructions, input.currentState)
        println(s"Position d'arrivée : ${tempo}")
        OutputItem(input.currentState, tempo, input.instructions)
        
    }


    @tailrec
    private def run(instructions: List[Instruction.Instruction], state: State): State = {
        instructions match {
            case Nil => state
            case head :: tail => head match {
                case Instruction.A => 
                    state.orientation match {
                        case Orientation.N => run(tail, state.setPosition((state.position._1, state.position._2 + 1)))
                        case Orientation.E => run(tail, state.setPosition((state.position._1 + 1, state.position._2)))
                        case Orientation.S => run(tail, state.setPosition((state.position._1, state.position._2 - 1)))
                        case Orientation.O => run(tail, state.setPosition((state.position._1 - 1, state.position._2)))
                    }
                case Instruction.D => 
                    state.orientation match {
                        case Orientation.N => run(tail, state.setOrientation(Orientation.E))
                        case Orientation.E => run(tail, state.setOrientation(Orientation.S))
                        case Orientation.S => run(tail, state.setOrientation(Orientation.O))
                        case Orientation.O => run(tail, state.setOrientation(Orientation.N))
                    }
                case Instruction.G => 
                    state.orientation match {
                        case Orientation.N => run(tail, state.setOrientation(Orientation.O))
                        case Orientation.E => run(tail, state.setOrientation(Orientation.N))
                        case Orientation.S => run(tail, state.setOrientation(Orientation.E))
                        case Orientation.O => run(tail, state.setOrientation(Orientation.S))
                    }
            }
        }
    }
}