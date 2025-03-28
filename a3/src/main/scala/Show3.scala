package example

import shapeless.::
import shapeless.Generic
import shapeless.HList
import shapeless.HNil

trait Show3[A] {
  def show(a: A): String
}

object Show3 {
  implicit val int: Show3[Int] = _.toString

  implicit val empty: Show3[HNil] =
    _ => ""

  implicit def product[H, T <: HList](implicit
      H: => Show3[H],
      T: => Show3[T]
  ): Show3[H :: T] = { case h :: t =>
    H.show(h) + T.show(t)
  }

  implicit def generic[F, G](implicit
      gen: Generic.Aux[F, G],
      G: => Show3[G]
  ): Show3[F] = { (f: F) =>
    G.show(gen.to(f))
  }
}
