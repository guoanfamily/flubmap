import 'package:flutter/foundation.dart';
import 'package:flutter/material.dart';

class BmapView extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    // TODO: implement createState
    return _BmapViewState();
  }


}

class _BmapViewState extends State<BmapView>{
  @override
  Widget build(BuildContext context) {
    if (defaultTargetPlatform == TargetPlatform.android) {
      return AndroidView(
        viewType: 'flubmap.guoanfamily.com/bmapview');
    }
    return Text(
        '$defaultTargetPlatform is not yet supported by the text_view plugin');
  }

}