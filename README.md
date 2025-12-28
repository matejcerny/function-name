# FunctionName

[![codecov](https://codecov.io/gh/matejcerny/function-name/graph/badge.svg?token=SF6YT4QRVM)](https://codecov.io/gh/matejcerny/function-name)

Simple Scala 3 macro which generates name of the function as an opaque type.

## Usage

```scala 3
import io.github.matejcerny.functionname.*

def someFunction(): Unit =
  val fnName = functionName
  println(fnName.value) // someFunction
```

One use case could be logging:

```scala 3
def log(message: String)(using fnName: FunctionName): Unit =
  println(s"${fnName.value}: $message")

def someFunction(): Unit =
  log("Hello!")(using functionName)
```

## Installation

Add the library as a dependency:

```scala
libraryDependencies += "io.github.matejcerny" %% "function-name" % "0.1.0"
```