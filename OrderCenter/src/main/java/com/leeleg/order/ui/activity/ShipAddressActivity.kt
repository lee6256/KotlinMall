package com.leeleg.order.ui.activity

import android.os.Bundle
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseActivity
import com.leeleg.order.R
import kotlinx.android.synthetic.main.activity_address.*
import org.jetbrains.anko.startActivity

class ShipAddressActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address)

        initView()
    }

    private fun initView() {
        mAddAddressBtn.onClick {
            startActivity<ShipAddressEditActivity>()
        }
    }
}