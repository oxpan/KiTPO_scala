package git.group
package View

import git.group.Builder.{Builder, BuilderInteger}
import git.group.List.{DoIt, TList}

import scala.collection.immutable._
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.event.ActionEvent
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.input.{KeyCode, KeyCodeCombination, KeyCombination}
import scalafx.scene.layout.{Background, BackgroundFill, VBox}
import scalafx.scene.paint.Color
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle

import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}


object GUI_View extends JFXApp {
  val fullScreenX = 845
  val fullScreenY = 480
  var builder:Builder = new BuilderInteger
  var list:TList = new TList(builder)




    stage = new JFXApp.PrimaryStage {
      title.value = "KiTPO GUI TList"
      width = fullScreenX
      height = fullScreenY
      centerOnScreen()
//      sizeToScene()
      resizable = false


      scene = new Scene {
        fill = LightGreen

        val menuBar = new MenuBar

//        file menu bar
        val menuFile = new Menu("file")
        val load_menu = new MenuItem("load")
        load_menu.accelerator = new KeyCodeCombination(KeyCode.I,KeyCombination.ControlDown)
        load_menu.onAction = (e:ActionEvent) => {
          try {
            var i:ObjectInputStream = new ObjectInputStream(new FileInputStream("list.bin"))
            var loaded:TList = i.readObject().asInstanceOf[TList]
            builder = loaded.getBuilder
            list = loaded
            println("success load")
          }catch {
            case e:Exception => println("ERROR load")
          }finally {
            updateList()
          }
        }
        val save_menu = new MenuItem("save")
        save_menu.accelerator = new KeyCodeCombination(KeyCode.O,KeyCombination.ControlDown)
        save_menu.onAction = (e:ActionEvent) => {
          try{
            var out:ObjectOutputStream = new ObjectOutputStream(new FileOutputStream("list.bin"))
            out.writeObject(list)
            println("success save")
          }catch {
            case e:Exception => println("ERROR save")
          }finally {
            updateList()
          }
        }
        val exit_menu = new MenuItem("exit")
        exit_menu.accelerator = new KeyCodeCombination(KeyCode.D,KeyCombination.ControlDown)
        exit_menu.onAction = (e:ActionEvent) => sys.exit(0)
        menuFile.items = List(load_menu,save_menu,new SeparatorMenuItem,exit_menu)

//        TList menu bar
        val menuTList = new Menu("TList")
        val sort_menu = new MenuItem("sort")
        sort_menu.accelerator = new KeyCodeCombination(KeyCode.S,KeyCombination.ControlDown)
        sort_menu.onAction = (e:ActionEvent) => {
          try {
            list.sort()
            updateList()
          }catch {
            case e:Exception => e.printStackTrace()
          }
        }
        val gen_front = new MenuItem("genFront")
        gen_front.accelerator = new KeyCodeCombination(KeyCode.F,KeyCombination.ControlDown)
        gen_front.onAction = (e:ActionEvent) => {
          try{
            list.pushFront(builder.createObject())
            updateList()
          }catch{
            case e:Exception => e.printStackTrace()
          }
        }
        val gen_back = new MenuItem("genBack")
        gen_back.accelerator = new KeyCodeCombination(KeyCode.B,KeyCombination.ControlDown)
        gen_back.onAction = (e:ActionEvent) => {
          try {
            list.pushEnd(builder.createObject())
            updateList()
          }catch {
            case e:Exception => e.printStackTrace()
          }
        }
        val clear_list_item = new MenuItem("clear")
        clear_list_item.accelerator = new KeyCodeCombination(KeyCode.L,KeyCombination.ControlDown)
        clear_list_item.onAction = (e:ActionEvent) => {
          try {
            list.clear()
            updateList()
          }catch {
            case e:Exception => e.printStackTrace()
          }
        }
        menuTList.items = List(sort_menu,new SeparatorMenuItem,gen_front,gen_back,new SeparatorMenuItem,clear_list_item)

//        menu setting
        val menuSetting = new Menu("setting")
        val autoClear = new CheckMenuItem("auto-clearLabel")
        autoClear.accelerator = new KeyCodeCombination(KeyCode.W,KeyCombination.ControlDown)
        //давай потом!
        menuSetting.items = List(autoClear)

        menuBar.menus = List(menuFile,menuTList,menuSetting)
        menuBar.prefWidth = (fullScreenX)

        val PossX = 10

        val insertLabel = new Label("Insert")
        insertLabel.layoutX = PossX
        insertLabel.layoutY = 30


        val PossYInsert = 50

        val insertTextField = new TextField
        insertTextField.layoutX = PossX
        insertTextField.layoutY = PossYInsert
        insertTextField.prefWidth = 100
        insertTextField.promptText = "element:"

        val pushFront_button = new Button("front")
        pushFront_button.layoutX = PossX+110
        pushFront_button.layoutY = PossYInsert
        pushFront_button.prefWidth = 60
        pushFront_button.onAction = (e:ActionEvent) => {
          if(insertTextField.getText != "") {
            try {
              var tmp = insertTextField.getText().toInt
              list.pushFront(tmp)
              updateList()
            } catch {
              case e: Exception => e.printStackTrace()
            }finally {
              insertTextField.clear()
            }
          }
        }



        val pushBack_button = new Button("back")
        pushBack_button.layoutX = PossX+110+70
        pushBack_button.layoutY = PossYInsert
        pushBack_button.prefWidth = 60
        pushBack_button.onAction = (e:ActionEvent) => {
          if (insertTextField.getText != ""){
            try {
              var tmp = insertTextField.getText().toInt
              list.pushEnd(tmp)
              updateList()
            } catch {
              case e:Exception => e.printStackTrace()
            }finally {
              insertTextField.clear()
            }
          }
        }

        val insertToIndexLabel = new Label("Insert to index")
        insertToIndexLabel.layoutX = PossX
        insertToIndexLabel.layoutY = 90

        val PossYInsertToIndex = 110

        val insertToIndexTextFieldOne = new TextField
        insertToIndexTextFieldOne.layoutX = PossX
        insertToIndexTextFieldOne.layoutY = PossYInsertToIndex
        insertToIndexTextFieldOne.prefWidth = 100
        insertToIndexTextFieldOne.promptText = "element:"

        val insertToIndexTextFieldTwo = new TextField
        insertToIndexTextFieldTwo.layoutX = PossX+100
        insertToIndexTextFieldTwo.layoutY = PossYInsertToIndex
        insertToIndexTextFieldTwo.prefWidth = 50
        insertToIndexTextFieldTwo.promptText = "index:"

        val push_button = new Button("push")
        push_button.layoutX = PossX+160
        push_button.layoutY = PossYInsertToIndex
        push_button.prefWidth = 60
        push_button.onAction = (e:ActionEvent) => {
          if(insertToIndexTextFieldOne.getText != "" && insertToIndexTextFieldTwo.getText != "") {
            try {
              var tmp = insertToIndexTextFieldOne.getText().toInt
              var tmpIndex = insertToIndexTextFieldTwo.getText().toInt
              list.add(tmp,tmpIndex)
              updateList()
            } catch {
              case e: Exception => e.printStackTrace()
            }finally {
              insertToIndexTextFieldOne.clear()
              insertToIndexTextFieldTwo.clear()
            }
          }
        }

        val deleteLabel = new Label("Delete:")
        deleteLabel.layoutX = PossX
        deleteLabel.layoutY = 150

        val PossYDelete = 170

        val deleteTextFieldOne = new TextField
        deleteTextFieldOne.layoutX = PossX
        deleteTextFieldOne.layoutY = PossYDelete
        deleteTextFieldOne.prefWidth = 100
        deleteTextFieldOne.promptText = "element:"

        val deleteTextFieldTwo = new TextField
        deleteTextFieldTwo.layoutX = PossX+100
        deleteTextFieldTwo.layoutY = PossYDelete
        deleteTextFieldTwo.prefWidth = 50
        deleteTextFieldTwo.promptText = "index:"

        val delete_button = new Button("del")
        delete_button.layoutX = PossX+160
        delete_button.layoutY = PossYDelete
        delete_button.prefWidth = 60
        delete_button.onAction = (e:ActionEvent) => {
          if (deleteTextFieldTwo.getText != ""){
            try{
              var tmpIndex = deleteTextFieldTwo.getText().toInt
              list.delete(tmpIndex)
              updateList()
            }catch {
              case e:ActionEvent => e.printStackTrace()
            }finally {
              deleteTextFieldTwo.clear()
            }
          }
        }



        val changeTypeLabel = new Label("To change type TList:")
        changeTypeLabel.layoutX = PossX
        changeTypeLabel.layoutY = 250

        val PossYChange = 270

        val change_menuButton = new MenuButton("type TList")
        change_menuButton.layoutX = PossX
        change_menuButton.layoutY = PossYChange

        val integer_menuButton = new RadioMenuItem("Integer")
        integer_menuButton.selected = true
        integer_menuButton.onAction = (e:ActionEvent) => println("yes")
        val string_menuButton = new RadioMenuItem("String")
        val group = new ToggleGroup

        group.toggles = List(integer_menuButton,string_menuButton)
        change_menuButton.items = List(integer_menuButton,string_menuButton)


        val findLabel = new Label("Find:")
        findLabel.layoutX = PossX
        findLabel.layoutY = 320

        val PossYFindEl = 340
        val PossYFindIn = 370

        val findElTextField = new TextField
        findElTextField.layoutX = PossX
        findElTextField.layoutY = PossYFindEl
        findElTextField.prefWidth = 100
        findElTextField.promptText = "element:"

        val findElem_button = new Button("find")
        findElem_button.layoutX = PossX+110
        findElem_button.layoutY = PossYFindEl
        findElem_button.prefWidth = 60
        findElem_button.onAction = (e:ActionEvent) => {
          if (findElTextField.getText != ""){
            try{
              var tmp = findElTextField.getText().toInt
              if (list.finds(tmp) > -1)
                findOutLabelOne.setText("index: "+list.finds(tmp))
              else
                findOutLabelOne.setText("NoIndex")
            } catch {
              case e:ActionEvent => e.printStackTrace()
            } finally {
              findOutLabelOne.setTextFill(Color.Black)
            }
          }
          else{
            findOutLabelOne.setText("NoElement!")
            findOutLabelOne.setTextFill(Color.Red)
          }
        }

        val findOutLabelOne = new Label("-")
        findOutLabelOne.layoutX = PossX+110+70
        findOutLabelOne.layoutY = PossYFindEl

        val findInTextField = new TextField
        findInTextField.layoutX = PossX
        findInTextField.layoutY = PossYFindIn
        findInTextField.prefWidth = 100
        findInTextField.promptText = "index:"

        val findIndex_button = new Button("find")
        findIndex_button.layoutX = PossX+110
        findIndex_button.layoutY = PossYFindIn
        findIndex_button.prefWidth = 60
        findIndex_button.onAction = (e:ActionEvent) => {
          if (findInTextField.getText != ""){
            try{
              var tmpIndex = findInTextField.getText().toInt
              if (tmpIndex <= list.getSize)
                findOutLabelTwo.setText("element: "+list.find(tmpIndex))
              else
                findOutLabelTwo.setText("NoElement")
            } catch {
              case e:ActionEvent => e.printStackTrace()
            } finally {
              findOutLabelTwo.setTextFill(Color.Black)
            }
          }
          else{
            findOutLabelTwo.setText("NoIndex!")
            findOutLabelTwo.setTextFill(Color.Red)
          }
        }

        val findOutLabelTwo = new Label("-")
        findOutLabelTwo.layoutX = PossX+110+70
        findOutLabelTwo.layoutY = PossYFindIn

        val size_list_label = new Label("sizeTList = 0")
        size_list_label.layoutX = PossX
        size_list_label.layoutY = 420
        size_list_label.setTextFill(Color.Red)


        val textArea = new TextArea
        textArea.layoutX = fullScreenX/3 // <--- пробование динамического расположения (при создании окна - НЕПРИИЗМЕНЕНИИРАЗМЕРА)
        textArea.layoutY = fullScreenY-(fullScreenY-30)
        textArea.prefHeight = (fullScreenY-75)
        textArea.prefWidth = fullScreenX-(fullScreenX/3 + 25)
        textArea.promptText = "TList:"
        textArea.editable = false

        private def show_list() = {
          list.forEach(new DoIt{
            override def doIt(o: Any): Unit = {
//              textArea.clear()
              textArea.appendText(o.toString() + "\n")
            }
          })
        }

        private def updateList()={
          size_list_label.setText("sizeTList = "+ list.getSize)
          size_list_label.setTextFill(Color.Black)
          textArea.clear()
          show_list()
        }

//      список крнтента
        private val contentList = List(
          textArea,
          menuBar,
          insertLabel,
          insertTextField,
          pushFront_button,
          pushBack_button,
          insertToIndexLabel,
          insertToIndexTextFieldOne,
          insertToIndexTextFieldTwo,
          push_button,
          deleteLabel,
//          deleteTextFieldOne,
          deleteTextFieldTwo,
          delete_button,
          changeTypeLabel,
          change_menuButton,
//          changeTextField,
//          changeType_button,
          findLabel,
          findElTextField,
          findElem_button,
          findOutLabelOne,
          findInTextField,
          findIndex_button,
          findOutLabelTwo,
          size_list_label
        )

        content = contentList
      }
    }
}
