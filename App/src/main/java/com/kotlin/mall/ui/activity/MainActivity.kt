package com.kotlin.mall.ui.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.ashokvarma.bottomnavigation.BottomNavigationBar
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.base.common.AppManager
import com.kotlin.base.utils.AppPrefsUtils
import com.kotlin.goods.common.GoodsConstant
import com.kotlin.goods.event.UpdateCartSizeEvent
import com.kotlin.goods.ui.fragment.CartFragment
import com.kotlin.goods.ui.fragment.CategoryFragment
import com.kotlin.mall.R
import com.kotlin.mall.ui.fragment.HomeFragment
import com.kotlin.mall.ui.fragment.MeFragment
import com.kotlin.message.ui.fragment.MessageFragment
import com.kotlin.provider.event.MessageBadgeEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import java.util.*

class MainActivity : AppCompatActivity() {

    private var pressTime: Long = 0

    private val mStack = Stack<Fragment>()

    private val mHomeFragment by lazy { HomeFragment() }
    private val mCategoryFragment by lazy { CategoryFragment() }
    private val mCartFragment by lazy { CartFragment() }
    private val mMsgFragment by lazy { MessageFragment() }
    private val mMeFragment by lazy { MeFragment() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initBottomNav()
        initFragment()
        changeFragment(0)
        initObserve()
        loadCartSize()
    }

    private fun initFragment() {
        val manager = supportFragmentManager.beginTransaction()
        manager.add(R.id.mContainer, mHomeFragment)
        manager.add(R.id.mContainer, mCategoryFragment)
        manager.add(R.id.mContainer, mCartFragment)
        manager.add(R.id.mContainer, mMsgFragment)
        manager.add(R.id.mContainer, mMeFragment)
        manager.commit()

        mStack.add(mHomeFragment)
        mStack.add(mCategoryFragment)
        mStack.add(mCartFragment)
        mStack.add(mMsgFragment)
        mStack.add(mMeFragment)
    }

    private fun initBottomNav() {
        mBottomNavBar.checkMsgBadge(false)

        mBottomNavBar.setTabSelectedListener(object : BottomNavigationBar.OnTabSelectedListener {
            override fun onTabReselected(position: Int) {
            }
            override fun onTabUnselected(position: Int) {
            }

            override fun onTabSelected(position: Int) {
                changeFragment(position)
            }
        })
    }

    private fun changeFragment(position: Int) {
        val manager = supportFragmentManager.beginTransaction()
        for (fragment in mStack) {
            manager.hide(fragment)
        }
        manager.show(mStack[position])
        manager.commit()
    }

    private fun initObserve() {
        Bus.observe<UpdateCartSizeEvent>()
                .subscribe {
                    loadCartSize()
                }.registerInBus(this)
        Bus.observe<MessageBadgeEvent>()
                .subscribe {
                    t : MessageBadgeEvent ->
                    run {
                        mBottomNavBar.checkMsgBadge(t.isVisible)
                    }
                }.registerInBus(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }

    override fun onBackPressed() {
        val time = System.currentTimeMillis()
        if (time - pressTime > 2000) {
            toast("再点击一次退出")
            pressTime = time
        } else {
            AppManager.instance.exitApp(this)
        }
    }

    private fun loadCartSize() {
        mBottomNavBar.checkCartBadge(AppPrefsUtils.getInt(GoodsConstant.SP_CART_SIZE))
    }
}
