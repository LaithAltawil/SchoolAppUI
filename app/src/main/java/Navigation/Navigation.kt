package Navigation

import Screen.ExamsPage
import Screen.Forgotpassword
import Screen.Homeworks
import Screen.MainMenu
import Screen.ProfilePage
import Screen.SignInPage
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
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
        composable(Screen.ForgotPassword.route) {
            Forgotpassword()
        }
        composable(Screen.Home.route,
            ) {
            MainMenu(navController,
                MoveToProfilePage = { navController.navigate(Screen.ProfilePage.route) },
                MoveToExamsPage = { navController.navigate(Screen.ExamsPage.route) },
                MoveToHomeworksPage = { navController.navigate(Screen.Homeworks.route) }
            )
        }
        composable(Screen.ProfilePage.route) {
            ProfilePage(navController)
        }
        composable(Screen.ExamsPage.route) {
            ExamsPage(navController)

        }
        composable(Screen.Homeworks.route) {
            Homeworks(navController)

        }


    }
}

