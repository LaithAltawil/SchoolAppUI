package Navigation

import Screen.Forgotpassword
import Screen.MainMenu
import Screen.ProfilePage
import Screen.SignInPage
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.apptryout.Screen


@Composable
fun Navigation(
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.SignIn.route) {
        composable(Screen.SignIn.route) {
            SignInPage(OnNavigateToHome = { navController.navigate(Screen.Home.route) },
                OnNavigateToForgotPassword = { navController.navigate(Screen.ForgotPassword.route) }
            )
        }
        composable(Screen.ForgotPassword.route){
            Forgotpassword()
        }
        composable(Screen.Home.route){
            MainMenu(MoveToProfilePage = { navController.navigate(Screen.ProfilePage.route) })
        }
        composable(Screen.ProfilePage.route){
            ProfilePage()
        }

    }
}
