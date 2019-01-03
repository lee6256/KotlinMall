package com.kotlin.base.widgets

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.AnimationDrawable
import android.view.Gravity
import android.widget.ImageView
import com.kotlin.base.R
import org.jetbrains.anko.find

/**
 * Created by HelloWorld on 2018/6/1.
 */
class ProgressLoading private constructor(context: Context, theme: Int) : Dialog(context, theme) {

    companion object {
        private lateinit var mDialog: ProgressLoading
        private lateinit var animDrawable: AnimationDrawable

        fun create(context: Context): ProgressLoading {
            mDialog = ProgressLoading(context, R.style.LightProgressDialog)
            mDialog.setContentView(R.layout.progress_dialog)
            mDialog.setCancelable(true)
            mDialog.setCanceledOnTouchOutside(false)

            val lp = mDialog.window.attributes
            lp.gravity = Gravity.CENTER
            lp.dimAmount = 0.2f
            mDialog.window.attributes = lp

            val loadingView = mDialog.find<ImageView>(R.id.iv_loading)
            animDrawable = loadingView.background as AnimationDrawable

            return mDialog
        }
    }

    fun showLoading() {
        super.show()
        animDrawable.start()
    }

    fun hideLoading() {
        super.dismiss()
        animDrawable.stop()
    }
}