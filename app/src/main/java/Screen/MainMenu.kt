package Screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apptryout.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenu(
    MoveToProfilePage:() -> Unit
) {
    val name = "Laith"
    val mainmenuitem = listOf(
        mainmenuitems("Account", Icons.Default.AccountBox) { MoveToProfilePage() },
        mainmenuitems("Classes", Icons.Default.Check, {}),
        mainmenuitems("Marks", Icons.Default.Create, {}),
        mainmenuitems("HomeWorks", Icons.Default.Home, {}),
        mainmenuitems("Profile", Icons.Default.AccountBox, {}),
        mainmenuitems("Settings", Icons.Default.Check, {})

    )



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
                        "Welcome ${name}",
                        overflow = TextOverflow.Ellipsis, fontSize = 40.sp
                    )
                },
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            modifier = Modifier.size(50.dp),
                            imageVector = Icons.AutoMirrored.Default.List,
                            contentDescription = "Localized description",
                            tint = colorResource(id = R.color.color_light)
                        )
                    }
                },

                )
        },
    ) {
        Column(modifier = Modifier.padding(it)) {
            LazyRow(modifier = Modifier.padding(top = 25.dp)) {
                items(mainmenuitem) { item ->
                    Button(
                        onClick = item.onClick,
                        modifier = Modifier
                            .padding(16.dp)
                            .size(150.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.color_accent),
                            contentColor = colorResource(id = R.color.color_primary)
                        )
                    ) {
                        Icon(
                            imageVector = item.ImagePath,
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                    }
                }
            }

            LazyColumn(modifier = Modifier.padding(start=30.dp,end=0.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                items(mainmenuitem) { item ->
                    Button(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .padding(16.dp)
                            .width(300.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.color_accent),
                            contentColor = colorResource(id = R.color.color_primary)
                        )
                    ) {
                        Icon(
                            imageVector = item.ImagePath,
                            contentDescription = null,
                            modifier = Modifier.size(100.dp)
                        )
                    }
                }

            }

        }
    }



}