package hofy.ropeup.presentation.ui.creation.route

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import hofy.ropeup.presentation.databinding.FragmentRouteCreationBinding
import hofy.ropeup.presentation.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RouteCreationFragment : BaseFragment<FragmentRouteCreationBinding>() {

    private val viewModel by viewModel<RouteCreationViewModel>()

    override fun bind(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRouteCreationBinding {
        return FragmentRouteCreationBinding.inflate(inflater, container, false).apply {
            lifecycleOwner = viewLifecycleOwner
            vm = viewModel
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewStateLiveData.observe(viewLifecycleOwner) {
            if (it.isData()) {
                findNavController().navigateUp()
            }
        }
    }
}