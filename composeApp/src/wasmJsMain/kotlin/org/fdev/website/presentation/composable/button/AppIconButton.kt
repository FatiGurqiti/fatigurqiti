package org.fdev.website.presentation.composable.button

import androidx.compose.foundation.Image
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.unit.dp

@Composable
fun AppImageButton(
    modifier: Modifier = Modifier,
    shape: Shape = RoundedCornerShape(22.dp),
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = Color.White),
    iconModifier: Modifier = Modifier,
    painter: Painter,
    contentDescription: String,
    onClick: () -> Unit,
) {
    Button(
        modifier = modifier.pointerHoverIcon(PointerIcon.Hand),
        colors = colors,
        shape = shape,
        onClick = onClick,
    ) {
        Image(
            modifier = iconModifier,
            painter = painter,
            contentDescription = contentDescription
        )
    }
}