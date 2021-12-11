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
      width = 600
      height = 450
      centerOnScreen()
//      sizeToScene()
      resizable = false


      scene = new Scene {
        fill = LightGreen
//        content = new Rectangle{
//          x = 85
//          y = 80
//          width = 100
//          height = 100
//          fill <== when(hover) choose Green otherwise Red
//        }
//        new Rectangle{
//          x = 200
//          y = 100
//          width = 20
//          height = 20
//          fill <== when(hover) choose Green otherwise Yellow
//        }
        val button = new Button("click")
        button.layoutX = 100
        button.layoutY = 50
        val but = new Button("ppppp")


        content = List(button,but)
      }
    }



//  stage = new JFXApp.PrimaryStage{
//    title = "Window"
//    scene = new Scene(800,600){
//
//
//      root =  new BorderPane(){
//        center = new Label("Hello World")
//
//
//      }
//
//    }
//
//  }
}
