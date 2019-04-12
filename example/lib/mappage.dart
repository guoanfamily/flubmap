import 'package:flubmap/flubmap.dart';
import 'package:flutter/material.dart';

class MapPage extends StatefulWidget {
  @override
  _MapPageState createState() => _MapPageState();
}

class _MapPageState extends State<MapPage> {
  @override
  Widget build(BuildContext context) {
    return new WillPopScope(
        child: Scaffold(
          appBar: AppBar(
            title: Text("Map"),
          ),
          body: Stack(
            children: <Widget>[
              SizedBox(
                  width: MediaQuery.of(context).size.width,
                  height: MediaQuery.of(context).size.height,
                  child: new BmapView())
            ],
          ),
        ),
        onWillPop: () {
          print("返回键点击了");
          Navigator.pop(context);
        });
  }
}
