package hofy.ropeup.presentation.ui.main.routes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import hofy.ropeup.presentation.R
import hofy.ropeup.presentation.databinding.FragmentRoutesBinding
import hofy.ropeup.presentation.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RoutesFragment : BaseFragment<FragmentRoutesBinding>() {

    private val viewModel by viewModel<RoutesViewModel>()

    override fun bind(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRoutesBinding {
        return FragmentRoutesBinding.inflate(inflater, container, false).apply {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
            onCreateClickListener = {
                findNavController().navigate(R.id.navigation_route_creation)
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.loadRoutes()
    }

}