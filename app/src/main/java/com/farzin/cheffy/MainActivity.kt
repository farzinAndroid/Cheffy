package com.farzin.cheffy

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.farzin.cheffy.navigation.BottomNavigationBar
import com.farzin.cheffy.navigation.NavGraph
import com.farzin.cheffy.navigation.Screens
import com.farzin.cheffy.ui.components.ChangeStatusBarColor
import com.farzin.cheffy.ui.theme.CheffyTheme
import com.farzin.cheffy.viewmodel.DataStoreViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CheffyTheme {

                val navController = rememberNavController()
                val dataStoreViewModel: DataStoreViewModel = viewModel()


                ChangeStatusBarColor(navController)


                Scaffold(
                    bottomBar = {
                        BottomNavigationBar(
                            onClick = {
                                navController.navigate(it.route)
                            },
                            navController = navController
                        )
                    },
                    content = {
                        NavGraph(
                            navController = navController,
                            startDestination = getStartingRoute(dataStoreViewModel)
                        )
                    }
                )

            }
        }
    }
}

private fun getStartingRoute(vm: DataStoreViewModel): String {

    return if (vm.getOnBoardingState() == true) {
        Screens.Home.route
    } else {
        Screens.Welcome.route
    }

}

