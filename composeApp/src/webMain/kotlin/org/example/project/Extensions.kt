package org.example.project

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontFamily
import composeweb.composeapp.generated.resources.Res
import composeweb.composeapp.generated.resources.lato_bold
import composeweb.composeapp.generated.resources.regular
import org.jetbrains.compose.resources.Font
import kotlin.js.ExperimentalWasmJsInterop
import kotlin.js.js

@Composable
fun fontRegular(): FontFamily = FontFamily(Font(Res.font.regular))

@Composable
fun fontBold(): FontFamily = FontFamily(Font(Res.font.lato_bold))

@OptIn(ExperimentalWasmJsInterop::class)
fun openPlayStore() {
    js("window.open('https://play.google.com/store/apps/details?id=com.stiv_apps.applaunchkit', '_blank')")
}
