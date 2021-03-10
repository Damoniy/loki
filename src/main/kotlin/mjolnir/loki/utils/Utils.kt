package mjolnir.loki.utils

import javafx.scene.control.TableCell
import javafx.scene.control.TableColumn
import mjolnir.loki.database.DbException
import java.io.FileInputStream
import java.io.IOException
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale


class Utils {
    companion object{
        private var connection: Connection? = null

        fun tryToConnect(): Connection? {
            if(connection == null) {
                try {
                    val properties = loadProperties()
                    val url = properties.getProperty("dburl")
                    connection = DriverManager.getConnection(url, properties)
                } catch (e: SQLException){
                    throw e.message?.let { DbException(it) }!!
                }
            }

            return connection
        }

        private fun loadProperties(): Properties{
            try{
                val stream = FileInputStream("db.properties")
                val properties = Properties()
                properties.load(stream)
                return properties
            } catch (e: IOException){
                throw e.message?.let { DbException(it) }!!
            }
        }

        fun closeConnection(){
            if(connection != null){
                try{
                    connection!!.close()
                } catch (e: SQLException){
                    throw e.message?.let { DbException(it) }!!
                }
            }
        }

        fun <T> formatTableColumnDate(tableColumn: TableColumn<T, Date>, format: String?) {
            tableColumn.setCellFactory {
                val cell: TableCell<T, Date> = object : TableCell<T, Date>() {
                    private val sdf = SimpleDateFormat(format)
                     override fun updateItem(item: Date?, empty: Boolean) {
                        super.updateItem(
                                item,
                                empty
                        )
                        if (empty) {
                            setText(null)
                        } else {
                            setText(sdf.format(item))
                        }
                    }
                }
                cell
            }
        }

        fun <T> formatTableColumnDouble(tableColumn: TableColumn<T, Double>, decimalPlaces: Int) {
            tableColumn.setCellFactory {
                val cell: TableCell<T, Double> = object : TableCell<T, Double>() {
                     override fun updateItem(item: Double?, empty: Boolean) {
                        super.updateItem(item, empty)
                        if (empty) {
                            setText(null)
                        } else {
                            Locale.setDefault(Locale.US)
                            setText(String.format("%." + decimalPlaces + "f", item))
                        }
                    }
                }
                cell
            }

        }

    }
}