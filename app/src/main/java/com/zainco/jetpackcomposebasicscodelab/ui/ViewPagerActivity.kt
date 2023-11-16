package com.zainco.jetpackcomposebasicscodelab.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zainco.jetpackcomposebasicscodelab.R
import com.zainco.jetpackcomposebasicscodelab.compose_fns.ui.theme.JetpackComposeBasicsCodeLabTheme
import kotlin.random.Random

class ViewPagerActivity : ComponentActivity(){
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeBasicsCodeLabTheme {
                val pagerState = rememberPagerState(
                    initialPage = 1,
                    initialPageOffsetFraction = 0.5f
                ) {
                    4
                }
                HorizontalPager(
                    state = pagerState,
                    pageSize = PageSize.Fixed(300.dp)
                ) { pageIndex ->
                    Box(
                        modifier = Modifier
                            .padding(20.dp)
                            .background(
                                color = Color(1f, 1f, 1f, 1f)
                            )
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "$pageIndex", style = MaterialTheme.typography.titleLarge)
                    }
                }
            }
        }
    }
}