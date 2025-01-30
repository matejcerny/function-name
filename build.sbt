import Dependencies.*

ThisBuild / tlBaseVersion := "0.1"

ThisBuild / organization := "io.github.matejcerny"
ThisBuild / organizationName := "Matej Cerny"

ThisBuild / startYear := Some(2025)

ThisBuild / scalaVersion := Versions.Scala3
ThisBuild / versionScheme := Some("early-semver")

ThisBuild / homepage := Some(url("https://github.com/matejcerny/function-name"))
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / developers := List(tlGitHubDev("matejcerny", "Matej Cerny"))
ThisBuild / sonatypeCredentialHost := Sonatype.sonatypeCentralHost

lazy val functionName = tlCrossRootProject.aggregate(core)

lazy val core = crossProject(JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("core"))
  .settings(
    name := "function-name",
    libraryDependencies ++= Testing
  )
