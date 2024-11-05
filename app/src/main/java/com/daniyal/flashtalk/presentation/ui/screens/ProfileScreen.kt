package com.daniyal.flashtalk.presentation.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Menu
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniyal.flashtalk.R
import com.daniyal.flashtalk.data.singleUser
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily
import com.daniyal.flashtalk.presentation.ui.components.common.CircularImage
import com.daniyal.flashtalk.presentation.viewmodels.ProfileViewModel


@Composable

fun ProfileScreen(viewModel: ProfileViewModel) {
    val user = viewModel.loggedUser.collectAsState().value

    Surface(modifier = Modifier.fillMaxSize(1F), color = MaterialTheme.colorScheme.tertiary) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.35F)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 40.dp),
            ) {
                Icon(
                    Icons.Filled.ArrowBackIosNew,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.secondary,
                )
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    user.image?.let {
                        CircularImage(
                            modifier = Modifier
                                .size(80.dp),
                            resourceId = it
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        user.fullName,
                        color = MaterialTheme.colorScheme.secondary,
                        fontFamily = CarosFontFamily,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        user.email,
                        color = MaterialTheme.colorScheme.inversePrimary,
                        fontFamily = CarosFontFamily,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Normal
                    )
                    Spacer(modifier = Modifier.size(10.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(50)
                                )
                                .background(MaterialTheme.colorScheme.outlineVariant)
                                .padding(20.dp)
                        ) {
                            Icon(
                                Icons.Filled.Chat,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(26.dp)
                            )
                        }
                        Spacer(modifier = Modifier.size(20.dp))
                        Box(
                            modifier = Modifier
                                .clip(
                                    RoundedCornerShape(50)
                                )
                                .background(MaterialTheme.colorScheme.outlineVariant)
                                .padding(20.dp)
                        ) {
                            Icon(
                                Icons.Outlined.Menu,
                                contentDescription = "",
                                tint = MaterialTheme.colorScheme.secondary,
                                modifier = Modifier.size(26.dp)
                            )
                        }
                    }
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .clip(shape = RoundedCornerShape(45.dp, 45.dp, 0.dp, 0.dp))
                    .background(MaterialTheme.colorScheme.secondary)

            ) {
//                Handle
                Spacer(modifier = Modifier.height(15.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Box(
                        modifier = Modifier
                            .height(5.dp)
                            .width(60.dp)
                            .clip(RoundedCornerShape(3.dp))
                            .background(MaterialTheme.colorScheme.outline)
                    )
                }
                Spacer(modifier = Modifier.height(30.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp),
                    verticalArrangement = Arrangement.spacedBy(15.dp)
                )
                {
                    Field(key = "Display Name", value = "Daniyal Shah")
                    Field(key = "Email Address", value = "daniyal.shah.cs@gmail.com")
                    Field(key = "Address", value = "Pir-jo-goth, Sindh, Pakistan")
                    Field(key = "Phone Number", value = "+923063350899")
                    MediaShared()
                }
            }
        }
    }
}

@Composable
fun Field(key: String, value: String) {
    Column {
        Text(
            key,
            color = MaterialTheme.colorScheme.inversePrimary,
            fontFamily = CarosFontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        Text(
            value,
            color = MaterialTheme.colorScheme.tertiary,
            fontFamily = CarosFontFamily,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium
        )
    }
}


@Composable
fun MediaShared() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            "Media Shared",
            color = MaterialTheme.colorScheme.inversePrimary,
            fontFamily = CarosFontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
            Image(
                painter = painterResource(R.drawable.person5),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
            )
            Image(
                painter = painterResource(R.drawable.person4),
                contentDescription = "",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
            )


            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(16.dp))
            ) {
                Image(
                    painter = painterResource(R.drawable.person1),
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()

                )
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.65f)) // Adjust alpha for transparency
                )
                // Text over the image
                Text(
                    text = "255+",
                    fontFamily = CarosFontFamily,
                    color = MaterialTheme.colorScheme.secondary,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .align(Alignment.Center) // Center the text
                        .padding(16.dp) // Optional padding
                )
            }

        }
    }
}