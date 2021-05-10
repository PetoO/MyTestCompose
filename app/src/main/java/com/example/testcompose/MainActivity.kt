package com.example.testcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigate
import androidx.navigation.compose.rememberNavController
import com.example.testcompose.ui.theme.TestComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TestComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    HomeScreen()
                }
            }
        }
    }
}
@Composable
fun HomeScreen() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = "home") {
        composable("home") { Home("Android", navController) }
        composable("profile") { Profile() }
        composable("friendslist") { FriendsList() }
    }
}

@Composable
fun Profile() {
    Text(text = "Profile Page")
}

@Composable
fun FriendsList() {
    Text(text = "Friends List ")
}
@Composable
fun Home(name: String, navController: NavHostController) {
    Column() {
        Text(text = "Profile", Modifier.clickable { navController.navigate("profile") })
        Text(text = "FriendsList", Modifier.clickable { navController.navigate("friendslist") })
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val navController = rememberNavController()
    TestComposeTheme {
        Home("Android", navController)
    }
}


