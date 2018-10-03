package com.kotlin.user.data.api

import com.kotlin.base.data.protocol.BaseResp
import retrofit2.http.POST
import rx.Observable

/**
 * Created by HelloWorld on 2018/5/27.
 */
interface UploadApi {
    @POST("common/getUploadToken")
    fun getUploadToken():Observable<BaseResp<String>>
}