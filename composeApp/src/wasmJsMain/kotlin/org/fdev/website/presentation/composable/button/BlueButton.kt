package org.fdev.website.presentation.composable.button

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.fdev.website.presentation.composable.text.AppText
import org.fdev.website.presentation.theme.lightBlue

@Composable
fun BlueButton(
    modifier: Modifier = Modifier,
    text: String,
    shape: Shape = RoundedCornerShape(22.dp),
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.pointerHoverIcon(PointerIcon.Hand),
        colors = ButtonDefaults.buttonColors(containerColor = lightBlue),
        shape = shape,
        enabled = enabled,
        onClick = onClick
    ) {
        AppText(
            text = text,
            style = MaterialTheme.typography.titleMedium,
            textAlign = TextAlign.Center,
            textColor = Color.White,
        )
    }
}