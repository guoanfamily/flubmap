import 'dart:async';

import 'package:flutter/services.dart';

export 'bmap_view.dart';

class Flubmap {
  static const MethodChannel _channel =
      const MethodChannel('flubmap');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  static Future<bool> init() async{
    return await _channel.invokeMethod('init');
  }
}
