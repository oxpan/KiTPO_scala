package git.group
package View

import List.TList
import git.group.Builder.{Builder, BuilderInteger, BuilderString}
import git.group.Comaparator.ComparatorInteger
import git.group.Comaparator.Comparator

class ConsolApp {
  var list:TList[Int] = new TList(10)


  def testCode() =
  {
    var builder:Builder = new BuilderInteger()

    var num:Any = builder.createObject()
    var num1:Any = builder.createObject()

    var com:Comparator = builder.getComparator

    println(com.compare(num,num1))

    num = builder.parseObject("139")
    num1 = builder.parseObject("0")

    println(com.compare(num,num1))


    builder = new BuilderString

    num = builder.createObject()
    println(num)
    num1 = builder.createObject()
    println(num1)

    com = builder.getComparator

    println(com.compare(num,num1))

  }

  def testDrive(maxElement:Int) = {
    var list:TList[Int] = new TList(maxElement)
    var n:Int = 0;
    var i:Int = 0;
    while (n < maxElement){
      i = scala.util.Random.nextInt(maxElement).toInt
      list.pushEnd(i)
      n = n + 1
    }
    list.print()
    println()
    println("size: "+list.getSize())


    n = 0
    while (n < maxElement){
      list.delete(0)
      n = n + 1
    }
    println("clear")



  }

  def run() = {
//    testCode()
    testDrive(40)
  }


}
