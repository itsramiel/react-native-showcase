package com.showcase

import android.os.Handler
import android.os.Looper
import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.WritableArray
import com.facebook.react.bridge.WritableMap
import com.facebook.react.bridge.WritableNativeArray
import com.facebook.react.bridge.WritableNativeMap
import kotlin.random.Random

class ShowcaseModuleImpl  {
  fun reverseString(str: String): String {
    return str.reversed()
  }

  fun getNumbers(): WritableArray {
    val numbers = WritableNativeArray()
    for (i in 0 until 10) {
      numbers.pushInt(i)
    }

    return numbers
  }

  fun getOBject(): WritableMap {
    val map = WritableNativeMap();
    map.putString("result", "success")

    return map
  }

  fun promiseNumber(value: Double, promise: Promise) {
    Handler(Looper.getMainLooper()).postDelayed({
      promise.resolve(value)
    }, 2000)
  }

  fun callMeLater(successCB: Callback, failureCB: Callback) {
    Handler(Looper.getMainLooper()).postDelayed({
      if(Random.nextBoolean()) {
        successCB.invoke()
      } else {
        failureCB.invoke()
      }
    }, 2000)
  }

  companion object {
    const val NAME = "Showcase"
  }
}
