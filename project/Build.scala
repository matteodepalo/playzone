import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {
  val appName         = "playzone"
  val appVersion      = "1.0-SNAPSHOT"

  val appDependencies = Seq(
    "postgresql" % "postgresql" % "9.1-901.jdbc4"
  )

  def customLessEntryPoints(base: File): PathFinder = (
    (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
    (base / "app" / "assets" / "stylesheets" / "bootstrap" * "responsive.less") +++
    (base / "app" / "assets" / "stylesheets" * "*.less")
  )

  val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(
    lessEntryPoints <<= baseDirectory(customLessEntryPoints)
  )
}
