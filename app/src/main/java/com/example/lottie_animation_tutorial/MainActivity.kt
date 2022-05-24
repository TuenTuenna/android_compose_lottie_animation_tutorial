package com.example.lottie_animation_tutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.*
import com.example.lottie_animation_tutorial.ui.theme.Lottie_animation_tutorialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lottie_animation_tutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Box (
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.TopCenter
                    ) {
                        HeartBGAnimation()
                        Loader()
                    }
                }
            }
        }
    }
}

@Composable
fun HeartBGAnimation(){
    val composition by rememberLottieComposition(
        LottieCompositionSpec.Url("https://assets4.lottiefiles.com/packages/lf20_dvmiho7v.json")
    )
    // 로띠 애니메이션 설정
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever
    )
    LottieAnimation(
        composition,
        progress,
        modifier = Modifier
//              .fillMaxSize()
            .fillMaxWidth(fraction = 0.8f)
            .height(300.dp)
//            .background(Color.Yellow)
    )
}

@Composable
fun Loader() {

    // 로띠 제이슨 파일 가져오기
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("dev_jeong.json"))

    var isAnimationPlaying by remember { mutableStateOf(true) }

//    composition: LottieComposition?,
//    isPlaying: Boolean = true,
//    restartOnPlay: Boolean = true,
//    clipSpec: LottieClipSpec? = null,
//    speed: Float = 1f,
//    iterations: Int = 1,
//    cancellationBehavior: LottieCancellationBehavior = LottieCancellationBehavior.Immediately,
//    ignoreSystemAnimatorScale: Boolean = false,

    // 로띠 애니메이션 설정
    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        clipSpec = LottieClipSpec.Progress(0f, 0.6f),
        isPlaying = isAnimationPlaying
    )

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        // 로띠 애니메이션 뷰
        LottieAnimation(
            composition,
            progress,
            modifier = Modifier
                .size(300.dp)
//                .background(Color.Yellow)
        )

//        Text("progress : $progress")
//
//        Button(onClick = {
//            isAnimationPlaying = !isAnimationPlaying
//        }) {
//            Text(text = "로띠 재생/일시정지")
//        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Lottie_animation_tutorialTheme {
        Greeting("Android")
    }
}
