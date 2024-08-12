package Screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.apptryout.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun calanderPage(
    navController: NavHostController
) {

    val mainmenuitem = listOf(
        mainmenuitems("Maths", painterResource(id = R.drawable.math)) { },
        mainmenuitems("Science", painterResource(id = R.drawable.science)) { },
        mainmenuitems("English", painterResource(id = R.drawable.english)) { },
        mainmenuitems("History", painterResource(id = R.drawable.history)) {},
        mainmenuitems("Arabic", painterResource(id = R.drawable.arabic)) {},
        mainmenuitems("Geography", painterResource(id = R.drawable.geography)) {}

    )
    val exams = listOf(
        listOf("subject :- ", "Laith"),
        listOf("teacher :- ", "john.tyler@examplepetstore.com"),
        listOf("what to study? :- ", "0123456789"),
        listOf("address :- ", "123 Main Street"),
        listOf("gender :- ", "Male"),
        listOf("dob :- ", "01/01/2000"),
        listOf("nationality :- ", "Kenyan"),
        listOf("language :- ", "English"),
        listOf("religion :- ", "Christian"),
    )
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()


    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxSize(), color = colorResource(id = R.color.color_secondary)
    ) {
        Scaffold(
            containerColor = colorResource(id = R.color.color_secondary),
            topBar = {
                LargeTopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = colorResource(id = R.color.color_secondary),
                        titleContentColor = colorResource(id = R.color.color_light),
                    ),
                    title = {
                        Text("Incoming events")
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
                modifier = Modifier.padding(innerPadding),
                horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
            ) {
                LazyColumn {
                    items(mainmenuitem) { item ->
                        ExpandableButton(name = item.name, icon = item.ImagePath) {

                        }

                    }
                }


            }
        }


    }

}


@Composable
fun ExpandableButton(name: String, icon: Painter, onClick: () -> Unit) {

    var expanded by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Button(
            onClick = { expanded = !expanded }, modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = colorResource(id = R.color.color_primary),
                contentColor = colorResource(id = R.color.color_light)
            )

        ) {
            Text(text = name)
        }
        Spacer(modifier = Modifier.fillMaxWidth())
        AnimatedVisibility(
            visible = expanded,
            enter = fadeIn() + expandVertically(),
            exit = fadeOut() + shrinkVertically()
        ) {
            Card(colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.color_primary),
                contentColor = colorResource(id = R.color.color_secondary)
            )) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text("This is the expanded box content.")
                    // Add more content to the box here
                }
            }
        }
    }
}