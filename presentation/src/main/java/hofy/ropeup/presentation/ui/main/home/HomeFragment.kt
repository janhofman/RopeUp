package hofy.ropeup.presentation.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import hofy.ropeup.presentation.databinding.FragmentHomeBinding
import hofy.ropeup.presentation.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel by viewModel<HomeViewModel>()

    override fun bind(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(inflater, container, false)
    }
}