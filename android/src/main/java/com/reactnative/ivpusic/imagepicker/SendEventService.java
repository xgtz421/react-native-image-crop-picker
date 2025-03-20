package com.reactnative.ivpusic.imagepicker;

import androidx.annotation.Nullable;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;

import java.util.ArrayList;

public class SendEventService {

    /**
     * 发送一个事件，表示压缩过程已经开始。
     *
     * @param reactContext React 上下文
     * @param total 需要压缩的总项数
     */
    public static void sendCompressionStartEvent(ReactContext reactContext, int total) {
        WritableMap params = Arguments.createMap();
        params.putInt("total", total);
        sendEvent(reactContext, "onCompressionStart", params);
    }

    /**
     * 发送一个事件，表示单个压缩任务已完成。
     *
     * @param reactContext React 上下文
     * @param imageData 照片信息
     */
    public static void sendSingleCompressionCompleteEvent(ReactContext reactContext, ImageData imageData) {
        WritableMap params = Arguments.createMap();
        params.putMap("image", Utils.getImageWritableMap(imageData));
        sendEvent(reactContext, "onSingleCompressionComplete", params);
    }

    /**
     * 发送一个事件，表示所有压缩任务已完成。
     *
     * @param reactContext React 上下文
     * @param imageDataList 照片信息列表
     */
    public static void sendAllCompressionCompleteEvent(ReactContext reactContext, ArrayList<ImageData> imageDataList) {
        WritableMap params = Arguments.createMap();
        params.putArray("images", Utils.getImageWritableArray(imageDataList));
        sendEvent(reactContext, "onAllCompressionComplete", params);
    }

    /**
     * 发送一个事件，表示压缩过程发生错误。
     *
     * @param reactContext React 上下文
     * @param message 错误信息
     */
    public static void sendCompressionErrorEvent(ReactContext reactContext, String message) {
        WritableMap params = Arguments.createMap();
        params.putString("message", message);
        sendEvent(reactContext, "onCompressionError", params);
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
