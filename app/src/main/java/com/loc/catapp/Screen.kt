package com.loc.catapp

sealed class Screen(val route: String) {
    object CatList : Screen("cat_list")
    object CatDetail : Screen("cat_detail/{catId}") {
        fun createRoute(catId: String) = "cat_detail/$catId"
    }
}

