package com.reactnative.ivpusic.imagepicker;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;

import java.util.ArrayList;

public class SendEventService {



    // 发送开始生成缩略图的事件
    public static void sendThumbnailGenerationStartEvent(ReactContext reactContext, int total) {
        WritableMap params = Arguments.createMap();
        params.putInt("total", total);
        sendEvent(reactContext, "onThumbnailGenerationStart", params);
    }

    // 发送单个缩略图生成完成的事件
    public static void sendSingleThumbnailCompleteEvent(ReactContext reactContext, ImageData imageData) {
        WritableMap params = Arguments.createMap();
        params.putMap("image", Utils.getImageWritableMap(imageData));
        sendEvent(reactContext, "onSingleThumbnailComplete", params);
    }

    // 发送所有缩略图生成完成的事件
    public static void sendAllThumbnailsCompleteEvent(ReactContext reactContext, ArrayList<ImageData> imageDataList) {
        WritableMap params = Arguments.createMap();
        params.putArray("images", Utils.getImageWritableArray(imageDataList));
        sendEvent(reactContext, "onAllThumbnailsComplete", params);
    }

    // 发送开始生成大图的事件
    public static void sendLargeImageGenerationStartEvent(ReactContext reactContext, int total) {
        WritableMap params = Arguments.createMap();
        params.putInt("total", total);
        sendEvent(reactContext, "onLargeImageGenerationStart", params);
    }

    // 发送单个大图生成完成的事件
    public static void sendSingleLargeImageCompleteEvent(ReactContext reactContext, ImageData imageData) {
        WritableMap params = Arguments.createMap();
        params.putMap("image", Utils.getImageWritableMap(imageData));
        sendEvent(reactContext, "onSingleLargeImageComplete", params);
    }

    // 发送所有大图生成完成的事件
    public static void sendAllLargeImageCompleteEvent(ReactContext reactContext, ArrayList<ImageData> imageDataList) {
        WritableMap params = Arguments.createMap();
        params.putArray("images", Utils.getImageWritableArray(imageDataList));
        sendEvent(reactContext, "onAllLargeImageComplete", params);
    }

    // 发送生成缩略图或大图发送错误的事件
    public static void sendCropPickerErrorEvent(ReactContext reactContext, String message) {
        WritableMap params = Arguments.createMap();
        params.putString("message", message);
        sendEvent(reactContext, "onCropPickerError", params);
    }

    /**
     * 辅助方法，用于向 JavaScript 发出事件。
     *
     * @param reactContext React 上下文
     * @param eventName 要发送的事件名称
     * @param params 附加的参数
     */
    private static void sendEvent(ReactContext reactContext, String eventName, @Nullable WritableMap params) {
        reactContext
                .getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit(eventName, params);
    }
}
