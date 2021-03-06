import sbt._
import Keys._
import play.Project._

object ApplicationBuild extends Build {
  val appName         = "playzone"
  val appVersion      = "1.0"

  val appDependencies = Seq(
    "postgresql" % "postgresql" % "9.1-901.jdbc4",
    jdbc,
    anorm
  )

  def customLessEntryPoints(base: File): PathFinder = (
    (base / "app" / "assets" / "stylesheets" / "bootstrap" * "bootstrap.less") +++
    (base / "app" / "assets" / "stylesheets" / "bootstrap" * "responsive.less") +++
    (base / "app" / "assets" / "stylesheets" * "*.less")
  )

  val main = play.Project(appName, appVersion, appDependencies).settings(
    lessEntryPoints <<= baseDirectory(customLessEntryPoints)
  )
}
