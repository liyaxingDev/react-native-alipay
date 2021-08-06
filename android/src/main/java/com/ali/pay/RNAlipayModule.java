
package com.ali.pay;

import com.ali.pay.alipay.Alipay;
import com.ali.pay.alipay.PayResult;
import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class RNAlipayModule extends ReactContextBaseJavaModule {

  private final ReactApplicationContext reactContext;

  public RNAlipayModule(ReactApplicationContext reactContext) {
    super(reactContext);
    this.reactContext = reactContext;
  }

  @Override
  public String getName() {
    return "RNAlipay";
  }

  @ReactMethod
  public void onStartAlipay(String signature, final Promise promise) {
    Alipay alipay = new Alipay(reactContext.getCurrentActivity());
    alipay.startPay(signature);
    alipay.setAlipayListener(new Alipay.AlipayListener() {
      @Override
      public void onSuccess(PayResult result) {
        promise.resolve("充值成功");
      }
      @Override
      public void onError(String msg) {
        promise.resolve(msg);
      }
    });
  }


}