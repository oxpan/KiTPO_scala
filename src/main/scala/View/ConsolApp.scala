package git.group
package View

import List.{DoIt, TList}

class ConsolApp {
  var list:TList[Int] = new TList(10)


  def testCode() = {
    println("code:")


    println(list.getSize())

    list.pushFront(12)
    list.pushFront(11)
    list.pushEnd(30)
    list.add(40,2)
    list.add(1,1)
    println(list.getSize())
    println(list.getSizeLimit)
    println("list: ")

//    list.print()
    println()
    println("delete list: ")
    list.delete(2)
//    list.print()
//    println()
//    println("find list: ")
//    println("[2] "+list.find(2))
//    println("[int 30] "+list.finds(30))

      def show = new DoIt[Int]
      {
        def doIt(o: Int):Unit = println(o)
      }

      list.forEach(show)

      list.sort()

      list.forEach(show)

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
    //list.print()
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
    testCode()
    //testDrive(40)
  }


}
