package com.ps.swiggyclonenew.ui.lottieanim

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.ps.swiggyclonenew.R

@Composable
fun YummyAnim(
    modifier: Modifier
){
    val lottieComposition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.yummy)
    )
    LottieAnimation(
        modifier = modifier,
        composition = lottieComposition
    )
}