package example

import shapeless.::
import shapeless.Generic
import shapeless.HList
import shapeless.HNil

trait Show1[A] {
  def show(a: A): String
}

object Show1 {
  implicit val int: Show1[Int] = _.toString

  implicit val empty: Show1[HNil] =
    _ => ""

  implicit def product[H, T <: HList](implicit
      H: Show1[H],
      T: Show1[T]
  ): Show1[H :: T] = { case h :: t =>
    H.show(h) + T.show(t)
  }

  implicit def generic[F, G](implicit
      gen: Generic.Aux[F, G],
      G: Show1[G]
  ): Show1[F] = { (f: F) =>
    G.show(gen.to(f))
  }
}
