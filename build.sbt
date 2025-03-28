val common = Def.settings(
  scalaVersion := "2.13.16",
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
            |class X${n} {
            |  def f = implicitly[${className}[A9]]
            |}
            |""".stripMargin
      val f = dir / s"X${n}.scala"
      IO.write(f, src)
      f
    }
  }
}

val a1 = project
  .settings(
    common,
    gen("Show1")
  )
  .dependsOn(x1)

val a2 = project
  .settings(
    common,
    gen("Show2")
  )
  .dependsOn(x1)

val a3 = project
  .settings(
    common,
    gen("Show3")
  )
  .dependsOn(x1)
