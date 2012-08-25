import sbt._
import Keys._

name := "Scala-Tutorials"

libraryDependencies ++= Seq(
  "net.debasishg" %% "sjson" % "0.15",
  "org.specs2" %% "specs2" % "1.8.1",
  "org.jmock" %% "jmock" % "2.4.0"
)
