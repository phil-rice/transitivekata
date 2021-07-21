name := "transitiveDependancies"

version := "0.1"
lazy val versions = new {
  val scala = "2.12.10"
  val scalatest = "3.2.2"
  val mockito = "1.10.19"
}

scalaVersion :=versions.scala

libraryDependencies += "org.scalatest" %% "scalatest" % versions.scalatest % "test"