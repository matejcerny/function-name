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
