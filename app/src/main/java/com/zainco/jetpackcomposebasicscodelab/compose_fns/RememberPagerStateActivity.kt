package com.zainco.jetpackcomposebasicscodelab.compose_fns

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PageSize
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.zainco.jetpackcomposebasicscodelab.compose_fns.ui.theme.JetpackComposeBasicsCodeLabTheme
import com.zainco.jetpackcomposebasicscodelab.R

class RememberPagerStateActivity : ComponentActivity() {
    @OptIn(ExperimentalFoundationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val animals = listOf(
            R.drawable.cat,
            R.drawable.dog,
            R.drawable.chicken,
        )
        setContent {
            JetpackComposeBasicsCodeLabTheme {
                val pagerState = rememberPagerState(
                    initialPage = 1,
                    initialPageOffsetFraction = 0.5f
                ) {
                    animals.size
                }
                Box(modifier = Modifier.fillMaxSize()) {
                    HorizontalPager(/*won't compose all pages, but only pages that are visible*/
                        state = pagerState,
                        key = { animals[it] },
                        pageSize = PageSize.Fixed(300.dp)
                    ) { index ->
                        Image(
                            painter = painterResource(id = animals[index]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }
            }
        }
    }
}