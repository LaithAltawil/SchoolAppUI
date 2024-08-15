package Screen

import androidx.compose.ui.graphics.painter.Painter

data class mainmenuitems(
    val name:String,
    val ImagePath: Painter,
    val onClick:() -> Unit
    )
data class CalenderDays(
    val day:String,
    val event:String,
    val onClick:() -> Unit

)



