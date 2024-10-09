name := """client-demo"""
organization := "com.client.demo"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.10"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "4.0.3" % Test
libraryDependencies += ws
libraryDependencies += "com.github.tototoshi" %% "scala-csv" % "2.0.0"
// https://mvnrepository.com/artifact/org.apache.pekko/pekko-stream
//libraryDependencies += "org.apache.pekko" %% "pekko-stream" % "1.1.1"
//// https://mvnrepository.com/artifact/org.apache.pekko/pekko-actor
////libraryDependencies += "org.apache.pekko" %% "pekko-actor" % "1.1.1"
//// https://mvnrepository.com/artifact/org.apache.pekko/pekko-actor-typed
//libraryDependencies += "org.apache.pekko" %% "pekko-actor-typed" % "1.1.1"


// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.client.demo.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.client.demo.binders._"
