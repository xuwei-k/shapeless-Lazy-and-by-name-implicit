package example

import shapeless.::
import shapeless.Generic
import shapeless.HList
import shapeless.HNil
import shapeless.Lazy

trait Show2[A] {
  def show(a: A): String
}

object Show2 {
  implicit val int: Show2[Int] = _.toString

  implicit val empty: Show2[HNil] =
    _ => ""

  implicit def product[H, T <: HList](implicit
      H: Lazy[Show2[H]],
      T: Lazy[Show2[T]]
  ): Show2[H :: T] = { case h :: t =>
    H.value.show(h) + T.value.show(t)
  }

  implicit def generic[F, G](implicit
      gen: Generic.Aux[F, G],
      G: Lazy[Show2[G]]
  ): Show2[F] = { (f: F) =>
    G.value.show(gen.to(f))
  }
}
