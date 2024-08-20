package Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apptryout.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CLassesPage(navController: NavController) {
    val days = remember {
        mutableStateListOf(
            daysClasses(
                "Sunday",
                listOf(
                    "Math",
                    "Science",
                    "History",
                    "English",
                    "Art",
                    "Music",
                    "Physical Education",
                    "Computer Science"
                )
            ),
            daysClasses(
                "Monday",
                listOf(
                    "Math",
                    "Science",
                    "History",
                    "English",
                    "Art",
                    "Music",
                    "Physical Education",
                    "Computer Science"
                )
            ),
            daysClasses(
                "Tuesday",
                listOf(
                    "Math",
                    "Music",
                    "Physical Education",
                    "English",
                    "Art",
                    "Science",
                    "History",
                    "Computer Science"
                )
            ),
            daysClasses(
                "Wednesday",
                listOf(
                    "Art",
                    "Music",
                    "Physical Education",
                    "Computer Science",
                    "Math",
                    "Science",
                    "History",
                    "English"
                )
            ),
            daysClasses(
                "Thursday",
                listOf(
                    "Math",
                    "Science",
                    "History",
                    "English",
                    "Art",
                    "Music",
                    "Physical Education",
                    "Computer Science"
                )
            )
        )
    }

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(), color = colorResource(id = R.color.color_secondary)
    ) {
        Scaffold(
            containerColor = colorResource(id = R.color.color_secondary),
            topBar = {
                CenterAlignedTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id = R.color.color_secondary),
                        titleContentColor = colorResource(id = R.color.color_light),
                    ),
                    title = {
                        Text(
                            "Classes",
                            fontSize = 30.sp,
                            color = colorResource(id = R.color.color_light)
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.popBackStack()
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
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                LazyColumn {
                    items(days) { item ->
                        Text(color = colorResource(id = R.color.color_light),
                            text = item.Dayss, fontSize = 40.sp,
                            modifier = Modifier
                                .padding(10.dp)
                                .clickable { item.isExpanded = !item.isExpanded })

                        if (!item.isExpanded) {
                            LazyRow {
                                items(item.Classes) { item ->
                                    Card(
                                        modifier = Modifier
                                            .padding(10.dp)
                                            .width(200.dp), colors = CardDefaults.cardColors(
                                            containerColor = colorResource(id = R.color.color_primary),
                                            contentColor = colorResource(id = R.color.color_light)
                                        )
                                    ) {
                                        Column(
                                            modifier = Modifier
                                                .padding(30.dp)
                                                .fillMaxWidth(),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Center
                                        ) {
                                            Text(
                                                text = item,
                                                fontSize = 20.sp,
                                                textAlign = TextAlign.Center
                                            )

                                        }

                                    }


                                }


                            }
                        }
                    }


                }

            }
        }
    }


}

