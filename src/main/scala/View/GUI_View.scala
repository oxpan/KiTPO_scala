package git.group
package View

import scalafx.application.JFXApp
import scalafx.scene.Scene

object GUI_View extends JFXApp {
  stage = new JFXApp.PrimaryStage{
    title = "Window"
    scene = new Scene(800,600){}

  }
}
