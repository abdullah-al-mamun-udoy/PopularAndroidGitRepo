import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay

@Composable
fun MarqueeText(
    text: String,
    fontSize: TextUnit = 14.sp,
    fontWeight: FontWeight = FontWeight.Normal,
    color: Color = Color.White,
    modifier: Modifier = Modifier
) {
    val scrollState = rememberScrollState()

    LaunchedEffect(Unit) {
        while (true) {
            scrollState.animateScrollTo(
                scrollState.maxValue,
                animationSpec = tween(durationMillis = 5000, easing = LinearEasing)
            )
            delay(1000) // Pause before looping back
            scrollState.animateScrollTo(
                0,
                animationSpec = tween(durationMillis = 5000, easing = LinearEasing)
            )
        }
    }

    Row(
        modifier = modifier.horizontalScroll(scrollState, reverseScrolling = false)
    ) {
        Text(
            text ="Name $text",
            fontSize = fontSize,
            fontWeight = fontWeight,
            color = color,
        )
    }
}
