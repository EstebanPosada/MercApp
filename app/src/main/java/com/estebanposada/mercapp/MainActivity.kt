package com.estebanposada.mercapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Menu
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.estebanposada.mercapp.models.GroceryItem
import com.estebanposada.mercapp.models.groceryList
import com.estebanposada.mercapp.ui.theme.MercAppTheme
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MercAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    App()
                }
            }
        }
    }
}


@Composable
fun App() {
    CheckList(
        items = groceryList,
        title = "My list (${SimpleDateFormat("dd/MM/yyyy").format(Date())})"
    )
}

@Composable
fun CheckList(items: List<GroceryItem>, title: String) {
    Column {
        Text(title, modifier = Modifier.fillMaxWidth(), textAlign = TextAlign.Center)
        LazyColumn {
            items(items) {
                val checked = remember { mutableStateOf(false) }
                LabeledCheckBox(
                    checked = checked.value,
                    onCheckedChange = { checked.value = !checked.value },
                    label = it.name,
                    subtitle = it.category.name
                )
            }
        }

    }
}

@Composable
fun LabeledCheckBox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: (Boolean) -> Unit,
    label: String,
    subtitle: String = "",
    enabled: Boolean = true
) {
    Row(
        modifier = modifier
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            enabled = enabled,
        )
        Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = label, modifier = Modifier.fillMaxWidth(), fontSize = 16.sp)
            if (subtitle.isNotEmpty())
                Text(
                    subtitle,
                    textAlign = TextAlign.Center,
                    fontSize = 8.sp
                )
        }
        Icon(Icons.Rounded.Menu, contentDescription = "")

    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MercAppTheme {
        App()
    }
}