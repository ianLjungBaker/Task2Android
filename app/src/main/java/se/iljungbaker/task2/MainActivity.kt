package se.iljungbaker.task2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import se.iljungbaker.task2.ui.theme.Task2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Task2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting()
                }
            }
        }
    }
}

@Preview
@Composable
fun Greeting() {
    var listItems by remember {mutableStateOf(emptyList<String>()) }

    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White),
        //verticalArrangement = Arrangement.Center
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Bluerow(
            addItem = { item -> listItems = listItems + item },
            onReset = { listItems = emptyList() }
        )

        Spacer(modifier = Modifier.height(16.dp))
        list(listItems)

        Spacer(modifier = Modifier.height(30.dp))
        ResetButton(onReset = {listItems = emptyList() })

    }

}

@Composable
fun Bluerow(addItem: (String) -> Unit, onReset: () -> Unit ) {
    Row (
        modifier = Modifier
            .height(100.dp)
            .fillMaxWidth()
            .background(Color.Blue),
        horizontalArrangement = Arrangement.Center

    ){
        Button(onClick = { addItem("X") }) {
            Text(text = "X")

        }

        Spacer(modifier = Modifier.width(50.dp))

        Button(onClick = { addItem("Y") }) {
            Text(text = "Y")

        }
    }
}

@Composable
fun list (listItems: List<String>) {
    LazyColumn() {
        items(listItems) { item ->
            Text(text = item)
        }
    }
}

@Composable
fun ResetButton (onReset: () -> Unit) {
    Button(onClick = { onReset() }) {
        Text(text = "RESET")
    }
}
