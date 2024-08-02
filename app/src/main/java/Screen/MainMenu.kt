package Screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Create
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Card
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
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
    MoveToConselorReq: () -> Unit
) {
    val Scope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val name = "Laith"

    val mainmenuitem = listOf(
        mainmenuitems("Account", Icons.Default.AccountBox) { MoveToProfilePage() },
        mainmenuitems("Classes", Icons.Default.Check) { MoveToExamsPage() },
        mainmenuitems("Marks", Icons.Default.Create) { MoveToHomeworksPage() },
        mainmenuitems("HomeWorks", Icons.Default.Home) {MoveToConselorReq()},
        mainmenuitems("Profile", Icons.Default.AccountBox) {},
        mainmenuitems("Settings", Icons.Default.Check) {}

    )
    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        ModalDrawerSheet {
            Column {
                Card(
                    modifier = Modifier
                        .padding(16.dp)
                        .height(150.dp)
                        .width(300.dp),
                    colors = androidx.compose.material3.CardDefaults.cardColors(
                        containerColor = colorResource(id = R.color.color_primary)
                    )
                ) {}
                LazyColumn(
                    modifier = Modifier.padding(start = 30.dp, end = 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(mainmenuitem) { item ->
                        Card(
                            modifier = Modifier
                                .padding(16.dp)
                                .height(150.dp)
                                .width(300.dp),
                            colors = androidx.compose.material3.CardDefaults.cardColors(
                                containerColor = colorResource(id = R.color.color_primary)
                            )
                        ) {

                        }

                    }

                }


            }

        }


    }, content = {
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
                LazyRow(modifier = Modifier.padding(top = 25.dp)) {
                    items(mainmenuitem) { item ->
                        Card(
                            modifier = Modifier
                                .padding(16.dp)
                                .size(200.dp)
                                .width(100.dp).clickable { item.onClick() },
                            colors = androidx.compose.material3.CardDefaults.cardColors(
                                containerColor = colorResource(id = R.color.color_primary)
                            )
                        ) {

                        }


                    }
                }

                LazyColumn(
                    modifier = Modifier.padding(start = 30.dp, end = 0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    items(mainmenuitem) { item ->
                        Card(
                            modifier = Modifier
                                .padding(16.dp)
                                .height(150.dp)
                                .width(300.dp).clickable { item.onClick() },
                            colors = androidx.compose.material3.CardDefaults.cardColors(
                                containerColor = colorResource(id = R.color.color_primary)
                            )
                        ) {

                        }

                    }

                }

            }
        }
    })


}