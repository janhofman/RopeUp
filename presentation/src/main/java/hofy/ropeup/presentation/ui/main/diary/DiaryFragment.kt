package hofy.ropeup.presentation.ui.main.diary

import android.view.LayoutInflater
import android.view.ViewGroup
import hofy.ropeup.presentation.databinding.FragmentDiaryBinding
import hofy.ropeup.presentation.ui.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class DiaryFragment : BaseFragment<FragmentDiaryBinding>() {

    private val viewModel by viewModel<DiaryViewModel>()
    override fun bind(inflater: LayoutInflater, container: ViewGroup?): FragmentDiaryBinding {
        return FragmentDiaryBinding.inflate(inflater, container, false)
    }


}