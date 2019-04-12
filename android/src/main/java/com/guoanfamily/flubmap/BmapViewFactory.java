package com.guoanfamily.flubmap;

import android.app.Activity;
import android.content.Context;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugin.platform.PlatformView;
import io.flutter.plugin.platform.PlatformViewFactory;

public class BmapViewFactory extends PlatformViewFactory {
    private final BinaryMessenger messenger;
    private Activity activity;
    public BmapViewFactory(BinaryMessenger messenger, Activity activity) {
        super(StandardMessageCodec.INSTANCE);
        this.messenger = messenger;
        this.activity = activity;
    }
    @SuppressWarnings("unchecked")
    @Override
    public PlatformView create(Context context, int id, Object args) {
        System.out.println(context);
        Map<String, Object> params = (Map<String, Object>) args;
        return new BmapView(activity, messenger, id, params);
    }
}
