package hofy.ropeup.presentation.ui.main.profile

import android.view.LayoutInflater
import android.view.ViewGroup
import hofy.ropeup.presentation.databinding.FragmentProfileBinding
import hofy.ropeup.presentation.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class ProfileFragment : BaseFragment<FragmentProfileBinding>() {

    private val viewModel by viewModel<ProfileViewModel>()

    override fun bind(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentProfileBinding {
        return FragmentProfileBinding.inflate(inflater, container, false).apply {
            onSignInClickListener = {
            }
        }
    }
}