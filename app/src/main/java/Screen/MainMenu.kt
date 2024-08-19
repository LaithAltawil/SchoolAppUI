package Screen

//TODO
//FIND AN IDEA ON HOW TO DISPLAY THE SUBJECT CLASSES TIMES IN CLASSES PAGE

//FIND AN IDEA ON HOW TO DISPLAY MARKS IN MARKS PAGE

//FIND AN ITDEA ON WHEN TO DO WITH THE SETTINGS PAGE


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.SpaceBetween
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.apptryout.R
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenu(
    navController: NavHostController,
    MoveToProfilePage: () -> Unit,
    MoveToExamsPage: () -> Unit,
    MoveToHomeworksPage: () -> Unit,
    MoveToConselorReq: () -> Unit,
    MoveToResourcesPage: () -> Unit,
    MoveToCalanderPage: () -> Unit,
    MoveToSettingsPage: () -> Unit,
    MoveToHomeworks2Page: () -> Unit
) {
    val Scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val name = "Laith"

    val cardlist = remember {
        mutableStateListOf(
            HomeworkCardData("Mathematics",
                "Complete exercises 1-10 on page 35"),
            HomeworkCardData("History",
                "Write a short essay on the French Revolution"),
            HomeworkCardData(
                "Science",
                "Prepare for the lab experiment on photosynthesis",),
            HomeworkCardData(
                "English",
                "Read chapters 4 and 5 of 'To Kill a Mockingbird'",),
            HomeworkCardData("Art",
                "Finish the still life painting"),
            HomeworkCardData("Music",
                "Practice scales and arpeggios for 30 minutes"),
            HomeworkCardData(
                "Physical Education",
                "Complete the workout routine posted online")
        )
    }

    val mainmenuitem = listOf(
        mainmenuitems("Homeworks", painterResource(id = R.drawable.homework)) {
            MoveToHomeworks2Page()
        },

        mainmenuitems(
            "Account", painterResource(id = R.drawable.baseline_account_box_24)
        ) {
            MoveToProfilePage()
        },
        mainmenuitems(
            "Classes", painterResource(id = R.drawable.baseline_schedule_24)
        ) {
            MoveToExamsPage()
        },
        mainmenuitems("Marks", painterResource(id = R.drawable.grade))
        {
            MoveToHomeworksPage()
        },
        mainmenuitems(
            "Counselor appointment", painterResource(id = R.drawable.icons8_counselor_50)
        ) {
            MoveToConselorReq()
        },
        mainmenuitems(
            "Profile", painterResource(id = R.drawable.baseline_account_box_24)
        ) {
            MoveToResourcesPage()
        },
        mainmenuitems("calender", painterResource(id = R.drawable.baseline_calendar_view_week_24))
        {
            MoveToCalanderPage()
        },
        mainmenuitems("Settings", painterResource(id = R.drawable.baseline_settings_24)) {
            MoveToSettingsPage()
        }
    )
    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Scaffold(
                modifier = Modifier.fillMaxSize(),
                containerColor = colorResource(id = R.color.color_secondary),
                topBar = {
                    TopAppBar(
                        colors = TopAppBarDefaults.topAppBarColors(
                            containerColor = colorResource(id = R.color.color_secondary),
                            titleContentColor = colorResource(id = R.color.color_light),
                        ),
                        title = {
                            Text(
                                "",
                                overflow = TextOverflow.Visible, fontSize = 35.sp,
                                modifier = Modifier.padding(start = 30.dp)
                            )
                        },

                        )
                },
            ) {
                Column(modifier = Modifier.padding(it),horizontalAlignment = Alignment.CenterHorizontally,verticalArrangement = Arrangement.Center) {
                    Card(
                        modifier = Modifier
                            .padding(16.dp)
                            .height(70.dp)
                            .width(300.dp)
                            .clickable { MoveToProfilePage() },
                        colors = androidx.compose.material3.CardDefaults.cardColors(
                            containerColor = colorResource(id = R.color.color_secondary)
                        )
                    ) {
                        Row(
                            horizontalArrangement = SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.baseline_account_box_24),
                                modifier = Modifier
                                    .size(70.dp)
                                    .padding(top = 5.dp, bottom = 5.dp),
                                contentDescription = "",
                                tint = colorResource(id = R.color.color_light)
                            )
                            Text(
                                text = "Laith",
                                fontSize = 30.sp,
                                color = colorResource(id = R.color.color_light)
                            )


                        }
                    }
                    LazyColumn(
                        modifier = Modifier.padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        items(mainmenuitem) { item ->
                            Card(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .height(100.dp)
                                    .width(300.dp)
                                    .clickable { item.onClick() },
                                colors = androidx.compose.material3.CardDefaults.cardColors(
                                    containerColor = colorResource(id = R.color.color_primary)
                                )
                            ) {
                                Column(
                                    modifier = Modifier
                                        .padding(16.dp)
                                        .size(300.dp),
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    verticalArrangement = Arrangement.Center
                                ) {

                                    Text(
                                        text = item.name,
                                        fontSize = 20.sp,
                                        color = colorResource(id = R.color.color_light)
                                    )
                                }


                            }

                        }

                    }


                }

            }
        }


    }, content = {
        Scaffold(
            modifier = Modifier, containerColor = colorResource(id = R.color.color_secondary),
            topBar = {
                MediumTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id = R.color.color_secondary),
                        titleContentColor = colorResource(id = R.color.color_light),
                    ),
                    title = {
                        Text(
                            "Welcome ${name}",
                            overflow = TextOverflow.Visible, fontSize = 35.sp,
                            modifier = Modifier.padding(start = 30.dp)
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = { Scope.launch { drawerState.open() } }) {
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


                LazyRow(modifier = Modifier.padding(start = 10.dp, end = 20.dp)) {
                    items(cardlist) { item ->
                        Card(
                    modifier = Modifier
                        .height(200.dp)
                        .width(400.dp)
                        .wrapContentSize(Alignment.Center),
                    colors = androidx.compose.material3.CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.color_primary)
                    )
                ) {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                            .size(300.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = item.title,
                            fontSize = 20.sp,
                            color = colorResource(id = R.color.color_light)
                        )
                    }
                }



                    }

                }

