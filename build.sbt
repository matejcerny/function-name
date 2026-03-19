lazy val root = crossProject(JVMPlatform, JSPlatform, NativePlatform)
  .crossType(CrossType.Full)
  .in(file("."))
  .settings(
    sbtConfigFile := (ThisBuild / baseDirectory).value / "build.conf"
  )
