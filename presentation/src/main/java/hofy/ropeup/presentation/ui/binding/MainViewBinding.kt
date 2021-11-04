package hofy.ropeup.presentation.ui.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import hofy.ropeup.presentation.ui.custom.GlideApp

@BindingAdapter("imageSrc")
fun imageSrc(view: ImageView, src: Any?) {
    GlideApp.with(view).load(src).into(view)
}