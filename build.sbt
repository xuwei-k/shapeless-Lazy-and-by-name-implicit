val common = Def.settings(
  scalaVersion := "2.13.16",
  libraryDependencies += "com.github.xuwei-k" %% "shapeless-annotation" % "0.1.1",
  scalacOptions ++= {
    scalaBinaryVersion.value match {
      case "2.13" =>
        Seq("-Ymacro-annotations")
      case _ =>
        Nil
    }
  },
  libraryDependencies += "com.chuusai" %% "shapeless" % "2.3.13"
)

val x1 = project.settings(common)

def gen(className: String) = {
  Compile / sourceGenerators += task {
    val dir = (Compile / sourceManaged).value
    (1 to 20).map { n =>
      val src =
        s"""|package example
            |
            |class Y${n} {
            |  def f = implicitly[${className}]
            |}
            |""".stripMargin
      val f = dir / s"Y${n}.scala"
      IO.write(f, src)
      f
    }
  }
}

val a1 = project
  .settings(
    common,
    gen("Show1[A9]")
  )
  .dependsOn(x1)

val a2 = project
  .settings(
    common,
    gen("Show1[B9]")
  )
  .dependsOn(x1)
