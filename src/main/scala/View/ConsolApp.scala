package git.group
package View

import List.TList

class ConsolApp {
  var list:TList[Int] = new TList()


  def testCode() = {
    println("code:")
    println(list.getSize())

    list.pushFront(12)
    list.pushFront(11)
    list.pushEnd(30)
    list.add(40,2)
    list.add(1,1)
    println(list.getSize())
    println("list: ")

    list.print()


  }

  def run() = {
    testCode()
  }

}
