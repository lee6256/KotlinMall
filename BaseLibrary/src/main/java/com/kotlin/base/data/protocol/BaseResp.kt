package com.kotlin.base.data.protocol

/**
 * Created by HelloWorld on 2018/5/27.
 */
class BaseResp<out T>(val status: Int, val message: String, val data: T)