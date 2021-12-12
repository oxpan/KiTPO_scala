package git.group
package View

import scala.collection.immutable._
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.input.{KeyCodeCombination,KeyCode,KeyCombination}
import scalafx.scene.layout.VBox
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle


object GUI_View extends JFXApp {
  val fullScreenX = 845
  val fullScreenY = 480

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
        load_menu.accelerator = new KeyCodeCombination(KeyCode.O,KeyCombination.ControlDown)
        val save_menu = new MenuItem("save")
        save_menu.accelerator = new KeyCodeCombination(KeyCode.I,KeyCombination.ControlDown)
        val exit_menu = new MenuItem("exit")
        exit_menu.accelerator = new KeyCodeCombination(KeyCode.D,KeyCombination.ControlDown)
        menuFile.items = List(load_menu,save_menu,new SeparatorMenuItem,exit_menu)

//        TList menu bar
        val menuTList = new Menu("TList")
        val sort_menu = new MenuItem("sort")
        sort_menu.accelerator = new KeyCodeCombination(KeyCode.S,KeyCombination.ControlDown)
        val gen_front = new MenuItem("genFront")
        gen_front.accelerator = new KeyCodeCombination(KeyCode.F,KeyCombination.ControlDown)
        val gen_back = new MenuItem("genBack")
        gen_back.accelerator = new KeyCodeCombination(KeyCode.B,KeyCombination.ControlDown)
        menuTList.items = List(sort_menu,new SeparatorMenuItem,gen_front,gen_back)


        menuBar.menus = List(menuFile,menuTList)
        menuBar.prefWidth = (fullScreenX)


        val pushFront_button = new Button("PushFront")
        val pushBack_button = new Button("PushBack")
        val add_button = new Button("Inset to Index")
        val delete_button = new Button("Delete")
        val findElem_button = new Button("Fint to element")
        val findIndex_button = new Button("Find to index")
        val textArea = new TextArea

//        положение кнопок
//        pushFront_button.layoutX = XSetTwo
//        pushFront_button.layoutY = YSetTwo
//        pushBack_button.layoutX = XSetTwo
//        pushBack_button.layoutY = YSetTwo+spaceTwo
//        add_button.layoutX = XSetTwo
//        add_button.layoutY = YSetTwo+spaceTwo+spaceTwo
//        delete_button.layoutX = XSetTwo
//        delete_button.layoutY = YSetTwo+spaceTwo+spaceTwo+spaceTwo
        textArea.layoutX = fullScreenX/3 // <--- пробование динамического расположения (при создании окна - НЕПРИИЗМЕНЕНИИРАЗМЕРА)
        textArea.layoutY = fullScreenY-(fullScreenY-30)
        textArea.prefHeight = (fullScreenY-75)
        textArea.prefWidth = fullScreenX-(fullScreenX/3 + 25)
        textArea.promptText = "TList:"

//      список крнтента
        private val buttonList = List(
//          download_button,
//          save_button,
//          sort_button,
//          pushBack_button,
//          pushFront_button,
//          add_button,
//          delete_button,
          textArea,
          menuBar
        )

        content = buttonList
      }
    }
}
