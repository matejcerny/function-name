# function-name

![](https://img.shields.io/badge/Scala%203-%23de3423.svg?logo=scala&logoColor=white)
[![Latest version](https://maven-badges.sml.io/sonatype-central/io.github.matejcerny/function-name_3/badge.svg)](https://repo1.maven.org/maven2/io/github/matejcerny/function-name_3)
[![Build Status](https://github.com/matejcerny/function-name/actions/workflows/ci.yml/badge.svg)](https://github.com/matejcerny/function-name/actions/workflows/ci.yml)
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
libraryDependencies += "io.github.matejcerny" %% "function-name" % "0.2.2"
```
