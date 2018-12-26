# Android Material PinInputView
## PinInput是一个Material风格的四位密码输入控件  
![image](https://github.com/gitzsj/PinInputView/blob/master/gif/SM-G9350_20181225212424.gif)
![image](https://github.com/gitzsj/PinInputView/blob/master/gif/SM-G9350_20181225212601.gif)  
## ___开始使用___  


```
buildscript {
    repositories {
        jcenter()
    }
}
``` 

```
dependencies {
	implementation 'com.zhaoshiji.pininputview:pininputview:0.0.2'
}
``` 
## ___监听接口___  
密码输入完成监听，该接口会返回输入的内容  
`setOnFullListener(OnFullListener mListener)`  
取消按钮点击监听  
`setOnCancelClickListener(OnCancelClickListener mListener)`  
## ___参数设置___ 
设置数字颜色  
`setNumColor(int color)`  
设置清空按钮颜色  
`setClearButtonColor(int color)`  
设置取消/退格按钮颜色  
`setCancelButtonColor(int color)`  
设置输入框颜色  
`setPointColor(int color)`  
## ___其他接口___ 
输入框抖动效果    
`Error()`  
清除全部已输入的数字  
`ClearAll()`  
## ___应用示例___  
### 微信清理大师
http://app-update-package.oss-cn-beijing.aliyuncs.com/WeChatCleanUpdateAPK/16.apk
