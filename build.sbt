import Dependencies.*

ThisBuild / organization := "io.github.matejcerny"

ThisBuild / scalaVersion := Versions.Scala3
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / version := sys.env.get("TAG_NAME").map(_.drop(1)).getOrElse("0.1.0-SNAPSHOT")

ThisBuild / licenses := Seq(License.Apache2)

ThisBuild / credentials ++= Registry.credentials
ThisBuild / publishTo := Registry.publishToGithub

lazy val functionName = (project in file("."))
  .settings(
    publish / skip := true,
    publishLocal / skip := true,
    Compile / coverageEnabled := false,
    crossScalaVersions := Nil
  )
  .aggregate(core)

lazy val core = project
  .in(file("core"))
  .settings(
    name := "function-name",
    libraryDependencies ++= Testing
  )
