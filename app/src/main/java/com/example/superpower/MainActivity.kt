package com.example.superpower

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.superpower.ui.theme.Green
import com.example.superpower.ui.theme.SuperpowerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.statusBarColor = 0xFF008000.toInt()
        setContent {

            val word = remember {
                mutableStateOf("")
            }
            val numberOfLetters = remember {
                mutableStateOf(0)
            }
            SuperpowerTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    Row(
                        modifier = Modifier.padding(top = 10.dp),
                        verticalAlignment = Alignment.Top,
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            text = "Powered by TM\u2122",
                            color = Green,
                        )
                    }
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Top,
                    ) {
                        Spacer(modifier = Modifier.padding(50.dp))
                        TextField(
                            value = word.value,
                            label = {
                                Text(text = "word")
                            },
                            onValueChange = {
                                word.value = it
                            },
                        )
                        Row {
                            Button(
                                onClick = {
                                    word.value = ""
                                    numberOfLetters.value = 0
                                },
                                modifier = Modifier.width(135.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.LightGray,
                                    contentColor = Green,
                                ),
                            ) {
                                Text(text = "Reset")
                            }
                            Spacer(modifier = Modifier.padding(5.dp))
                            Button(
                                onClick = { numberOfLetters.value = countLetters(word.value) },
                                modifier = Modifier.width(135.dp),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Green,
                                    contentColor = Color.White,
                                ),
                            ) {
                                Text(text = "Count")
                            }
                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        AnimatedVisibility(visible = numberOfLetters.value != 0) {
                            Text(
                                text = numberOfLetters.value.toString(),
                                fontSize = 175.sp,
                                color = Green,
                            )
                        }
                    }
                }
            }
        }
    }
}

private fun countLetters(word: String): Int {
    val wordWithoutSpace = word
        .replace(" ", "")
        .replace("'", "")
    return wordWithoutSpace.length
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SuperpowerTheme {
    }
}
