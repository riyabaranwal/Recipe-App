package eu.tutorials.myrecipe

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.rememberAsyncImagePainter

//import androidx.compose.ui.graphics.Color



@Composable
fun RecipeScreen(modifier: Modifier = Modifier,
                 viewstate: MainViewModel.RecipeState,
                 navigateToDetail:(Category)->Unit ){

    Box(modifier = Modifier.fillMaxSize()){
        when{
            viewstate.loading ->{
                CircularProgressIndicator(progress = 0.89f, modifier.align(Alignment.Center))
               // CircularProgressIndicator(modifier.align(Alignment.Center))

            }
            viewstate.error != null ->{
                Text("ERROR OCCURED")
            }
            else ->{
                CategoryScreen(Categories = viewstate.list ,navigateToDetail)
            }
        }
    }

}
@Composable
fun CategoryScreen(Categories: List<Category>,
                   navigateToDetail:(Category)->Unit){
    LazyVerticalGrid(GridCells.Fixed(2),modifier = Modifier.fillMaxSize()){
            items(Categories) {
                Category ->
                CategoryItem(category = Category,navigateToDetail)
            }
    }
}
@Composable
fun CategoryItem(category: Category,
                 navigateToDetail:(Category)->Unit){
    Column(modifier = Modifier
        .padding(8.dp)
        .fillMaxSize().clickable{navigateToDetail(category)}, horizontalAlignment = Alignment.CenterHorizontally) {
        //image aur text waala part kisi bhi jagh picture aur mae likhna hoga toh same hoga
        Image(
            painter = rememberAsyncImagePainter(category.strCategoryThumb),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .aspectRatio(1f)//pic jitna upar hoga utna hi wide rhega
        )
        Text(
            text = category.strCategory,
            color= Color.Black,//text black color mein ho jaayega
            style = TextStyle(fontWeight = FontWeight.Bold),//text bold ho jaayega
            modifier = Modifier.padding(top = 4.dp)//text ke upar picture rhega isliye top ka size 4.dp neeche h
        )

    }
}





