package com.farzin.cheffy.ui.screens.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.farzin.cheffy.R
import com.farzin.cheffy.ui.theme.onBoarding
import com.farzin.cheffy.ui.theme.onBoardingButton
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.HorizontalPagerIndicator
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoardingScreen(
    onClick:()->Unit
) {




    val pagerState = rememberPagerState()

    val pages = listOf(
        Page(
            title = stringResource(R.string.mix),
            description = stringResource(R.string.mix_sub),
            image = if (isSystemInDarkTheme()) painterResource(R.drawable.mix_dark)
            else painterResource(R.drawable.cook_dark)
        ),

        Page(
            title = stringResource(R.string.add_flavor),
            description = stringResource(R.string.add_flavor_sub),
            image = if (isSystemInDarkTheme()) painterResource(R.drawable.cook_dark)
            else painterResource(R.drawable.cook_light)
        ),


        Page(
            title = stringResource(R.string.chefpic),
            description = stringResource(R.string.chefpic_sub),
            image = if (isSystemInDarkTheme()) painterResource(R.drawable.chef_dark)
            else painterResource(R.drawable.chef_light)
        ),


    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.onBoarding),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        HorizontalPager(
            count = pages.size,
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f),
            state = pagerState
        ) {index->
            OnBoarding(page = pages[index])
        }

        HorizontalPagerIndicator(
            pagerState = pagerState,
            pageCount = pages.size,
            modifier = Modifier
                .weight(0.1f)
                .padding(16.dp)
        )


        AnimatedVisibility(
            visible = pagerState.currentPage == 2
        ) {

            Button(
                onClick = { onClick() },
                modifier = Modifier
                    .weight(0.1f)
                    .padding(16.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.onBoardingButton,
                )
            ) {
                Text(text = stringResource(R.string.lets_get_started))
            }

        }

    }



}


@OptIn(ExperimentalPagerApi::class)
@Composable
fun OnBoarding(page: Page) {



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {


            Image(
                painter = page.image,
                contentDescription = "",
                modifier = Modifier
                    .size(300.dp)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = page.title,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold,
                    textAlign = TextAlign.Center
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            Text(
                text = page.description,
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyLarge.fontSize,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center
                )
            )




    }

}