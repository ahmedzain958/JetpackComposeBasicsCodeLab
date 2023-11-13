package com.zainco.jetpackcomposebasicscodelab


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zainco.jetpackcomposebasicscodelab.compose_fns.RememberStateOFExampleScreen

class AhmedAzzActivity : ComponentActivity() {


    //Layout -> Row
    //Layout -> Column
    //Layout -> Box
    //Layout -> Surfaces
    //Layout -> Scaffold

    var i = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            /* Box(modifier = Modifier.fillMaxSize()) {

                 MySurface(modifier = Modifier.align(Alignment.Center))
             }
 */
//            RememberStateOFExampleScreen()
            //mutableStateOF
            /*var text by remember {
                mutableStateOf("")
            }
            LaunchedEffect(key1 = text*//*whenever this key is changed, the coroutine will be cancelled and re-launched *//*) {
                println("text is $text")
            }*/

            stateExample(Modifier.fillMaxSize())
        }
    }
}


// With using Weight
@Composable
fun RowScope.MyRow() {


    Text(
        modifier = Modifier.weight(1f),
        text = "One",
        style = TextStyle(background = Color.Yellow)
    )

    Text(
        modifier = Modifier.weight(1f),
        text = "Two",
        style = TextStyle(background = Color.Yellow)
    )

    Text(
        modifier = Modifier.weight(1f),
        text = "Three",
        style = TextStyle(background = Color.Yellow)
    )


}


@Composable
fun MyRow() {


    Row(
        modifier = Modifier
            .fillMaxSize(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) { // Linear layout - Horizontal
        Text(
            text = "One",
            fontSize = 22.sp
        )
        Text(
            text = "Two",
            fontSize = 22.sp
        )
        Text(
            text = "Three",
            fontSize = 22.sp
        )
    }


}


@Composable
fun MyColumn() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.Start,
    ) {

        Text(
            text = "Drawer Text One",

            fontSize = 22.sp
        )

        Text(
            text = "Drawer Text Two",

            fontSize = 22.sp
        )

        Text(
            text = "Drawer Text Three",

            fontSize = 22.sp
        )
    }

}


@Composable
fun MyBox(
    modifier: Modifier = Modifier,
    contentModifier: Modifier = Modifier,
) {

    Box(modifier = modifier.fillMaxSize()) {

        Text(
            modifier = contentModifier.align(Alignment.TopStart),
            text = "One",
            style = TextStyle(background = Color.Yellow),
            fontSize = 22.sp
        )

        Text(
            modifier = contentModifier.align(Alignment.Center),
            text = "Two",
            style = TextStyle(background = Color.Yellow),
            fontSize = 22.sp
        )


        Text(
            modifier = contentModifier.align(Alignment.BottomEnd),
            text = "Three",
            style = TextStyle(background = Color.Yellow),
            fontSize = 22.sp
        )

    }

}


@Composable
fun MySurface(modifier: Modifier) {

    Surface(
        modifier = modifier.size(200.dp),
        color = Color.LightGray,
        contentColor = colorResource(id = R.color.purple_700),
        border = BorderStroke(1.dp, color = Color.Yellow)
    ) {
        MyColumn()
    }
}
