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

Currently, the library is only published to GitHub Packages. To use it, you need a personal access token.

### Generating a personal access token

1. Visit your Settings > Developer Settings > Personal access tokens > Tokens (classic)
2. Click on Generate new token
3. Select `read:packages` scopes
4. save it to a file, e.g. `~/.sbt/.github_credentials` or export it as an environment variable, e.g. `GITHUB_TOKEN`

```
realm=GitHub Package Registry
host=maven.pkg.github.com
user=<your-username>
password=<your-personal-access-token>
```

### Adding the library to your project

Add the following to your `build.sbt`:

```scala
val githubCredentials: Credentials = sys.env
  .get("GITHUB_TOKEN")
  .map(Credentials("GitHub Package Registry", "maven.pkg.github.com", "<your-username>", _))
  .getOrElse(Credentials(Path.userHome / ".sbt" / ".github_credentials"))

credentials += githubCredentials
resolvers += "GitHub (FunctionName)" at "https://maven.pkg.github.com/matejcerny/function-name"

libraryDependencies += "io.github.matejcerny" %% "function-name" % "0.1.0"
```
