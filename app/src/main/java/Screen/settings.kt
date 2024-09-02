package Screen

import Screen.commons.mainmenuitems
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.apptryout.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun settingspage() {
    val navController = NavController

    val mainmenuitem = listOf(
        mainmenuitems("Profile", painterResource(id = R.drawable.baseline_account_box_24)) { },
        mainmenuitems("Notifications", painterResource(id = R.drawable.baseline_notifications_24)) { },
        mainmenuitems("Theme", painterResource(id = R.drawable.theme)) { },
        mainmenuitems("Accessibility", painterResource(id = R.drawable.theme)) {},
        mainmenuitems("Help & FAQ", painterResource(id = R.drawable.help)) {},
        mainmenuitems("Contact us", painterResource(id = R.drawable.contact_us)) {}

    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(), color = colorResource(id = R.color.color_secondary)
    ) {
        Scaffold(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            containerColor = colorResource(id = R.color.color_secondary),
            topBar = {
                MediumTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id = R.color.color_secondary),
                        titleContentColor = colorResource(id = R.color.color_light),
                    ),
                    title = {
                        Text("Settings", fontSize = 30.sp)
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            //TODO
                        }) {
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
            // Add content padding
        ) { innerPadding ->
            Column(
                modifier = Modifier.padding(innerPadding),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LazyColumn {
                    items(mainmenuitem) { item ->
                        Button(
                            onClick = { /*TODO*/ },
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                                .padding(5.dp),
                            colors = androidx.compose.material3.ButtonDefaults.buttonColors(
                                containerColor = colorResource(id = R.color.color_primary),
                                contentColor = colorResource(id = R.color.color_light)
                            )
                        ) {
                            Row(
                                modifier = Modifier.fillMaxWidth(),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Row {
                                    Icon(
                                        painter = item.ImagePath,
                                        contentDescription = null,
                                    )
                                    Text(
                                        text = item.name,
                                        modifier = Modifier.padding(start = 10.dp),
                                        fontSize = 18.sp,
                                    )
                                }
                                Icon(
                                    imageVector = Icons.Default.KeyboardArrowRight,
                                    contentDescription = null
                                )

                            }


                        }

                    }
                }


            }
        }


    }


}

@Preview
@Composable
fun SettingspagePreview() {
    settingspage()
}


