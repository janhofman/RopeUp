package hofy.ropeup.presentation.ui.creation

import android.view.LayoutInflater
import android.view.ViewGroup
import hofy.ropeup.presentation.databinding.FragmentSectorCreationBinding
import hofy.ropeup.presentation.ui.BaseFragment

class SectorCreationFragment : BaseFragment<FragmentSectorCreationBinding>() {
    override fun bind(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentSectorCreationBinding {
        return FragmentSectorCreationBinding.inflate(inflater, container, false)
    }
}