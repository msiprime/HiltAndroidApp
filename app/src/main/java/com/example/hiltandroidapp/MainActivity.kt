package com.example.hiltandroidapp

import android.content.Intent
import android.content.pm.PackageManager
import com.example.hiltandroidapp.campussheba.ShebaViewModel
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat.startActivity
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
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
@Composable
fun ShebaCategoryList(viewModel: ShebaViewModel = hiltViewModel()) {
    // Collect data from the ViewModel

    val shebaData by remember {
        viewModel.shebaData
    }
    ShebaList(list = shebaData)
}

@Composable
fun ShebaList(list: List<ShebaCategory>) {
    LazyColumn {
        items(list) { category ->
            CategoryItem(category)
        }
    }
}

@Composable
fun CategoryItem(category: ShebaCategory, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Column(modifier = modifier) {
        category.imageUrl?.let {
            Image(
                painter = rememberAsyncImagePainter(model = it),
                contentDescription = null,
                modifier = Modifier
                    .padding(bottom = 10.dp)
                    .fillMaxWidth()
                    .height(200.dp),
                contentScale = ContentScale.Crop
            )
        }
        category.name?.let {
            Text(
                text = it, fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                modifier = modifier.padding(bottom = 5.dp)
            )
        }
        category.description?.let { Text(text = it) }
        Button(onClick = {
            val intent = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_EMAIL,arrayOf("msisakib958@gmail.com"))
                putExtra(Intent.EXTRA_SUBJECT,"This is my subject")
                putExtra(Intent.EXTRA_TEXT,"This is my content")
            }
            if (intent.resolveActivity(context.packageManager)!=null){
                startActivity(context,intent,null)
            }
        }) {
            Text(text = "click me")
        }
    }
}




@Preview(showBackground = true)
@Composable
fun CategoryPreview() {
    HiltAndroidAppTheme {
        CategoryItem(ShebaCategory())
    }
}