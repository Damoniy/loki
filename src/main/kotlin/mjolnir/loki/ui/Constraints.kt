package mjolnir.loki.ui

import javafx.scene.control.TextField
import javafx.beans.value.ObservableValue

class Constraints {

    companion object {
        fun setTextInt(tf: TextField) {
            tf.textProperty().addListener { obs: ObservableValue<out String?>?, oldValue: String?, newValue: String? ->
                if (newValue != null && !newValue.matches("\\d*".toRegex())) {
                    tf.text = oldValue
                }
            }
        }
    }
}