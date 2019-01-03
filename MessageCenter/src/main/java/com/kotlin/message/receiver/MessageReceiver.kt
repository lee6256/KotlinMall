package com.kotlin.message.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import android.widget.Toast
import cn.jpush.android.api.JPushInterface
import com.alibaba.android.arouter.launcher.ARouter
import com.eightbitlab.rxbus.Bus
import com.kotlin.provider.common.ProviderConstant
import com.kotlin.provider.event.MessageBadgeEvent
import com.kotlin.provider.router.RouterPath
import org.json.JSONObject

class MessageReceiver : BroadcastReceiver() {

    private val TAG = "MessageReceiver"
    override fun onReceive(context: Context, intent: Intent) {
        val bundle = intent.extras
        Log.d(TAG, "onReceive - " + intent.getAction() + ", extras: " + bundle)

        when {
            JPushInterface.ACTION_REGISTRATION_ID == intent.action -> {
                Toast.makeText(context, "用户注册成功", Toast.LENGTH_SHORT).show()
            }
            JPushInterface.ACTION_MESSAGE_RECEIVED == intent.action -> {
                Toast.makeText(context, "自定义", Toast.LENGTH_SHORT).show()
                Bus.send(MessageBadgeEvent(true))
            }
            JPushInterface.ACTION_NOTIFICATION_RECEIVED == intent.action -> {
                Toast.makeText(context, "接受到推送下来的通知", Toast.LENGTH_SHORT).show()
            }
            JPushInterface.ACTION_NOTIFICATION_OPENED == intent.action -> {
                val extra = bundle.getString(JPushInterface.EXTRA_EXTRA)
                val json = JSONObject(extra)
                val orderId = json.getInt("orderId")
                ARouter.getInstance()
                        .build(RouterPath.MessageCenter.PATH_MESSAGE_ORDER)
                        .withInt(ProviderConstant.KEY_ORDER_ID, orderId)
                        .navigation()
            }
            else -> Log.d(TAG, "Unhandled intent - " + intent.action)
        }
    }
}