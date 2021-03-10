package mjolnir.loki.ui.controllers

import javafx.collections.FXCollections
import javafx.collections.ObservableList
import javafx.fxml.FXML
import javafx.fxml.Initializable
import javafx.scene.control.Button
import javafx.scene.control.TableColumn
import javafx.scene.control.TableView
import javafx.scene.control.TextArea
import javafx.scene.control.cell.PropertyValueFactory
import mjolnir.loki.finacial.CoinBag
import mjolnir.loki.finacial.CoinBagList
import mjolnir.loki.stages.Dashboard.Companion.dashboard
import mjolnir.loki.users.User
import mjolnir.loki.utils.Utils
import java.net.URL
import java.util.*

class DashboardController: Initializable {

    @FXML private var text0 = TextArea()
    @FXML var btn0:Button = Button()
    @FXML var btn1:Button = Button()
    @FXML var btn2:Button = Button()
    @FXML var btn3:Button = Button()
    @FXML var btn4:Button = Button()
    @FXML var btn5:Button = Button()

    @FXML private var tb:TableView<CoinBag> = TableView()
    @FXML private var column0:TableColumn<CoinBag, String> = TableColumn("date")
    @FXML private var column1:TableColumn<CoinBag, Int> = TableColumn("id")
    @FXML private var column2:TableColumn<CoinBag, Double> = TableColumn("value")

    @FXML private var tb0:TableView<User> = TableView()
    @FXML private var column3:TableColumn<User, String> = TableColumn("id")
    @FXML private var column4:TableColumn<User, Int> = TableColumn("name")
    @FXML private var column5:TableColumn<User, Double> = TableColumn("birthday")

    private var observable: ObservableList<CoinBag> = FXCollections.observableArrayList(CoinBagList.callList())

    @FXML fun openReports(){
        dashboard.switchToReports()
    }

    @FXML fun openUserManager(){
        dashboard.switchToUserManager()
    }

    @FXML fun getStarted(){
        dashboard.backTo()
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        text0.isWrapText = true

        column0.cellValueFactory = PropertyValueFactory("date")
        column1.cellValueFactory = PropertyValueFactory("id")
        column2.cellValueFactory = PropertyValueFactory("value")
        Utils.formatTableColumnDouble(column2, 2)

        tb.items = observable

        column3.cellValueFactory = PropertyValueFactory("id")
        column4.cellValueFactory = PropertyValueFactory("name")
        column5.cellValueFactory = PropertyValueFactory("birthday")

        tb0.items = FXCollections.observableArrayList(User(420001, "Damoniy", "01/03/2021"))
    }
}