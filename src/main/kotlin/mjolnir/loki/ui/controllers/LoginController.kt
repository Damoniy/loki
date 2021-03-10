package mjolnir.loki.ui.controllers

import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.PasswordField
import javafx.scene.control.TextField
import javafx.stage.Stage
import mjolnir.loki.database.Database
import mjolnir.loki.database.login.Credentials
import mjolnir.loki.stages.Dashboard
import mjolnir.loki.stages.Dashboard.Companion.dashboard
import java.net.URL
import java.util.*

class LoginController: Initializable {

    @FXML private var b:Button = Button()
    @FXML private var tf0 = TextField()
    @FXML private var tf1 = PasswordField()
    @FXML var lb = Label()

    @FXML
    fun onClickEvent(){
        for(cdt in Database.credentials){
            if(tf0.text == cdt.login && tf1.text == cdt.password){
                println(cdt.id)
                lb.text = "ID $cdt.id logged into system."

                closeLogin()

                dashboard.getStarted()

            } else {
                lb.text = "Bad credentials."
            }
        }
    }

    private fun closeLogin(){
        b.scene.window.hide()
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        Database.getCredentials()
    }
}