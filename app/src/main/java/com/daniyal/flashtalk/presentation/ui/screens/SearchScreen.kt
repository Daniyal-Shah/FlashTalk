package com.daniyal.flashtalk.presentation.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.presentation.ui.components.common.CircularImage
import com.daniyal.flashtalk.presentation.ui.components.common.SearchBar
import com.daniyal.flashtalk.R
import com.daniyal.flashtalk.presentation.ui.components.common.IndeterminateCircularSpinner
import com.daniyal.flashtalk.presentation.viewmodels.SearchViewModel

@Composable
fun SearchScreen(viewModel: SearchViewModel, onBackPress: () -> Unit) {

    val contacts = viewModel.contacts.collectAsState()
    val contactsLoading = viewModel.contactsLoading.collectAsState()
    val search = remember { mutableStateOf("Search") }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(top = 40.dp)
                .padding(horizontal = 20.dp)

        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Icon(
                    Icons.Filled.ArrowBackIosNew,
                    contentDescription = "",
                    tint = MaterialTheme.colorScheme.tertiary,
                    modifier = Modifier.clickable { onBackPress() }
                )

                SearchBar(
                    value = search.value,
                    onChange = {
                        search.value = it
                    }
                )
            }

            if (contactsLoading.value) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IndeterminateCircularSpinner(
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
            LazyColumn() {
                items(
                    if (search.value == "Search")
                        contacts.value
                    else
                        contacts.value.filter {
                            it.fullName.lowercase().startsWith(search.value.lowercase())
                        }
                ) {
                    it.image?.let { it1 ->
                        Spacer(modifier = Modifier.height(20.dp))
//                        CircularImage(
//                            Modifier.size(80.dp),
//                            it1,
//                            it.fullName,
//                            "Keep working ✍",
//                        )
                    }
                }

            }
        }
    }
}
