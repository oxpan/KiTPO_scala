package git.group
package View

import scala.collection.immutable._
import scalafx.Includes._
import scalafx.application.JFXApp
import scalafx.scene.Scene
import scalafx.scene.control._
import scalafx.scene.paint.Color._
import scalafx.scene.shape.Rectangle

import javax.swing.text.html.MinimalHTMLWriter

object GUI_View extends JFXApp {

    stage = new JFXApp.PrimaryStage {
      title.value = "KiTPO GUI TList"
      width = 500
      height = 390
      centerOnScreen()
//      sizeToScene()
      resizable = false


      scene = new Scene {
        fill = LightGreen

        val download_button = new Button("Download")
        val save_button = new Button("Save")
        val sort_button = new Button("Sort")
        val pushFront_button = new Button("PushFront")
        val pushBack_button = new Button("PushBack")
        val add_button = new Button("Inset to Index")
        val delete_button = new Button("Delete")
        val findElem_button = new Button("Fint to element")
        val findIndex_button = new Button("Find to index")
        val textArea = new TextArea

//        положение кнопок
        val XSetOne = 400 // <-- первая строка кнопок
        val YSetOne = 20
        val spaceOne = 40
        val XSetTwo = 370 // <-- вторая строка кнопок
        val YSetTwo = 190
        val spaceTwo = 35

        download_button.layoutX = XSetOne
        download_button.layoutY = YSetOne
        save_button.layoutX = XSetOne
        save_button.layoutY = YSetOne+spaceOne
        sort_button.layoutX = XSetOne
        sort_button.layoutY = YSetOne+spaceOne+spaceOne+spaceOne
        pushFront_button.layoutX = XSetTwo
        pushFront_button.layoutY = YSetTwo
        pushBack_button.layoutX = XSetTwo
        pushBack_button.layoutY = YSetTwo+spaceTwo
        add_button.layoutX = XSetTwo
        add_button.layoutY = YSetTwo+spaceTwo+spaceTwo
        delete_button.layoutX = XSetTwo
        delete_button.layoutY = YSetTwo+spaceTwo+spaceTwo+spaceTwo
        textArea.layoutX = 10
        textArea.layoutY = 10
        textArea.prefHeight = 160
        textArea.prefWidth = 380
        textArea.promptText = "TList:"

//      список крнтента
        private val buttonList = List(
          download_button,
          save_button,
          sort_button,
          pushBack_button,
          pushFront_button,
          add_button,
          delete_button,
          textArea)

        content = buttonList
      }
    }
}
