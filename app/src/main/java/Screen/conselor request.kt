package Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.apptryout.R
import android.app.DatePickerDialog
import android.content.Context
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.getDefault
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CounselorReq(navController: NavHostController) {
    var username = ""
   val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

    Surface(
        color = colorResource(id = R.color.color_secondary),
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            modifier = Modifier, containerColor = colorResource(id = R.color.color_secondary),
            topBar = {
                LargeTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id = R.color.color_secondary),
                        titleContentColor = colorResource(id = R.color.color_light),
                    ),
                    title = {
                        Text(
                            "Conselor appointment request",
                            overflow = TextOverflow.Ellipsis, fontSize = 35.sp
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                modifier = Modifier.size(50.dp),
                                imageVector = Icons.AutoMirrored.Default.ArrowBack,
                                contentDescription = "Localized description",
                                tint = colorResource(id = R.color.color_light)
                            )
                        }
                    },

                    )
            },
        ) {
            Column(
                modifier = Modifier
                    .padding(it)
                    .imePadding()
                    .imeNestedScroll()
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text(text = "Username") },
                    placeholder = { Text(text = "Enter Username") },
                    modifier = Modifier
                        .padding(36.dp)
                        .fillMaxWidth()
                        .imePadding()
                        .imeNestedScroll(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.color_light), // Color of the border when focused
                        unfocusedBorderColor = Color.Gray, // Color of the border when not focused
                        focusedLabelColor = colorResource(id = R.color.color_light), // Color of the label when focused
                        unfocusedLabelColor = colorResource(id = R.color.color_light), // Color of the label when not focused
                        cursorColor = colorResource(id = R.color.color_light), // Color of the cursor
                        focusedTextColor = colorResource(id = R.color.color_light),
                        unfocusedTextColor = colorResource(id = R.color.color_light)
                    ), singleLine = true
                )




                val datePicker = DatePickerDialog(
                    context, // or context if you're not in an Activity
                    { _, year, month, dayOfMonth ->
                        val calendar = Calendar.getInstance()
                        calendar.set(year, month, dayOfMonth)
                        val dateFormat = SimpleDateFormat("yyyy-MM-dd", getDefault())
                        val formattedDate = dateFormat.format(calendar.time)

                        val sharedPrefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
                        val editor = sharedPrefs.edit()
                        editor.putString("selected_date", formattedDate)
                        editor.apply()
                    },
                    year,
                    month,
                    dayOfMonth
                )
                datePicker.show()



            }

        }


    }


}



