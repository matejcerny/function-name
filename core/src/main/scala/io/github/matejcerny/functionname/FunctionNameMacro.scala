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

import scala.annotation.tailrec
import scala.quoted.*

object FunctionNameMacro:

  inline def functionName: FunctionName = ${ functionNameImpl }

  private def functionNameImpl(using Quotes): Expr[FunctionName] =
    import quotes.reflect.*

    given ToExpr[FunctionName] with
      def apply(x: FunctionName)(using Quotes): Expr[FunctionName] = '{ FunctionName(${ Expr(x.value) }) }

    @tailrec
    def enclosingMethod(symbol: Symbol): Symbol =
      if symbol.isDefDef then symbol
      else if symbol.isNoSymbol then report.errorAndAbort("Unable to find enclosing method for FunctionName macro.")
      else enclosingMethod(symbol.owner)

    val enclosingMethodSymbol = enclosingMethod(Symbol.spliceOwner)
    val name = enclosingMethodSymbol.name

    Expr(FunctionName(name))
