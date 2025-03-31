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

@shapeless_annotation.ShapelessGeneric
case class B0(x1: Int, x2: Int)

@shapeless_annotation.ShapelessGeneric
case class B1(x1: B0, x2: B0)

@shapeless_annotation.ShapelessGeneric
case class B2(x1: B1, x2: B1)

@shapeless_annotation.ShapelessGeneric
case class B3(x1: B2, x2: B2)

@shapeless_annotation.ShapelessGeneric
case class B4(x1: B3, x2: B3)

@shapeless_annotation.ShapelessGeneric
case class B5(x1: B4, x2: B4)

@shapeless_annotation.ShapelessGeneric
case class B6(x1: B5, x2: B5)

@shapeless_annotation.ShapelessGeneric
case class B7(x1: B6, x2: B6)

@shapeless_annotation.ShapelessGeneric
case class B8(x1: B7, x2: B7)

@shapeless_annotation.ShapelessGeneric
case class B9(x1: B8, x2: B8)
