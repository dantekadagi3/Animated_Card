package com.example.animatedcard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.animatedcard.ui.theme.AnimatedCardTheme
import com.example.animatedcard.ui.theme.mutedBlack

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AnimatedCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                     myCustomCard()
                }
            }
        }
    }
}

@Composable
fun myCustomCard() {

    Card (
        modifier = Modifier,
        shape = MaterialTheme.shapes.medium,
        colors=CardDefaults.cardColors(
            containerColor = mutedBlack
        )

    ){
Column(

) {
    Image(
        modifier= Modifier
            .fillMaxWidth()
            .height(200.dp),
        painter = painterResource(id =R.drawable.main ),
        contentDescription =null ,
        contentScale = ContentScale.Crop)

    Column(modifier=Modifier.padding(vertical = 20.dp, horizontal = 15.dp)){
        Text("Elephants",
          color= Color.White,
            fontSize = 22.sp,
            fontWeight = FontWeight.Medium)

        Spacer(modifier=Modifier.height(16.dp))

        Text(text= stringResource(id = R.string.about),
            color= Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Medium)

        Spacer(modifier=Modifier.height(16.dp))

        Row {
           Image(
               modifier= Modifier
                   .size(42.dp)
                   .clip(CircleShape),
               painter = painterResource(id = R.drawable.elephant),
               contentDescription = "")

            Spacer(modifier=Modifier.height(16.dp))
            val annotatedString= buildAnnotatedString {
                withStyle(
                    style= SpanStyle(
                        color=Color.White,
                        fontSize = 18.sp
                    )){
                        append()
                    }

            }
        }

    }

}
    }
}

@Preview(showSystemUi = true)
@Composable
fun cardPreview() {
    myCustomCard()

}