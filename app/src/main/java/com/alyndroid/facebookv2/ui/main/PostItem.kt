package com.alyndroid.facebookv2.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.alyndroid.facebookv2.pojo.PostModel

@Composable
fun PostItem(postModel: PostModel) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = postModel.title ?: "",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 16.dp, top = 16.dp)
            )
            Text(
                text = postModel.userId.toString(),
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 16.dp)
            )
            Text(
                text = postModel.body ?: "",
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(top = 44.dp)
            )
        }
    }
}
