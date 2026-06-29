lazy val root = projectMatrix
  .in(file("."))
  .jvmPlatform(Seq("3.3.7"))
  .jsPlatform(Seq("3.3.7"))
  .nativePlatform(Seq("3.3.7"))
