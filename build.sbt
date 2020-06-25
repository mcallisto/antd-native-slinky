/* ScalablyTyped configuration */
enablePlugins(ScalablyTypedConverterGenSourcePlugin)

scalaVersion := "2.13.2"
name := "antd-native-slinky"
version := "0.1.0"

/* javascript / typescript deps */
Compile / npmDependencies ++= Seq(
  "@types/react" -> "16.9.34",
  "@types/react-native" -> "^0.60.25",
  "@ant-design/icons-react-native" -> "1.0.2",
  "@ant-design/react-native" -> "3.1.10"
)

/* disabled because it somehow triggers many warnings */
scalaJSLinkerConfig ~= (_.withSourceMap(false))

// because npm is slow
useYarn := true

stExperimentalEnableImplicitOps := true

// say we want custom code for slinky
stFlavour := Flavour.SlinkyNative

// focus only on these libraries
stMinimize := Selection.AllExcept("@ant-design/react-native")

// shade into another package
stOutputPackage := "vision.id.antdrn.facade"

publishMavenStyle := true
homepage := Some(new URL("https://github.com/mcallisto/antd-native-slinky"))
startYear := Some(2020)
pomExtra := (
  <scm>
    <connection>scm:git:github.com:/mcallisto/antd-native-slinky</connection>
    <developerConnection>scm:git:git@github.com:mcallisto/antd-native-slinky.git</developerConnection>
    <url>github.com:mcallisto/antd-native-slinky.git</url>
  </scm>
    <developers>
      <developer>
        <id>mcallisto</id>
        <name>Mario Càllisto</name>
      </developer>
    </developers>
  )
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))
bintrayRepository := "libs"
