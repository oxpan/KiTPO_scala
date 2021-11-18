package git.group
package View

import List.TList
import git.group.Comaparator.ComparatorInteger

class ConsolApp {
  var list:TList[Int] = new TList(10)


  def testCode() =
  {
    val num = 5.asInstanceOf[Any]
    val num1 = 3.asInstanceOf[Any]
    val com = new ComparatorInteger()
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
