package io.github.matejcerny.functionname

opaque type FunctionName = String

object FunctionName:
  def apply(functionName: String): FunctionName = functionName
  extension (functionName: FunctionName) def value: String = functionName