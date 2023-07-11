package com.farzin.cheffy.navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.farzin.cheffy.R
import com.farzin.cheffy.ui.theme.bottomBarColor
import com.farzin.cheffy.ui.theme.bottomItemColor
import com.farzin.cheffy.ui.theme.mainGreen

@SuppressLint("SuspiciousIndentation")
@Composable
fun BottomNavigationBar(
    onClick:(BottomNavItem)->Unit,
    navController: NavHostController,
) {


    val bottomBarList = listOf(
        BottomNavItem(
            route = Screens.Home.route,
            deselectedIcon = painterResource(R.drawable.unselected_home),
            selectedIcon = painterResource(R.drawable.selected_home),
        ),
        BottomNavItem(
            route = Screens.Fridge.route,
            deselectedIcon = painterResource(R.drawable.unselected_refrigeretor),
            selectedIcon = painterResource(R.drawable.selected_refrigeretor)
        ),
        BottomNavItem(
            route = Screens.Search.route,
            deselectedIcon = painterResource(R.drawable.unselected_search),
            selectedIcon = painterResource(R.drawable.selected_search)
        ),
        BottomNavItem(
            route = Screens.Save.route,
            deselectedIcon = painterResource(R.drawable.unselected_saved),
            selectedIcon = painterResource(R.drawable.selected_saved)
        ),
    )

    val backStack = navController.currentBackStackEntryAsState()
    val showBottomBar = backStack.value?.destination?.route in bottomBarList.map { it.route }

    if (showBottomBar){

        BottomAppBar(
            modifier = Modifier
                .padding(horizontal = 16.dp)
                .clip(Shapes().medium)
                .fillMaxWidth()
                .height(40.dp),
            containerColor = MaterialTheme.colorScheme.bottomBarColor
        ) {

            bottomBarList.forEachIndexed { index, bottomNavItem ->
            val selected = bottomNavItem.route == backStack.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onClick(bottomNavItem) },
                    icon = {

                        Icon(
                            painter = if (selected) bottomNavItem.selectedIcon else bottomNavItem.deselectedIcon,
                            contentDescription ="",
                            modifier = Modifier
                                .size(24.dp),
                            tint = MaterialTheme.colorScheme.bottomItemColor
                        )

                    }
                )
            }

        }

    }


}