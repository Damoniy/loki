package mjolnir.loki.stages

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Screen
import javafx.stage.Stage
import mjolnir.loki.utils.FileHelper
import java.io.IOException
import java.net.URL

class Dashboard{

    companion object{
        val dashboard = Dashboard()
    }

    var scene: Scene? = null
    var pS: Stage? = null
    var url: URL? = null
    var p: Parent? = null

    private val screen = Screen.getPrimary()
    private val bounds = screen.visualBounds

    private fun start() {
        pS = Stage()
        pS!!.title = "Loki | Dashboard"
        try{
            pS!!.icons.add(Image("/gui/img/loki-icon.png"))

            url = FileHelper.getResourceAsURL("/gui/fxml/dashboard.fxml")
            p = FXMLLoader.load(url)
            scene = Scene(p)

            scene?.stylesheets?.add("/gui/css/Dashboard.css")

            pS!!.x = bounds.minX
            pS!!.y = bounds.minY
            pS!!.width = bounds.width
            pS!!.height = bounds.height

            pS!!.scene = scene
            pS!!.show()
        } catch(e: IOException){
            e.printStackTrace()
        }
    }

    fun switchToReports(){
        try{
            url = FileHelper.getResourceAsURL("/gui/fxml/dashboard-reports.fxml")
            p = FXMLLoader.load(url)
            scene = Scene(p)

            scene?.stylesheets?.add("/gui/css/Dashboard.css")

            pS!!.scene = scene
        } catch(e: IOException){
            e.printStackTrace()
        }
    }

    fun switchToUserManager(){
        try{
            url = FileHelper.getResourceAsURL("/gui/fxml/dashboard-um.fxml")
            p = FXMLLoader.load(url)
            scene = Scene(p)

            scene?.stylesheets?.add("/gui/css/Dashboard.css")

            pS!!.scene = scene
        } catch(e: IOException){
            e.printStackTrace()
        }
    }

    fun backTo(){
        try{
            url = FileHelper.getResourceAsURL("/gui/fxml/dashboard.fxml")
            p = FXMLLoader.load(url)
            scene = Scene(p)

            scene?.stylesheets?.add("/gui/css/Dashboard.css")

            pS!!.scene = scene
        } catch(e: IOException){
            e.printStackTrace()
        }
    }

    fun getStarted() {
        start()
    }
}