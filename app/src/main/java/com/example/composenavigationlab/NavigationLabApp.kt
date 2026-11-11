package com.example.composenavigationlab

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.composenavigationlab.data.remote.RetrofitClient
import com.example.composenavigationlab.data.remote.StudentRemoteDataSource
import com.example.composenavigationlab.data.repository.DefaultStudentRepository
import com.example.composenavigationlab.screens.AboutScreen
import com.example.composenavigationlab.screens.ProfileScreen
import com.example.composenavigationlab.ui.detail.DetailViewModel
import com.example.composenavigationlab.ui.detail.DetailViewModelFactory
import com.example.composenavigationlab.ui.home.HomeViewModel
import com.example.composenavigationlab.ui.home.HomeViewModelFactory
import com.example.composenavigationlab.ui.screen.DetailScreen
import com.example.composenavigationlab.ui.screen.HomeScreen

@Composable
fun NavigationLabApp() {

    val remoteDataSource = remember {
        StudentRemoteDataSource(RetrofitClient.apiService)
    }

    val repository = remember {
        DefaultStudentRepository(remoteDataSource)
    }

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.HOME
    ) {

        // HALAMAN HOME

        composable(Routes.HOME) {

            val homeViewModel: HomeViewModel = viewModel(
                factory = HomeViewModelFactory(repository)
            )

            val uiState = homeViewModel.uiState.collectAsStateWithLifecycle()
            val searchQuery = homeViewModel.searchQuery.collectAsStateWithLifecycle()

            HomeScreen(
                uiState = uiState.value,
                searchQuery = searchQuery.value,

                onStudentClick = { id ->
                    navController.navigate(Routes.detail(id))
                },

                onOpenProfile = {
                    navController.navigate(Routes.PROFILE)
                },

                onOpenAbout = {
                    navController.navigate(Routes.ABOUT)
                },

                onRetry = {
                    homeViewModel.retry()
                },

                onSearchQueryChange = { query ->
                    homeViewModel.onSearchQueryChange(query)
                },

                onRefresh = {
                    homeViewModel.refresh()
                }
            )
        }


        // HALAMAN DETAIL
        composable(
            route = Routes.DETAIL,
            arguments = listOf(
                navArgument("studentId") {
                    type = NavType.IntType
                }
            )
        ) { backStackEntry ->

            val studentId = backStackEntry.arguments
                ?.getInt("studentId") ?: -1

            val detailViewModel: DetailViewModel = viewModel(
                factory = DetailViewModelFactory(repository)
            )

            val uiState = detailViewModel.uiState.collectAsStateWithLifecycle()

            LaunchedEffect(studentId) {
                detailViewModel.loadStudent(studentId)
            }

            DetailScreen(
                uiState = uiState.value,
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // HALAMAN PROFILE
        composable(Routes.PROFILE) {

            ProfileScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }

        // HALAMAN ABOUT
        composable(Routes.ABOUT) {

            AboutScreen(
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}
