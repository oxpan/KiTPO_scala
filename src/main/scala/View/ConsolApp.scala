package git.group
package View

import List.{DoIt, TList}
import git.group.Builder.{Builder, BuilderInteger, BuilderString}
import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}
import git.group.Comaparator.ComparatorInteger
import git.group.Comaparator.Comparator

class ConsolApp {
  private var builder:Builder = null
  private var list:TList = null
  private var switch_menu:Int = 0
  private var tmp_index:Int = 0
  private var flag_menu:Boolean = true
  private val os:String = System.getProperty("os.name")

  def toBuilder(name:String):Boolean = {
    try {
      builder = settingBuilder(name)
    }catch {
      case e:Exception => e.printStackTrace()
        return false
    }
    list = new TList(builder)
    true
  }

  private def clr = {
    try {
      if (os.contains("Windows"))
        new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor()
      else
        Runtime.getRuntime().exec("clear")
    }catch {
      case e:Exception => e.printStackTrace()
    }
  }

  private def settingBuilder(name:String):Builder = {
    if (name.equals(BuilderString.getName)) {
      return new BuilderString
    }else if (name.equals(BuilderInteger.getName)){
      return new BuilderInteger
    } else {
      var e:Exception = new Exception("OSHIBKA: нет такого типа")
      throw e
    }

  }

  private def drawList()={
    list.forEach(new DoIt {
      override def doIt(o: Any): Unit = println(o.toString())
    })
  }

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
          list.pushFront(builder.parseObject(scala.io.StdIn.readLine()))
          clr
        case 2 =>
          println("Введите данные")
          print(">>")
          list.pushEnd(builder.parseObject(scala.io.StdIn.readLine()))
          clr
        case 3 =>
          println("Введите индекс элемента")
          print(">>")
          tmp_index = scala.io.StdIn.readLine().toInt
          println("Введите данные")
          print(">>")
          list.add(builder.parseObject(scala.io.StdIn.readLine()),tmp_index)
          clr
        case 4 =>
          list.pushFront(builder.createObject())
          clr
        case 5 =>
          list.pushEnd(builder.createObject())
          clr
        case 6 =>
          println("Введите индекс элемента")
          print(">>")
          tmp_index = scala.io.StdIn.readLine().toInt
          list.add(builder.createObject(),tmp_index)
          clr
        case 7 =>
          println("Введите индекс")
          print(">>")
          tmp_index = scala.io.StdIn.readLine().toInt
          list.delete(tmp_index)
          clr
        case 8 =>
          println("Введите индекс")
          print(">>")
          tmp_index = scala.io.StdIn.readLine().toInt
          println("element: "+ list.find(tmp_index))
          clr
        case 9 =>
          list.sort
          clr
        case 10 =>
          drawList()
          click
          clr
        case 11 =>
          println("Введите кол-во лементов")
          val elem:Int = scala.io.StdIn.readLine().toInt
          testDriweList(elem)
          click
          clr
        case 12 =>
          list.clear()
          clr
        case 13 =>
          println("Введите тип списка")
          try{
            var old:Builder = list.getBuilder
            builder = settingBuilder(scala.io.StdIn.readLine())
            if (!list.setBuilder(builder)){
              println("Список не пустой. Очистите его перед сменой типа.")
              builder = old
            }
          }catch {
            case e:Exception => e.printStackTrace()
          }
          click
          clr
        case 14 =>
          try
          {
            var out:ObjectOutputStream = new ObjectOutputStream(new FileOutputStream("list.bin"))
            out.writeObject(list)
            println("Успешная запись")
          }catch {
            case e:Exception => println("Ошибка записи")
          }
          click
          clr
        case 15 =>
          try {
            var i:ObjectInputStream = new ObjectInputStream(new FileInputStream("list.bin"))
            var loaded:TList = i.readObject().asInstanceOf[TList]
            builder = loaded.getBuilder
            list = loaded
            println("Успешное чтение")
          }catch {
            case e:Exception => println("Ошибка чтения")
          }
          click
          clr
        case _ =>
          println("ochepyatka")
          click
          clr
      }
    }
  }

  private def click = {
    println("Для продолжения нажмите клавишу Enter")
    scala.io.StdIn.readLine()
  }

  private def testDriweList(maxElement:Int): Unit ={
    var testlist:TList = new TList(builder)

    var i:Int = 0
    while (i  < maxElement){
      testlist.pushEnd(builder.createObject())
      i += 1
    }
    println("\n\nСгенерированый список")
    drawList(testlist)

    println("\n\nПоиск каждого четвертого елемента")
    i = 0
    while (i < maxElement){
      println(testlist.find(i))
      i += 4
    }

    println("\n\nПроиизошла сортировка")
    testlist.sort
    drawList(testlist)

    testlist.clear()

    println("Список удален")
  }

  private def drawList(otherlist:TList): Unit ={
    otherlist.forEach(new DoIt {
      override def doIt(o: Any): Unit = println(o.toString())
    })
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
