[![Build Status](https://travis-ci.com/mtumilowicz/scala212-cats-category-theory-composing-functors.svg?branch=master)](https://travis-ci.com/mtumilowicz/scala212-cats-category-theory-composing-functors)

# scala212-cats-category-theory-composing-functors
_Reference_: https://bartoszmilewski.com/2015/01/20/functors/  
_Reference_: https://typelevel.org/cats/typeclasses/functor.html

# preface
Basic info about functors:
* https://github.com/mtumilowicz/java11-category-theory-optional-is-not-functor
* https://github.com/mtumilowicz/java11-category-theory-reader-functor

# project description
We have `optionList:Option[List[Int]] = Option(List(1, 2, 3))` 
and we want to square the elements.
* pure Scala
    ```
    def square(i: Int) = i * i
    val optionList = Option(List(1, 2, 3))

    optionList.map(_ . map(square)) should be (Some(List(1, 4, 9)))
    ```
* Scala + Cats
    * Option is a functor
    * List is a functor
    * **Composition of two functors, when acting on objects, is just the composition 
      of their respective object mappings.**
    ```
    def square(i: Int) = i * i
    val optionList = Option(List(1, 2, 3))
    
    Functor[Option].compose[List].map(optionList)(square) should be (Some(List(1, 4, 9)))
    ```