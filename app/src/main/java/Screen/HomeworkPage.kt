package Screen

import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import java.io.InputStream

@Composable
fun Stack035() {

    val linesCount = remember {
        mutableStateOf(0)
    }

    val context = LocalContext.current

    val pickFileLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { FileUri ->
            if (FileUri != null) {
                val inputStream: InputStream? =context.contentResolver.openInputStream(FileUri)
                val lineList = mutableListOf<String>()
                inputStream?.bufferedReader()?.forEachLine { lineList.add(it) }
                linesCount.value = lineList.size
                Log.e("TAG", "Stack035: $FileUri")
            }
        }

    Column(modifier = Modifier.fillMaxSize()) {
        Button(onClick = {
            pickFileLauncher.launch("*/*")
        }) {
            Text(text = "Open File")
        }

        Text(text = "How many lines in the files == ${linesCount.value}")

    }
}