package hofy.ropeup.presentation.di

import hofy.ropeup.presentation.ui.creation.route.RouteCreationViewModel
import hofy.ropeup.presentation.ui.main.diary.DiaryViewModel
import hofy.ropeup.presentation.ui.main.profile.ProfileViewModel
import hofy.ropeup.presentation.ui.main.ropeup.RopeUpViewModel
import hofy.ropeup.presentation.ui.main.routes.RoutesViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { RoutesViewModel(get()) }
    viewModel { ProfileViewModel() }
    viewModel { DiaryViewModel() }
    viewModel { RopeUpViewModel() }
    viewModel { RouteCreationViewModel(get()) }
}