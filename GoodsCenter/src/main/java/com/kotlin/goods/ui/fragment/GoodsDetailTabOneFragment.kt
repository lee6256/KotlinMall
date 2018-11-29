package com.kotlin.goods.ui.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.eightbitlab.rxbus.Bus
import com.eightbitlab.rxbus.registerInBus
import com.kotlin.base.ext.onClick
import com.kotlin.base.ui.activity.BaseActivity
import com.kotlin.base.ui.fragment.BaseMvpFragment
import com.kotlin.base.utils.YuanFenConverter
import com.kotlin.base.widgets.BannerImageLoader
import com.kotlin.goods.R
import com.kotlin.goods.common.GoodsConstant
import com.kotlin.goods.data.protocol.Goods
import com.kotlin.goods.event.GoodsDetailImageEvent
import com.kotlin.goods.event.SkuChangedEvent
import com.kotlin.goods.injection.component.DaggerGoodsComponent
import com.kotlin.goods.injection.module.GoodsModule
import com.kotlin.goods.presenter.GoodsDetailPresenter
import com.kotlin.goods.presenter.view.GoodsDetailView
import com.kotlin.goods.ui.activity.GoodsDetailActivity
import com.kotlin.goods.widget.GoodsSkuPopView
import com.youth.banner.BannerConfig
import com.youth.banner.Transformer
import kotlinx.android.synthetic.main.fragment_goods_detail_tab_one.*

class GoodsDetailTabOneFragment : BaseMvpFragment<GoodsDetailPresenter>(), GoodsDetailView {

    private lateinit var mSkuPop: GoodsSkuPopView
    private lateinit var mAnimationStart: Animation
    private lateinit var mAnimationEnd: Animation

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater?.inflate(R.layout.fragment_goods_detail_tab_one, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initAnim()
        initSkuPop()
        loadData()
        initObserve()
    }

    private fun initSkuPop() {
        mSkuPop = GoodsSkuPopView(activity)
        mSkuPop.setOnDismissListener{
            (activity as BaseActivity).contentView.startAnimation(mAnimationEnd)
        }
    }

    private fun loadData() {
        mPresenter.getGoodsDetail(activity.intent.getIntExtra(GoodsConstant.KEY_GOODS_ID, -1))
    }

    private fun initView() {
        mGoodsDetailBanner.setImageLoader(BannerImageLoader())
        mGoodsDetailBanner.setBannerAnimation(Transformer.Tablet)
        mGoodsDetailBanner.setIndicatorGravity(BannerConfig.RIGHT)
        mGoodsDetailBanner.setDelayTime(5000)

        mSkuView.onClick {
            mSkuPop.showAtLocation((activity as GoodsDetailActivity).contentView,
                    Gravity.BOTTOM and Gravity.CENTER_HORIZONTAL,
                    0, 0)
            (activity as BaseActivity).contentView.startAnimation(mAnimationStart)
        }
    }

    private fun initAnim() {
        mAnimationStart = ScaleAnimation(
                1f, 0.95f, 1f, 0.95f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        mAnimationStart.duration = 500
        mAnimationStart.fillAfter = true

        mAnimationEnd = ScaleAnimation(
                0.95f, 1f, 0.95f, 1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f)
        mAnimationEnd.duration = 500
        mAnimationEnd.fillAfter = true
    }

    override fun injectComponent() {
        DaggerGoodsComponent.builder()
                .activityComponent(activityComponent)
                .goodsModule(GoodsModule())
                .build()
                .inject(this)
        mPresenter.mView = this
    }

    override fun onGetGoodsDetailResult(result: Goods) {
        mGoodsDetailBanner.setImages(result.goodsBanner.split(","))
        mGoodsDetailBanner.start()

        mGoodsDescTv.text = result.goodsDesc
        mGoodsPriceTv.text = YuanFenConverter.changeF2YWithUnit(result.goodsDefaultPrice)
        mSkuSelectedTv.text = result.goodsDefaultSku

        Bus.send(GoodsDetailImageEvent(result.goodsDetailOne, result.goodsDetailTwo))

        loadPopData(result)
    }

    private fun loadPopData(result: Goods) {
        mSkuPop.setGoodsIcon(result.goodsDefaultIcon)
        mSkuPop.setGoodsCode(result.goodsCode)
        mSkuPop.setGoodsPrice(result.goodsDefaultPrice)

        mSkuPop.setSkuData(result.goodsSku)
    }

    private fun initObserve() {
        Bus.observe<SkuChangedEvent>()
                .subscribe {
                    mSkuSelectedTv.text = mSkuPop.getSelectSku() +
                            GoodsConstant.SKU_SEPARATOR +
                            mSkuPop.getSelectCount() +
                            "件"
                }.registerInBus(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        Bus.unregister(this)
    }
}