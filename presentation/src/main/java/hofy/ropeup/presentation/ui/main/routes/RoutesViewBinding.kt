package hofy.ropeup.presentation.ui.main.routes

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import hofy.ropeup.presentation.model.route.RouteVO

@BindingAdapter("routes")
fun routes(view: RecyclerView, value: List<RouteVO>?) {
    val currentAdapter = view.adapter
    if (currentAdapter == null || currentAdapter !is RoutesAdapter) {
        view.adapter = RoutesAdapter(value?.toMutableList() ?: mutableListOf())
    } else {
        currentAdapter.setRoutes(value ?: listOf())
    }
}