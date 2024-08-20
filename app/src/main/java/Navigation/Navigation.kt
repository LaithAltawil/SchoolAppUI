package Navigation

import Screen.CLassesPage
import Screen.CounselorReq
import Screen.ExamsPage
import Screen.Forgotpassword
import Screen.Homeworks
import Screen.MainMenu
import Screen.ProfilePage
import Screen.ResourcesPage
import Screen.SignInPage
import Screen.Stack035
import Screen.calanderPage
import Screen.settingspage
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
        composable(Screen.ForgotPassword.route) {
            Forgotpassword()
        }
        composable(
            Screen.Home.route,
        ) {
            MainMenu(navController,
                MoveToProfilePage = { navController.navigate(Screen.ProfilePage.route) },
                MoveToExamsPage = { navController.navigate(Screen.ExamsPage.route) },
                MoveToHomeworksPage = { navController.navigate(Screen.Homeworks.route) },
                MoveToConselorReq = { navController.navigate(Screen.ConselorReq.route) },
                MoveToResourcesPage = { navController.navigate(Screen.ResourcesPage.route) },
                MoveToCalanderPage = { navController.navigate(Screen.CalenderPage.route) },
                MoveToSettingsPage = { navController.navigate(Screen.SettingsPage.route) },
                MoveToHomeworks2Page = { navController.navigate(Screen.HomeworksPage.route) },
                MoveToClassesPage = { navController.navigate(Screen.ClassesPage.route) }
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

        composable(Screen.ConselorReq.route) {
            CounselorReq(navController)
        }

        composable(Screen.ResourcesPage.route) {
            ResourcesPage(navController)
        }
        composable(Screen.CalenderPage.route) {
            calanderPage(navController)
        }
        composable(Screen.SettingsPage.route) {
            settingspage(navController)

        }
        composable(Screen.HomeworksPage.route) {
            Stack035(navController)
        }
        composable(Screen.ClassesPage.route) {
            CLassesPage(navController)
        }


    }
}

