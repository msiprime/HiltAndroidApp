package com.example.hiltandroidapp

import com.example.hiltandroidapp.campussheba.ShebaViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.hiltandroidapp.campussheba.data.model.ShebaCategory
import com.example.hiltandroidapp.core.ui.theme.HiltAndroidAppTheme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            HiltAndroidAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ShebaCategoryList()
                }
            }
        }
    }
}

//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
//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

@Composable
fun ShebaCategoryList(viewModel: ShebaViewModel = hiltViewModel()) {
    // Collect data from the ViewModel
    val shebaData by remember {
        viewModel.shebaData
    }
    ShebaList(list = shebaData)

}
@Composable
fun CategoryItem(category: ShebaCategory) {
    // Customize the UI to display a single category item
    // You can use category.name, category.description, category.imageUrl, etc.
    Column {
        category.name?.let { Text(text = it) }
        category.description?.let { Text(text = it) }
        // Add an Image or other UI elements if needed
    }
}
@Composable
fun ShebaList(list: List<ShebaCategory>) {
    LazyColumn {
        items(list) { category ->
            CategoryItem(category)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HiltAndroidAppTheme {
        ShebaCategoryList()
    }
}