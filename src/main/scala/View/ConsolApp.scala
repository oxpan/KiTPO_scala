package git.group
package View

import List.TList
import git.group.Builder.{Builder, BuilderInteger, BuilderString}
import git.group.Comaparator.ComparatorInteger
import git.group.Comaparator.Comparator

class ConsolApp {

  private var list:TList = null
  private var switch_menu:Int = 0
  private var tmp_index:Int = 0
  private var flag_menu:Boolean = true

//  def testCode() = {
//    println("code:")
//    println(list.getSize())
//
//    list.pushFront(12)
//    list.pushFront(11)
//    list.pushEnd(30)
//    list.add(40,2)
//    list.add(1,1)
//    println(list.getSize())
//    println(list.getSizeLimit)
//    println("list: ")
//
//    list.print()
//    println()
//    println("delete list: ")
//    list.delete(2)
//    list.print()
//    println()
//    println("find list: ")
//    println("[2] "+list.find(2))
//    println("[int 30] "+list.finds(30))
//
//
//  }
//
//  def testDrive(maxElement:Int) = {
//    var list:TList[Int] = new TList(maxElement)
//    var n:Int = 0;
//    var i:Int = 0;
//    while (n < maxElement){
//      i = scala.util.Random.nextInt(maxElement).toInt
//      list.pushEnd(i)
//      n = n + 1
//    }
//    list.print()
//    println()
//    println("size: "+list.getSize())
//
//
//    n = 0
//    while (n < maxElement){
//      list.delete(0)
//      n = n + 1
//    }
//    println("clear")
//
//
//
//  }

  def toBuilder(name:String):Boolean = {
//
    true
=======

  }

//  private def settingBuilder(name:String):Builder = {}

  def run() = {
    while (flag_menu) {
      ConsoleMenu()
      print(">>")
      switch_menu = scala.io.StdIn.readLine().toInt
      switch_menu match {
        case 0 =>
          println("Выход")
          flag_menu = false

        case 1 =>
          println("Введите данные")
          print(">>")
//          list.pushFront()


        case 2 =>
          println("Введите данные")
          print(">>")
//          list.pushEnd()


        case 3 =>
          println("Введите индекс элемента")
          print(">>")
          tmp_index = scala.io.StdIn.readLine().toInt
          println("Введите данные")
          print(">>")
//          list.add()

        case 4 =>
//          list.pushFront()
        case 5 =>
//          list.pushEnd()
        case 6 =>
          println("Введите индекс элемента")
          print(">>")
          tmp_index = scala.io.StdIn.readLine().toInt
//          list.add()
        case 7 =>
          println("Введите индекс")
          print(">>")
          tmp_index = scala.io.StdIn.readLine().toInt
          list.delete(tmp_index)
        case 8 =>
          println("Введите индекс")
          print(">>")
          tmp_index = scala.io.StdIn.readLine().toInt
          println("element: "+ list.find(tmp_index))
        case 9 =>
//          list.sort()
        case 10 =>
//          drawList()
        case 11 =>
          println("Введите кол-во лементов")
          val elem:Int = scala.io.StdIn.readLine().toInt
//          testDriweList(elem)
        case 12 =>
          list.clear()
        case 13 =>
          println("Введите тип списка")

        case 14 =>//bla
        case 15 =>//bla
        case _ =>
          println("ochepyatka")
      }
    }
  }

  private def ConsoleMenu() = {
    println("----------------------------------")
    println("1 - Добавить в начало списка")
    println("2 - Добавить в конец списка")
    println("3 - Добавить по индексу в список")
    println("4 - Добавить в начало списка (случ.)")
    println("5 - Добавить в конец списка (случ.)")
    println("6 - Добавить по индексу в список (случ.)")
    println("7 - Удалить по индексу из списка")
    println("8 - Поиск по индексу")
    println("9 - Сортировка списка (quickSort)")
    println("10 - Вывод списка")
    println("11 - **testdrive** ")
    println("12 - Очистить список")
    println("13 - Изменить тип списка")
    println("14 - Записать в файл список")
    println("15 - Прочитать из файла список")
    println("0 - Выйти")
    println("----------------------------------")
  }

}
