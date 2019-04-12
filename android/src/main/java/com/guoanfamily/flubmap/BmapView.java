package com.guoanfamily.flubmap;

import android.content.Context;
import android.view.View;

import com.baidu.mapapi.map.MapView;

import java.util.Map;

import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformView;

public class BmapView implements PlatformView {

    private MapView mapView;

    BmapView(Context context, BinaryMessenger messenger, int id, Map<String, Object> params){
        this.mapView = new MapView(context);
    }
    @Override
    public View getView() {
        return mapView;
    }

    @Override
    public void dispose() {
        mapView.onDestroy();
    }
}
