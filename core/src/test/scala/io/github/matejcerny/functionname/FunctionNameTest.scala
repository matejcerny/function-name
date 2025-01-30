package io.github.matejcerny.functionname

import org.specs2.mutable.SpecLike

class FunctionNameTest extends SpecLike:

  private def myOuterFunction: (String, String) =
    def myInnerFunction: String = functionName.value
    (myInnerFunction, functionName.value)

  "return name of the inner and outer function" >> {
    myOuterFunction must beEqualTo("myInnerFunction", "myOuterFunction")
  }
