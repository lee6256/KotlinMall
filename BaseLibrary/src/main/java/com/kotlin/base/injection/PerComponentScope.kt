package com.kotlin.base.injection

import java.lang.annotation.Documented
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy.RUNTIME
import javax.inject.Scope

/**
 * Created by HelloWorld on 2018/5/30.
 */
@Scope
@Documented
@Retention(RUNTIME)
annotation class PerComponentScope