package fr.esgi.project
package domain

package Structure {
  object Orientation extends Enumeration {
    type Orientation = Value
    val N, E, S, O = Value
  }

  object Instruction extends Enumeration {
    type Instruction = Value
    val G, D, A = Value
  }

  object FileType extends Enumeration {
    type FileType = Value
    val CSV, JSON, YAML = Value
  }
}

