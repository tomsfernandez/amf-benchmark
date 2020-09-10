name := "amf-benchmark"

version := "0.1"

scalaVersion := "2.12.10"

enablePlugins(JmhPlugin)

resolvers ++= List(Common.releases, Common.snapshots, Resolver.mavenLocal)

libraryDependencies += "com.github.amlorg" % "amf-client_2.12" % "4.4.0-SNAPSHOT"