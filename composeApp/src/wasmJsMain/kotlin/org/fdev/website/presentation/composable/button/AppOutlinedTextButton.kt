package org.fdev.website.presentation.composable.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.pointer.PointerIcon
import androidx.compose.ui.input.pointer.pointerHoverIcon
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.fdev.website.presentation.composable.text.AppText

@Composable
fun AppOutlinedTextButton(
    modifier: Modifier = Modifier,
    text: String,
    textColor: Color = MaterialTheme.colorScheme.secondary,
    style: TextStyle = MaterialTheme.typography.bodyMedium,
    textAlign: TextAlign = TextAlign.Start,
    error: Boolean = false,
    onClick: () -> (Unit),
    trailingIcon: ImageVector? = null,
    borderShape: Shape = RoundedCornerShape(22.dp),
    borderColor: Color = MaterialTheme.colorScheme.onPrimary
) {
    val defaultBorderColor = if (error) MaterialTheme.colorScheme.error
    else borderColor

    OutlinedButton(
        modifier = modifier.pointerHoverIcon(PointerIcon.Hand),
        border = BorderStroke(width = 1.dp, color = defaultBorderColor),
        shape = borderShape,
        onClick = onClick
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            AppText(
                modifier = Modifier.fillMaxWidth(if (trailingIcon == null) 1f else 0.8f),
                text = text,
                style = style,
                textColor = textColor,
                textAlign = textAlign
            )

            trailingIcon?.let {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.End,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = it,
                        contentDescription = null,
                        tint = textColor
                    )
                }
            }
        }
    }
}