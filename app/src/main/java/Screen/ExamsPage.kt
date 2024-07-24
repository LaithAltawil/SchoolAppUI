package Screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.apptryout.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamsPage(){
    ///TODO: Add Exams Page here
    /// STILL NOT DONE
    val mainmenuitem = listOf(
        mainmenuitems("Account", Icons.Default.AccountBox,{}),
        mainmenuitems("Classes", Icons.Default.Check, {}),
        mainmenuitems("Marks", Icons.Default.Create, {}),
        mainmenuitems("HomeWorks", Icons.Default.Home, {}),
        mainmenuitems("Profile", Icons.Default.AccountBox, {}),
        mainmenuitems("Settings", Icons.Default.Check, {})

    )

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(), color = colorResource(id = R.color.color_secondary)
    ) {
        Scaffold(
            containerColor = colorResource(id = R.color.color_secondary),
            topBar = {
                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id = R.color.color_secondary),
                        titleContentColor = colorResource(id = R.color.color_light),
                    ),
                    title = {
                        Text("Homeworks")
                    },
                    navigationIcon = {
                        IconButton(onClick = { }) {
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
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                LazyVerticalGrid(columns = GridCells.Adaptive(minSize = 128.dp)) {
                    items(mainmenuitem) { item ->
                        Card(
                            onClick = {}, modifier = Modifier
                                .padding(16.dp)
                                .size(200.dp)
                                .width(100.dp)
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .wrapContentSize(Alignment.Center),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = item.name,
                                    fontSize = 20.sp,
                                    color = Color.White,
                                    textAlign = TextAlign.Center
                                )
                                Icon(
                                    imageVector = item.ImagePath,
                                    contentDescription = "Profile pic"
                                )

                            }

                        }

                    }

                }


            }
        }


    }
}