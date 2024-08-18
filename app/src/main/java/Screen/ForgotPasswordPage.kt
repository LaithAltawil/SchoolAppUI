package Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imeNestedScroll
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.apptryout.R

@OptIn(ExperimentalLayoutApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Forgotpassword(){


    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }



    Surface(
        color = colorResource(id = R.color.color_secondary),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .imePadding()
                .imeNestedScroll(),
            verticalArrangement = Arrangement.Center,horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "Change Password",
                modifier = Modifier
                    .padding(24.dp, bottom = 32.dp)
                    .imePadding()
                    .imeNestedScroll(),
                color = colorResource(id = R.color.color_light),
                textAlign = TextAlign.Left,
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold
            )
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "old password") },
                placeholder = { Text(text = "Enter old password") },
                modifier = Modifier
                    .padding(16.dp)
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
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(16.dp)
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
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword= it },
                label = { Text(text = "confirm Password") },
                placeholder = { Text(text = "confirm password") },
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .padding(16.dp)
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
                Button(
                    onClick = {  }, modifier = Modifier
                        .padding(16.dp)

                        .fillMaxWidth()
                        .imePadding()
                        .imeNestedScroll()
                        .clip(RoundedCornerShape(6.dp))

                ) {
                    Text(text = "Confirm", fontSize = 30.sp)

                }







        }
    }
}

