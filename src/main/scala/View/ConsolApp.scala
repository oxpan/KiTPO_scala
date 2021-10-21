package git.group
package View

import List.TList

class ConsolApp {
  var list:TList[Int] = new TList()


  def testCode() = {
    println("code:")
    println(list.getSize())
  }

  def run() = {
    testCode()
  }

}
