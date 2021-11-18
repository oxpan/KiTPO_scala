package git.group

import View.ConsolApp

object main{

  def main(args: Array[String]): Unit = {
    var consol = new ConsolApp
    var flag:Boolean = false
    while (flag == false){
      println("Введите тип списка")
      flag = consol.toBuilder(scala.io.StdIn.readLine())
    }

//    consol.testCode()
    consol.run()
  }
}
