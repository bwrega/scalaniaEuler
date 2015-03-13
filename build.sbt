name := "euler"

organization in Global := "pl.scalania"

version in Global := "0.1"

scalaVersion in Global := "2.11.5"

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature","-Yrangepos")

scalacOptions in Global ++= Seq("-deprecation", "-unchecked", "-feature","-Yrangepos")
scalacOptions in Global ++= Seq("-unchecked", "-deprecation", "-encoding", "utf8")

val scalaLogging = "com.typesafe.scala-logging" %% "scala-logging" % "3.1.0"

val scalacheck = "org.scalacheck" %% "scalacheck" % "1.12.1"

libraryDependencies in Global ++= Seq(
  scalaLogging,
  scalacheck % "test",
  "org.scalatest" %% "scalatest" % "2.2.3" % "test",
  "ch.qos.logback" % "logback-classic" % "1.1.2"
)

libraryDependencies in Global ++= {
  val akkaV = "2.3.6"
  val sprayV = "1.3.2"
  Seq(
    "io.spray"            %%  "spray-can"     % sprayV,
    "io.spray"            %%  "spray-routing" % sprayV,
    "io.spray"            %%  "spray-testkit" % sprayV  % "test",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV   % "test",
    "org.specs2"          %%  "specs2-core"   % "2.3.11" % "test"
  )
}

libraryDependencies in Global += "io.spray" %%  "spray-json" % "1.3.1"

Seq(jrebelSettings: _*)


