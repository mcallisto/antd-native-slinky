/* ScalablyTyped configuration */
enablePlugins(ScalablyTypedConverterGenSourcePlugin)

scalaVersion := "2.13.3"
name := "antd-native-slinky"
version := "0.1.7"

/* javascript / typescript deps */
Compile / npmDependencies ++= Seq(
  "@ant-design/icons-react-native" -> "2.2.1",
  "@ant-design/react-native" -> "4.0.7",
  "@react-native-community/cameraroll" -> "4.0.0",
  "@react-native-community/picker" -> "1.6.6",
  "@react-native-community/segmented-control" -> "2.2.1",
  "@react-native-community/slider" -> "3.0.3",
  "@react-native-community/viewpager" -> "4.2.0",
  "@types/react" -> "~16.9.35",
  "@types/react-native" -> "~0.63.2",
  "moment" -> "2.29.1"
)

/* disabled because it somehow triggers many warnings */
scalaJSLinkerConfig ~= (_.withSourceMap(false))

// because npm is slow
useYarn := true

// say we want custom code for slinky
stFlavour := Flavour.SlinkyNative

// focus only on these libraries
stMinimize := Selection.AllExcept("@ant-design/react-native", "@ant-design/icons-react-native", "moment")

// shade into another package
stOutputPackage := "vision.id.antdrn.facade"

ThisBuild / organization := "vision.id"
ThisBuild / organizationName := "vision.id"
ThisBuild / organizationHomepage := Some(url("http://id.vision/"))

ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/mcallisto/antd-native-slinky"),
    "scm:git@github.com:mcallisto/antd-native-slinky.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id    = "mcallisto",
    name  = "Mario Càllisto",
    email = "mario.callisto@gmail.com",
    url   = url("https://github.com/mcallisto")
  )
)

ThisBuild / description := "Antd-native bindings for slinky (powered by ScalablyTyped)."
ThisBuild / licenses := List("Apache 2" -> new URL("http://www.apache.org/licenses/LICENSE-2.0.txt"))
ThisBuild / homepage := Some(url("https://github.com/mcallisto/antd-native-slinky"))

// Remove all additional repository other than Maven Central from POM
ThisBuild / pomIncludeRepository := { _ => false }
ThisBuild / publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value) Some("snapshots" at nexus + "content/repositories/snapshots")
  else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}
ThisBuild / publishMavenStyle := true
