# FunctionName

[![codecov](https://codecov.io/gh/matejcerny/function-name/graph/badge.svg?token=SF6YT4QRVM)](https://codecov.io/gh/matejcerny/function-name)

Simple Scala 3 macro which generates name of the function.

## Usage

```scala 3
import io.github.matejcerny.functionname.*

def someFunction(): Unit =
  val fnName = functionName
  println(fnName.value) // someFunction
```
