package com.daniyal.flashtalk.presentation.ui.components.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily


enum class DotType(val value: String) {
    ACTIVE("ACTIVE"),
    INACTIVE("INACTIVE")
}


@Composable
fun CircularImage(
    modifier: Modifier,
    uri: String? = null,
    userName: String? = null,
    userBio: String? = null,
    outerModifier: Modifier? = null,
    dotType: DotType? = null,
    resourceId: Int? = null
) {
    Row(modifier = outerModifier ?: Modifier, verticalAlignment = Alignment.CenterVertically) {
        Box(
            contentAlignment = Alignment.BottomEnd
        ) {

            if (resourceId != null)
                Image(
                    painter = painterResource(resourceId),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = modifier.clip(CircleShape)
                )

            if (uri != null)
                Image(
                    painter = rememberAsyncImagePainter(uri),
                    contentDescription = "avatar",
                    contentScale = ContentScale.Crop,
                    modifier = modifier.clip(CircleShape)
                )
            if (dotType != null) {
                Row {
                    Box(
                        modifier = Modifier
                            .size(10.dp)
                            .background(
                                if (dotType == DotType.ACTIVE) {
                                    MaterialTheme.colorScheme.primaryContainer
                                } else {
                                    MaterialTheme.colorScheme.outline
                                }, shape = CircleShape
                            )
                    )
                    Spacer(
                        modifier = Modifier
                            .height(20.dp)
                            .width(0.dp)
                    )
                }
            }
        }
        if (userName != null && userBio != null) {
            if (userName.isNotEmpty() && userBio.isNotEmpty()) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 15.dp, end = 5.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            userName,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            userBio,
                            fontFamily = CarosFontFamily,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.Normal,
                            color = MaterialTheme.colorScheme.inversePrimary
                        )
                    }
                }
            }
        }
    }
}