package hofy.ropeup.presentation.model

sealed class ViewState<DATA> {
    class Loading<T> : ViewState<T>()
    class Empty<T> : ViewState<T>()
    data class Error<T>(val e: Throwable?) : ViewState<T>()
    data class Data<T>(val data: T) : ViewState<T>()

    fun getDataOrNull(): DATA? = if (this is Data) {
        data
    } else {
        null
    }

    fun isLoading() = this is Loading
    fun isError() = this is Error
    fun isData() = this is Data
    fun isEmpty() = this is Empty
}
