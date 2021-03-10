package mjolnir.loki.utils

import java.io.InputStream
import java.net.URL

class FileHelper {
    companion object{
        fun getResourceAsURL(path: String): URL {
            return object {}.javaClass.getResource(path)
        }

        fun getResourceAsText(path: String): String {
            return object {}.javaClass.getResource(path).readText()
        }
    }
}