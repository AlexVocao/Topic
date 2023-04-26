package com.example.topic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardElevation
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.courses.R
import com.example.topic.data.DataSource
import com.example.topic.model.Topic
import com.example.topic.ui.theme.TopicTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopicTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    TopicCardList(DataSource.topics)
                }
            }
        }
    }
}


@Composable
fun TopicCardList(topicList: List<Topic>) {
    LazyColumn {
        items(topicList) {item ->
            TopicCard(topic = item)
        }
    }
}

@Composable
fun TopicCard(topic: Topic, modifier: Modifier = Modifier) {
    Card(modifier = Modifier.padding(8.dp).fillMaxWidth()) {
        Row(modifier = Modifier.wrapContentWidth()) {
            Image(
                painter = painterResource(id = topic.imageResourceId),
                contentDescription = stringResource(id = topic.stringResourceId),
                //modifier = Modifier.fillMaxHeight()
            )
            Column {
                Text(text = stringResource(id = topic.stringResourceId),
                    modifier = Modifier.padding(8.dp)
                )
                Text(text = "${topic.numberViews}",
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}

@Composable
@Preview
fun TopicCardPreview() {
    TopicTheme {
        TopicCard(Topic(R.string.architecture, 152, R.drawable.architecture))
    }
}