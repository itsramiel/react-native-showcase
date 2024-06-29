package com.showcase

import com.facebook.react.bridge.Callback
import com.facebook.react.bridge.Promise
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.WritableArray
import com.facebook.react.bridge.WritableMap

class ShowcaseModule (context: ReactApplicationContext) :
  NativeShowcaseSpec(context) {
    val moduleImpl = ShowcaseModuleImpl()
  override fun reverseString(str: String): String {
    return moduleImpl.reverseString(str)
  }

  override fun getNumbers(): WritableArray {
    return moduleImpl.getNumbers()
  }

  override fun getOBject(): WritableMap {
    return moduleImpl.getOBject()
  }

  override fun promiseNumber(value: Double, promise: Promise) {
    moduleImpl.promiseNumber(value, promise)
  }

  override fun callMeLater(successCB: Callback, failureCB: Callback) {
    moduleImpl.callMeLater(successCB, failureCB)
  }
}
