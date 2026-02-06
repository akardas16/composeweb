package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource

import composeweb.composeapp.generated.resources.Res
import composeweb.composeapp.generated.resources.compose_multiplatform
import composeweb.composeapp.generated.resources.img
import composeweb.composeapp.generated.resources.img_2
import composeweb.composeapp.generated.resources.img_3
import composeweb.composeapp.generated.resources.play
import composeweb.composeapp.generated.resources.play_store
import kotlinx.coroutines.delay

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        var count by remember { mutableStateOf(0)}

        LaunchedEffect(count){
            delay(1000)
            count++
        }
        Column(
            modifier = Modifier
                .background(Color(0xFF070A2F))
                .safeContentPadding()
                .fillMaxSize().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(32.dp,
                Alignment.CenterVertically)
        ) {

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(16.dp,
                Alignment.CenterHorizontally), modifier = Modifier.padding(vertical = 32.dp)){

                Image(painterResource(Res.drawable.img), null, modifier = Modifier.size(52.dp).clip(
                    RoundedCornerShape(16.dp)
                ))
                Text(
                    buildAnnotatedString {
                        withStyle(style = SpanStyle(color = Color.White, fontFamily = fontRegular())) {
                            append("Social Creatives")
                        }
                        withStyle(style = SpanStyle(color = Color(0xFFDE5589), fontFamily = fontRegular())) {
                            append(" Kit")
                        }
                    }, fontSize = 25.sp, modifier = Modifier
                )
            }

            Text(
                buildAnnotatedString {
                    withStyle(style = SpanStyle(color = Color.White, fontFamily = fontBold())) {
                        append("Stunning App Mockups and\nVisuals for Social Media")
                    }
                    withStyle(style = SpanStyle(color = Color(0xFFDE5589), fontFamily = fontBold())) {
                        append("\nPromotions.")
                    }
                }, fontSize = 64.sp, lineHeight = 64.sp, modifier = Modifier, textAlign = TextAlign.Center
            )

            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(32.dp,
                Alignment.CenterHorizontally)){
                var isHovered by remember { mutableStateOf(false) }
                val scale by animateFloatAsState(
                    targetValue = if (isHovered) 1.1f else 1.0f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )

                var isHovered2 by remember { mutableStateOf(false) }
                val scale2 by animateFloatAsState(
                    targetValue = if (isHovered2) 1.1f else 1.0f,
                    animationSpec = spring(
                        dampingRatio = Spring.DampingRatioMediumBouncy,
                        stiffness = Spring.StiffnessLow
                    )
                )
                Image(
                    painterResource(Res.drawable.play_store),
                    null,
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .height(52.dp)
                        .aspectRatio(3f)
                        .scale(scale)
                        .pointerHoverIcon(PointerIcon.Hand)
                        .pointerInput(Unit) {
                            awaitPointerEventScope {
                                while (true) {
                                    val event = awaitPointerEvent()
                                    when (event.type) {
                                        PointerEventType.Enter -> isHovered = true
                                        PointerEventType.Exit -> isHovered = false
                                    }
                                }
                            }
                        }.clickable{
                            openPlayStore()
                        }
                )
                Image(
                    painterResource(Res.drawable.img_3),
                    null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(52.dp)
                        .scale(scale2)
                        .pointerHoverIcon(PointerIcon.Hand)
                        .pointerInput(Unit) {
                            awaitPointerEventScope {
                                while (true) {
                                    val event = awaitPointerEvent()
                                    when (event.type) {
                                        PointerEventType.Enter -> isHovered2 = true
                                        PointerEventType.Exit -> isHovered2 = false
                                    }
                                }
                            }
                        }
                )


            }
           
            Button(onClick = { showContent = !showContent }) {
                Text("Click me!")
            }
            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}
