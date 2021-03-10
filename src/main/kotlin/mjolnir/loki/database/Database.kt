package mjolnir.loki.database

import mjolnir.loki.database.login.Credentials
import mjolnir.loki.utils.Utils
import java.sql.Connection
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class Database {
    companion object {
        var connection: Connection? = null
        var statement: Statement? = null
        var resultSet: ResultSet? = null

        val credentials = ArrayList<Credentials>()

        fun getCredentials() {
            try {
                connection = Utils.tryToConnect()
                println("Initialized.")

                statement = connection?.createStatement()
                resultSet = statement?.executeQuery("select * from credentials")

                while (resultSet?.next() == true) {
                    val cdt = Credentials()

                    cdt.id = resultSet?.getInt("id")
                    cdt.login = resultSet?.getString("login")
                    cdt.password = resultSet?.getString("pass")

                    credentials.add(cdt)
                }

            } catch (e: SQLException) {
                throw e.message?.let { DbException(it) }!!
            }
            Utils.closeConnection()
        }
    }
}