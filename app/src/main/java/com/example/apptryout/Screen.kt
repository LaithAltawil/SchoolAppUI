package com.example.apptryout

sealed class Screen(val route:String){
    object SignIn: Screen("SignInPage")
    object Home: Screen("MainMenu")
    object ForgotPassword: Screen("ForgotPasswordPage")
    object ProfilePage:Screen("ProfilePage")
    object ExamsPage:Screen("ExamsPage")
    object Homeworks:Screen("Homeworks")
    object ConselorReq:Screen("ConselorReq")
    object ResourcesPage:Screen("ResourcesPage")
    object CalenderPage:Screen("Calender Page")
}