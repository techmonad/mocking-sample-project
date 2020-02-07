name := "mocking-sample-project"

version := "0.1"

scalaVersion := "2.13.1"

libraryDependencies ++=
  Seq(
    "org.json4s" %% "json4s-native" % "3.6.7",
    "org.mockito" %% "mockito-scala" % "1.11.2",
    "org.scalatest" %% "scalatest" % "3.1.0" % Test
  )



