package Screen

import androidx.compose.ui.graphics.painter.Painter

data class mainmenuitems(
    val name: String,
    val ImagePath: Painter,
    val onClick: () -> Unit
)

data class CalenderDays(
    val day: String,
    val event: String,
    val onClick: () -> Unit
)

data class Homeworks(
    val Subject: String,
    val Details: String,
)

data class CardData(
    val title: String,
    val content: String,
    var isExpanded: Boolean = false
)


