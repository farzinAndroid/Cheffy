package com.farzin.cheffy.navigation

open class Screens(val route:String) {

    object Welcome :Screens(route = "welcome_screen")
    object Home :Screens(route = "home_screen")
    object Save :Screens(route = "save_screen")
    object Search :Screens(route = "search_screen")
    object Fridge :Screens(route = "fridge_screen")

}