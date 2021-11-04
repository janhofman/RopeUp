package hofy.ropeup.presentation.ui.main.ropeup

import android.view.LayoutInflater
import android.view.ViewGroup
import hofy.ropeup.presentation.databinding.FragmentRopeUpBinding
import hofy.ropeup.presentation.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class RopeUpFragment : BaseFragment<FragmentRopeUpBinding>() {

    private val viewModel by viewModel<RopeUpViewModel>()

    override fun bind(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentRopeUpBinding {
        return FragmentRopeUpBinding.inflate(inflater, container, false)
    }

}