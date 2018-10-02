package com.kotlin.user.service

import rx.Observable

/**
 * Created by HelloWorld on 2018/5/27.
 */
interface UploadService {
    fun getUploadToken(): Observable<String>
}