/*
 * Copyright 2025 Matej Cerny
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.github.matejcerny.functionname

import org.specs2.mutable.SpecLike

class FunctionNameTest extends SpecLike:

  private def myOuterFunction: (String, String) =
    def myInnerFunction: String = functionName.value
    (myInnerFunction, functionName.value)

  "return name of the inner and outer function" >> {
    myOuterFunction must beEqualTo("myInnerFunction", "myOuterFunction")
  }
