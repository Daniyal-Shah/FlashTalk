package com.daniyal.flashtalk.presentation.ui.screens

import android.util.Log
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.daniyal.flashtalk.R
import com.daniyal.flashtalk.presentation.theme.CarosFontFamily
import com.daniyal.flashtalk.presentation.ui.components.chat.ChatList
import com.daniyal.flashtalk.presentation.ui.components.common.CircularImage
import com.daniyal.flashtalk.presentation.ui.components.common.IndeterminateCircularSpinner
import com.daniyal.flashtalk.presentation.ui.components.home.Header
import com.daniyal.flashtalk.presentation.viewmodels.ContactViewModel

@Composable
fun ContactsScreen(viewModel: ContactViewModel) {
    val contacts = viewModel.contacts.collectAsState()
    val contactLoading = viewModel.contactsLoading.collectAsState()
    val lastAlphabet = remember { mutableStateOf('A') }

    Surface(modifier = Modifier.fillMaxSize(1F), color = MaterialTheme.colorScheme.tertiary) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.16F)
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(top = 40.dp)
            ) {
                Header(
                    title = "Contacts",
                    leftIcon = Icons.Filled.Search,
                    imageContentDescription = null,
                    rightIcon = Icons.Outlined.Add,
                    onPressUserImage = {
                    },
                    onPressLeftIcon = {
                    }
                )

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
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 30.dp),
                    verticalArrangement = Arrangement.spacedBy(20.dp)
                )
                {
                    Text(
                        "My Contact",
                        fontFamily = CarosFontFamily,
                        fontWeight = FontWeight.Medium,
                        fontSize = 17.sp,
                        color = MaterialTheme.colorScheme.tertiary
                    )

                    if (contactLoading.value) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {
                            IndeterminateCircularSpinner(
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                    LazyColumn() {
                        items(contacts.value.sortedBy { it.fullName }) {
                            it.image?.let { it1 ->
                                Text(
                                    it.fullName[0].toString(), fontFamily = CarosFontFamily,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 17.sp,
                                    color = MaterialTheme.colorScheme.tertiary
                                )
                                Spacer(modifier = Modifier.height(10.dp))
//                                CircularImage(
//                                    Modifier.size(55.dp),
//                                    it1,
//                                    it.fullName,
//                                    "Keep working ✍",
//                                )
                                Spacer(modifier = Modifier.height(20.dp))
                            }
                        }
                    }
                }
            }
        }
    }
}