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
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import java.text.SimpleDateFormat
import java.util.*
import java.util.Locale.getDefault
import java.util.Calendar


@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun CounselorReq(navController: NavHostController) {
    var username by remember { mutableStateOf("") }
    val context = LocalContext.current
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)
    var selectedDate by remember { mutableStateOf("") }
    val datePicker = DatePickerDialog(
        context, // or context if you're not in an Activity
        { _, year, month, dayOfMonth ->
            val calendar = Calendar.getInstance()
            calendar.set(year, month, dayOfMonth)
            val dateFormat = SimpleDateFormat("yyyy-MM-dd", getDefault())
            val formattedDate = dateFormat.format(calendar.time)
            selectedDate = dateFormat.format(calendar.time)
            val sharedPrefs = context.getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)
            val editor = sharedPrefs.edit()
            editor.putString("selected_date", formattedDate)
            editor.apply()
        },
        year,
        month,
        dayOfMonth
    )
    var showDialog by remember { mutableStateOf(false) }


    Surface(
        color = colorResource(id = R.color.color_secondary),
        modifier = Modifier.fillMaxSize()
    ) {
        Scaffold(
            modifier = Modifier.padding(top=32.dp), containerColor = colorResource(id = R.color.color_secondary),
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
                    .imeNestedScroll(),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = username,
                    onValueChange = { username = it },
                    label = { Text(text = "Username") },
                    placeholder = {
                        Text(
                            text = "Enter Username",
                            color = colorResource(id = R.color.color_light)
                        )
                    },
                    modifier = Modifier
                        .padding(36.dp)
                        .fillMaxWidth()
                        .imePadding()
                        .imeNestedScroll(),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        focusedBorderColor = colorResource(id = R.color.color_light), // Color of the border when focused
                        unfocusedBorderColor = colorResource(id = R.color.color_light), // Color of the border when not focused
                        focusedLabelColor = colorResource(id = R.color.color_light), // Color of the label when focused
                        unfocusedLabelColor = colorResource(id = R.color.color_light), // Color of the label when not focused
                        cursorColor = colorResource(id = R.color.color_light), // Color of the cursor
                        focusedTextColor = colorResource(id = R.color.color_light),
                        unfocusedTextColor = colorResource(id = R.color.color_light)
                    ), singleLine = true
                )
                Row(horizontalArrangement = Arrangement.SpaceBetween) {
                    Button(
                        onClick = { datePicker.show() },
                        modifier = Modifier.padding(16.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.color_primary), // Change the background color
                            contentColor = colorResource(id = R.color.color_light) // Change the text color
                        )
                    ) {
                        Text(text = "Select Date")
                    }
                    Text(
                        text = "Selected Date: $selectedDate",
                        modifier = Modifier.padding(16.dp),
                        fontSize = 20.sp,
                        overflow = TextOverflow.Ellipsis,
                        color = colorResource(id = R.color.color_light)
                    )
                }
                Button(
                    onClick = { showDialog = true },
                    modifier = Modifier.padding(16.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.color_primary), // Change the background color
                        contentColor = colorResource(id = R.color.color_light) // Change the text color
                    )
                ) {
                    Text("conformation")
                }
                if (showDialog) {
                    AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Confirmation") },
                        text = { Text("Are you sure you want to select this date for your appointment?") },
                        confirmButton = {
                            Button(onClick = {
                                // Handle confirmation action
                                navController.popBackStack()
                                showDialog = false
                            }) {
                                Text("Confirm")
                            }
                        },
                        dismissButton = {
                            Button(onClick = { showDialog = false }) {
                                Text("Cancel")
                            }
                        }
                    )
                }


            }

        }


    }


}



