name := "circe"

version := "0.1"
scalacOptions+="-Ywarn-unused-import"
scalaVersion := "2.11.11"

val circeVersion = "0.8.0"

libraryDependencies ++= Seq(
  "io.circe" %% "circe-core",
  "io.circe" %% "circe-generic",
  "io.circe" %% "circe-parser"
).map(_ % circeVersion)