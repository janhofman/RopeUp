package hofy.ropeup.presentation.ui.main.routes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import hofy.ropeup.presentation.R
import hofy.ropeup.presentation.databinding.ItemRouteBinding
import hofy.ropeup.presentation.model.route.RouteVO

class RoutesAdapter(private var items: MutableList<RouteVO>) :
    RecyclerView.Adapter<RoutesAdapter.ViewHolder>() {
    class ViewHolder(private val binding: ItemRouteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(route: RouteVO) {
            binding.txtName.text = route.name
            binding.txtGrade.text = route.grade
            binding.txtLength.text =
                binding.root.context.getString(R.string.length_format, route.length)

        }

    }

    class RouteDiffCallback(
        private val oldList: List<RouteVO>,
        private val newList: List<RouteVO>
    ) : DiffUtil.Callback() {
        override fun getOldListSize() = oldList.size

        override fun getNewListSize() = newList.size

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
            oldList[oldItemPosition] == newList[newItemPosition]

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemRouteBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size
    fun setRoutes(routes: List<RouteVO>) {
        val diffCallback = RouteDiffCallback(items, routes)
        val diffResult = DiffUtil.calculateDiff(diffCallback)
        items.clear()
        items.addAll(routes)
        diffResult.dispatchUpdatesTo(this)
    }

}