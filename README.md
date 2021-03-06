ios实现可参考：[https://github.com/AlanMoMo/GTravel_HyBird](https://github.com/AlanMoMo/GTravel_HyBird)
### 一、初始化项目
```react-native init RNNHybrid```
### 二、改造项目
#### 1更换LaunchActivity
新建MainReactActivity(作为RN部分的主RootActivity)继承ReactActivity, 并把原来的MainActivity的内容剪切到MainReactActivity, 原来的MainActivity改集成AppCompatActivity
#### 2实现互相路由及页面数据传递控制
##### 1)原生跳转RN
###### a.原生跳转RN启动页
直接使用intent跳转：

```
Intent intent = new Intent(MainActivity.this, MainReactActivity.class);
startActivity(intent);
```
###### b.原生跳转RN其他页面（涉及数据传递）
思路1：
首先看ReactActivity的onCreate方法：

```
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mDelegate.onCreate(savedInstanceState);
}
```

追踪到ReactActivityDelegate的loadApp方法，注意看

```
mReactRootView = createRootView();
    mReactRootView.startReactApplication(
      getReactNativeHost().getReactInstanceManager(),
      appKey,
      getLaunchOptions());
```

我们接下来找getLaunchOptions方法开刀，

1 继承ReactNativeDelegate，覆写getLaunchOptions方法，返回Activity的getIntent().getExtras
2 继承ReactActivity, 添加setLaunchOptions方法，并返回第一步中的实例

思路2:通过ReactNavigation的deeplink实现，具体参见[https://reactnavigation.org/docs/deep-linking.html](https://reactnavigation.org/docs/deep-linking.html)

按照ReactNavigation的文档配置好Activity的IntentFilter属性，RN的页面配置好path，然后就可以用以下方法跳转到RN页面：

```Java
Intent intent = new Intent();
intent.setAction(Intent.ACTION_VIEW);
intent.setData(Uri.parse("rn://rn/home/detail"));
startActivity(intent);
```

##### 2)RN页面跳转原生页面
设计原生模块，具体见[rnnhybridlib module中的rn2n模块](https://github.com/Phoobobo/RNNHybrid/blob/master/android/rnnhybridlib/src/main/java/com/phoobobo/rnnhybridlib/rn2n/RN2NModule.java)。
##### 3)跳转过程中传递数据
#### 3切换RN页面族/可插拔更换
### 三、移植你的原生/RN项目到框架
