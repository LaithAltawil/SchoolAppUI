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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.apptryout.R

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SignInPage(
    OnNavigateToHome: () -> Unit,
    OnNavigateToForgotPassword: () -> Unit
) {
    val navController = rememberNavController()
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }



    Surface(
        color = colorResource(id = R.color.color_secondary),
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .padding(top = 10.dp)
                .imePadding()
                .imeNestedScroll(),
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "Sign In",
                modifier = Modifier
                    .padding(24.dp, bottom = 32.dp)
                    .imePadding()
                    .imeNestedScroll(),
                color = colorResource(id = R.color.color_light),
                textAlign = TextAlign.Left,
                fontSize = 50.sp,
                fontWeight = FontWeight.ExtraBold
            )
            OutlinedTextField(
                value = username,
                onValueChange = { username = it },
                label = { Text(text = "Username") },
                placeholder = { Text(text = "Enter Username") },
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
            Row(
                modifier = Modifier.padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = { OnNavigateToHome() }, modifier = Modifier
                        .padding(16.dp)
                        .width(120.dp)
                        .fillMaxWidth()
                        .imePadding()
                        .imeNestedScroll(),
                    colors =  ButtonDefaults.buttonColors(
                        contentColor = colorResource(id = R.color.color_light),
                        containerColor = colorResource(id = R.color.color_primary)
                        )

                ) {
                    Text(text = "SignIn", fontSize = 20.sp)

                }

                ClickableText(

                    text = AnnotatedString("forgot password?\n click here"),
                    onClick = {
                        OnNavigateToForgotPassword()
                    },
                    modifier = Modifier
                        .padding(start = 84.dp, top = 16.dp)
                        .imePadding()
                        .imeNestedScroll(),
                    style = TextStyle(
                        fontSize = 18.sp,
                        color = colorResource(id = R.color.color_light),
                    )
                )


            }


        }
    }


}




