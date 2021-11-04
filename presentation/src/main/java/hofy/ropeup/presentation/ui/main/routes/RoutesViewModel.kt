package hofy.ropeup.presentation.ui.main.routes

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hofy.ropeup.domain.usecase.RetrieveRoutesUseCase
import hofy.ropeup.presentation.model.ViewState
import hofy.ropeup.presentation.model.route.RouteVO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RoutesViewModel(private val retrieveRoutesUseCase: RetrieveRoutesUseCase) : ViewModel() {
    val viewStateLiveData = MutableLiveData<ViewState<List<RouteVO>>>()

    fun loadRoutes() {
        viewStateLiveData.value = ViewState.Loading()
        viewModelScope.launch(Dispatchers.IO) {
            val result = retrieveRoutesUseCase.execute(Unit)
            when {
                result.isSuccess -> {
                    val data = result.getOrDefault(listOf())
                    if (data.isEmpty()) {
                        viewStateLiveData.postValue(ViewState.Empty())
                    } else {
                        viewStateLiveData.postValue(ViewState.Data(data.map {
                            RouteVO(it.name, it.length, it.grade)
                        }))
                    }

                }
                result.isFailure -> {
                    viewStateLiveData.postValue(ViewState.Error(result.exceptionOrNull()))
                }
            }


        }
    }
}