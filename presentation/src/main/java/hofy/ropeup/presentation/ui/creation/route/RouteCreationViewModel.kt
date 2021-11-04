package hofy.ropeup.presentation.ui.creation.route

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hofy.ropeup.domain.model.RouteDO
import hofy.ropeup.domain.usecase.CreateRouteUseCase
import hofy.ropeup.presentation.model.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RouteCreationViewModel(private val createRouteUseCase: CreateRouteUseCase) : ViewModel() {
    val viewStateLiveData = MutableLiveData<ViewState<Unit>>()

    fun createRoute(name: String, grade: String, length: String) {
        viewStateLiveData.value = ViewState.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            val result = createRouteUseCase.execute(RouteDO(name, length.toIntOrNull(), grade))
            when {
                result.isSuccess -> {
                    viewStateLiveData.postValue(ViewState.Data(Unit))
                }
                result.isFailure -> {
                    viewStateLiveData.postValue(ViewState.Error(result.exceptionOrNull()))
                }
            }
        }
    }
}