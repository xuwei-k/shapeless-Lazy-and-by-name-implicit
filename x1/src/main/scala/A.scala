package example

case class A0(x1: Int, x2: Int)

case class A1(x1: A0, x2: A0)

case class A2(x1: A1, x2: A1)

case class A3(x1: A2, x2: A2)

case class A4(x1: A3, x2: A3)

case class A5(x1: A4, x2: A4)

case class A6(x1: A5, x2: A5)

case class A7(x1: A6, x2: A6)

case class A8(x1: A7, x2: A7)

case class A9(x1: A8, x2: A8)
