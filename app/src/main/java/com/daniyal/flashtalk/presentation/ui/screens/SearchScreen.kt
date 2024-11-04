package com.daniyal.flashtalk.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.daniyal.flashtalk.presentation.ui.components.common.CircularImage
import com.daniyal.flashtalk.presentation.ui.components.common.SearchBar
import com.daniyal.flashtalk.R
import com.daniyal.flashtalk.data.allUsers
import com.daniyal.flashtalk.data.singleUser

@Composable
@Preview
fun SearchScreen() {
    Surface(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .padding(top = 40.dp)
                .padding(horizontal = 20.dp)

        ) {
            SearchBar()
            LazyColumn() {
                items(allUsers) {
                    it.image?.let { it1 ->
                        Spacer(modifier = Modifier.height(20.dp))
                        CircularImage(
                            Modifier.size(80.dp),
                            it1,
                            it.fullName,
                            "Keep working ✍",
                        )
                    }
                }
            }
        }
    }
}
