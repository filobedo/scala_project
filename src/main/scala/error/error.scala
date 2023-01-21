package fr.esgi.project
package Error

final case class BadDataException(message: String = "", private val cause: Throwable = None.orNull)
  extends Exception(message, cause)