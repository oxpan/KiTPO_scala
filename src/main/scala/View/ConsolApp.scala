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
    println(list.getSize())


  }

  def run() = {
    testCode()
  }

}
