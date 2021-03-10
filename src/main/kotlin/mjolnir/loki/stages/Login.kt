package mjolnir.loki.stages

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Parent
import javafx.scene.Scene
import javafx.scene.image.Image
import javafx.stage.Stage
import mjolnir.loki.utils.FileHelper
import java.io.IOException

class Login: Application() {
    override fun start(pS: Stage){
        pS.title = "Loki"
        try{
            pS.icons.add(Image("/gui/img/loki-icon.png"))
            val url = FileHelper.getResourceAsURL("/gui/fxml/login.fxml")
            val p:Parent = FXMLLoader.load(url)
            var scene = Scene(p)
            scene.stylesheets.add("/gui/css/Login.css")
            pS.scene = scene
            pS.show()
        } catch(e: IOException){
            e.printStackTrace()
        }
    }

    fun getStarted() {
        launch()
    }
}