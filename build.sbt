name := "kafka-scala-consumer"

version := "1.0"

scalaVersion := "2.12.4"


libraryDependencies ++= Seq(
  "ch.qos.logback" % "logback-classic" % "1.2.3",
  "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
//"org.slf4j" % "slf4j-simple" % "1.7.25"
  "org.scalactic" %% "scalactic" % "3.0.4",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test",
   "com.github.pureconfig" %% "pureconfig" % "0.9.0",
//  "com.typesafe.play" %% "play-json" % "2.6.7",
//  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  //  "com.julianpeeters" % "avrohugger-core_2.11" % "0.16.0",
  //  "com.typesafe.akka" %% "akka-stream-kafka" % "0.17",
  //  "io.confluent" % "kafka-connect-avro-converter" % "3.2.1",
  //  "io.confluent" % "kafka-avro-serializer" % "3.2.1",
  //  "co.wrisk.jcredstash" % "jcredstash" % "0.0.4",
  //  "com.typesafe.play" %% "play-ws-standalone-json" % "1.0.1",
  //  "com.typesafe.play" %% "play-ahc-ws-standalone" % "1.0.1",
  "org.apache.kafka" % "kafka-clients" % "1.0.0",
  "com.twitter" %% "finagle-http" % "17.10.0"
)

