package org.fdev.website.presentation.screen.about.composable

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.fdev.website.presentation.composable.button.AppOutlinedTextButton
import org.fdev.website.presentation.composable.text.AppText
import org.fdev.website.presentation.theme.deepPurple

@Composable
fun StillHere(
    onMyWorkClicked: () -> Unit,
    onLetsTalkClicked: () -> Unit,
    style: TextStyle,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(22.dp)
    ) {
        AppText(
            text = "Still here?",
            style = style
        )

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
//            AppOutlinedTextButton(  TODO("To be added")
//                modifier = Modifier.width(150.dp).height(50.dp),
//                onClick = onMyWorkClicked,
//                text = "My Work",
//                borderColor = darkerBlue,
//                textAlign = TextAlign.Center
//            )
//
//            Spacer(Modifier.size(22.dp))

            AppOutlinedTextButton(
                modifier = Modifier.width(150.dp).height(50.dp),
                onClick = onLetsTalkClicked,
                text = "Let's talk",
                borderColor = deepPurple,
                textAlign = TextAlign.Center
            )
        }
    }
}