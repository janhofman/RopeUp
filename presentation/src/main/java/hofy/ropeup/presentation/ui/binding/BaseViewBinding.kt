package hofy.ropeup.presentation.ui.util

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter("visible")
fun visible(view: View, value: Boolean) {
    view.isVisible = value
}