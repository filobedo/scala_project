package fr.esgi.project
package error

package kernel.error

final case class BadDataException(message: String = "", private val cause: Throwable = None.orNull)
  extends Exception(message, cause)