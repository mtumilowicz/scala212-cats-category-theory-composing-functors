import cats.Functor
import org.scalatest.{FunSuite, Matchers}
import cats.instances.list._
import cats.instances.option._

/**
  * Created by mtumilowicz on 2019-01-02.
  */
class FunctorCompositionTest extends FunSuite with Matchers {
  
  test("Cats: Composing functors is all about composing appropriate map functions") {
    def square(i: Int) = i * i
    val optionList = Option(List(1, 2, 3))
    
    Functor[Option].compose[List].map(optionList)(square) should be (Some(List(1, 4, 9)))
  }

  test("Pure Scala: Composing functors is all about composing appropriate map functions") {
    def square(i: Int) = i * i
    val optionList = Option(List(1, 2, 3))

    optionList.map(_ . map(square)) should be (Some(List(1, 4, 9)))
  }
  
}
