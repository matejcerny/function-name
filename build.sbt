// Publishing settings for sbt-ci-release
ThisBuild / homepage := Some(url("https://github.com/matejcerny/sbt-config"))
ThisBuild / licenses := Seq(License.Apache2)
ThisBuild / versionScheme := Some("early-semver")
ThisBuild / developers := List(
  Developer(
    id = "matejcerny",
    name = "Matej Cerny",
    email = "cerny.matej@gmail.com",
    url = url("https://matejcerny.cz/en/")
  )
)