//leaving it here for now

//                Card(
//                    modifier = Modifier
//                        .height(200.dp)
//                        .width(400.dp)
//                        .wrapContentSize(Alignment.Center),
//                    colors = androidx.compose.material3.CardDefaults.cardColors(
//                        containerColor = colorResource(id = R.color.color_primary)
//                    )
//                ) {
//                    Column(
//                        modifier = Modifier
//                            .padding(16.dp)
//                            .size(300.dp),
//                        horizontalAlignment = Alignment.CenterHorizontally,
//                        verticalArrangement = Arrangement.Center
//                    ) {}
//                }
                Text(
                    "Unfinished Homeworks",
                    overflow = TextOverflow.Visible, fontSize = 35.sp,
                    modifier = Modifier.padding(top=16.dp,bottom=16.dp, start = 10.dp),color = colorResource(id = R.color.color_light)
                )
                LazyColumn(
                    modifier = Modifier.padding(start = 10.dp, end = 20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(cardlist) { item ->
                        Card(
                            modifier = Modifier
                                .padding(16.dp)
                                .height(80.dp)
                                .width(400.dp)
                                .clickable { }
                                .wrapContentSize(Alignment.Center)
                                .clip(androidx.compose.foundation.shape.RoundedCornerShape(10.dp)),
                            colors = androidx.compose.material3.CardDefaults.cardColors(
                                containerColor = colorResource(id = R.color.color_primary)
                            )
                        ) {
                            Column(
                                modifier = Modifier
                                    .padding(16.dp)
                                    .size(300.dp),
                                horizontalAlignment = Alignment.CenterHorizontally,
                                verticalArrangement = Arrangement.Center
                            ) {
                                Text(
                                    text = item.title,
                                    fontSize = 20.sp,
                                    color = colorResource(id = R.color.color_light)
                                )

                            }

                        }

                    }

                }

            }
        }
    })


}