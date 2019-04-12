package com.guoanfamily.flubmap;

import android.app.Activity;

import com.baidu.mapapi.CoordType;
import com.baidu.mapapi.SDKInitializer;

import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/** FlubmapPlugin */
public class FlubmapPlugin implements MethodCallHandler {
  /** Plugin registration. */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flubmap");
    channel.setMethodCallHandler(new FlubmapPlugin(registrar.activity(),channel));
    registrar.platformViewRegistry().registerViewFactory("flubmap.guoanfamily.com/bmapview",new BmapViewFactory(registrar.messenger(),registrar.activity()));
  }
  private Activity activity;
  private MethodChannel channel;

  public FlubmapPlugin(Activity activity,MethodChannel channel){
    this.activity = activity;
    this.channel =channel;
  }
  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("init")){
      SDKInitializer.initialize(activity.getApplicationContext());
      SDKInitializer.setCoordType(CoordType.BD09LL);
      result.success(true);
    }
    else if (call.method.equals("getPlatformVersion")) {
      result.success("Android " + android.os.Build.VERSION.RELEASE);
    } else {
      result.notImplemented();
    }
  }
}
