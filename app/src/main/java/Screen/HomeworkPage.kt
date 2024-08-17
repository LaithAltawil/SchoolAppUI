package Screen

import android.app.Activity
import android.content.Intent
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.apptryout.R
import java.io.InputStream

//TODO
//MAKE THAT ONLY THE CLCIKED CARD TO BE EXPANDED
//TRY TO ADD A FILE THAT WHEN CLICKED IT DOWNLOADS IT
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Stack035(navController: NavController) {

//to open file picker


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
                        Text("Homeworks")
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
                    items(cardlist) { cardlist ->
                        ExpandableCard(cardlist)
                    }
                }


            }
        }


    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ExpandableCard(cardData: HomeworkCardData) {

        val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val uri = result.data?.data // The selected file's URI
            // Handle the URI and save the file to the database
        }
    }
    var isExpanded by remember { mutableStateOf(false) }

        Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .combinedClickable { isExpanded = !isExpanded },
        colors = CardDefaults.cardColors(
            containerColor = colorResource(id = R.color.color_primary),
            contentColor = colorResource(id = R.color.color_light)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = cardData.title,
                style = MaterialTheme.typography.headlineSmall
            )
            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = cardData.content,
                    style = MaterialTheme.typography.bodyMedium
                )
                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_OPEN_DOCUMENT).apply {
                            addCategory(Intent.CATEGORY_OPENABLE)
                            type = "*/*" // Allow all file types
                        }
                        launcher.launch(intent)
                    }, colors = ButtonDefaults.buttonColors(
                        containerColor = colorResource(id = R.color.color_secondary),
                        contentColor = colorResource(id = R.color.color_light)
                    )
                ) {
                    Text("Upload File")
                }

            }
        }
    }
}

//TODO//

//    val linesCount = remember {
//        mutableStateOf(0)
//    }
//
//    val context = LocalContext.current
//
//    val pickFileLauncher =
//        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { FileUri ->
//            if (FileUri != null) {
//                val inputStream: InputStream? =context.contentResolver.openInputStream(FileUri)
//                val lineList = mutableListOf<String>()
//                inputStream?.bufferedReader()?.forEachLine { lineList.add(it) }
//                linesCount.value = lineList.size
//                Log.e("TAG", "Stack035: $FileUri")
//            }
//        }
//
//    Column(modifier = Modifier.fillMaxSize()) {
//        Button(onClick = {
//            pickFileLauncher.launch("*/*")
//        }) {
//            Text(text = "Open File")
//        }
//
//        Text(text = "How many lines in the files == ${linesCount.value}")
//
//    }
