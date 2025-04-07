package com.reactnative.ivpusic.imagepicker;

import android.util.Log;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ipusic on 12/28/16.
 */

class ResultCollector {
    private Promise promise;
    private int waitCount;
    private boolean multiple;
    private AtomicInteger waitCounter;
    private WritableArray arrayResult;
    private boolean resultSent;

    // 图片数据列表
    private final ArrayList<ImageData> imageDataList = new ArrayList<>();

    // React 上下文
    private ReactApplicationContext reactContext;

    public void SetContext(ReactApplicationContext context) {
        this.reactContext = context;
    }

    synchronized void setup(Promise promise, boolean multiple) {
        this.promise = promise;
        this.multiple = multiple;

        this.resultSent = false;
        this.waitCount = 0;
        this.waitCounter = new AtomicInteger(0);

        if (multiple) {
            this.arrayResult = new WritableNativeArray();
            this.imageDataList.clear();
        }
    }

    // if user has provided "multiple" option, we will wait for X number of result to come,
    // and also return result as an array
    synchronized void setWaitCount(int waitCount) {
        this.waitCount = waitCount;
        this.waitCounter = new AtomicInteger(0);
    }

    synchronized private boolean isRequestValid() {
        if (resultSent) {
            Log.w("image-crop-picker", "Skipping result, already sent...");
            return false;
        }

        if (promise == null) {
            Log.w("image-crop-picker", "Trying to notify success but promise is not set");
            return false;
        }

        return true;
    }

    // Obsolete 该方法已经废弃，后续需要删除
    synchronized void notifySuccess(WritableMap result) {
        if (!isRequestValid()) {
            return;
        }

        if (multiple) {
            arrayResult.pushMap(result);
            int currentCount = waitCounter.addAndGet(1);

            if (currentCount == waitCount) {
                promise.resolve(arrayResult);
                resultSent = true;
            }
        } else {
            promise.resolve(result);
            resultSent = true;
        }
    }

    synchronized void notifyBatchCompressSuccess(ImageData imageData) {
        if (!isRequestValid()) {
            return;
        }
        // 缓存图片数据
        imageDataList.add(imageData);
        // 将单张照片信息发送到JS端
        SendEventService.sendSingleLargeImageCompleteEvent(reactContext, imageData);
        int currentCount = waitCounter.addAndGet(1);
        if (currentCount == waitCount) {
            // 将所有的照片信息发送到JS端
            SendEventService.sendAllLargeImageCompleteEvent(reactContext, imageDataList);
            // 选择照片的promise
            promise.resolve(WritableMapUtil.getImageWritableArray(imageDataList));
            resultSent = true;
        }
    }
    synchronized void notifySuccessImage(ImageData imageData) {
        if (!isRequestValid()) {
            return;
        }
        if (multiple) {
            // 缓存图片数据
            imageDataList.add(imageData);
            // 将单张照片信息发送到JS端
            SendEventService.sendSingleThumbnailCompleteEvent(reactContext, imageData);
            int currentCount = waitCounter.addAndGet(1);
            if (currentCount == waitCount) {
                // 将所有的照片信息发送到JS端
                SendEventService.sendAllThumbnailsCompleteEvent(reactContext, imageDataList);
                // 选择照片的promise
                promise.resolve(WritableMapUtil.getImageWritableArray(imageDataList));
                resultSent = true;
            }
        } else {
            // 将单张照片信息发送到JS端
            SendEventService.sendSingleThumbnailCompleteEvent(reactContext, imageData);
            // 将所有的照片信息发送到JS端
            SendEventService.sendAllThumbnailsCompleteEvent(reactContext, (ArrayList<ImageData>) Collections.singletonList(imageData));

            WritableMap result = WritableMapUtil.getImageWritableMap(imageData);
            promise.resolve(result);
            resultSent = true;
        }
    }

    synchronized void notifyProblem(String code, String message) {
        if (!isRequestValid()) {
            return;
        }

        Log.e("image-crop-picker", "Promise rejected. " + message);
        promise.reject(code, message);
        resultSent = true;
    }

    synchronized void notifyProblem(String code, Throwable throwable) {
        if (!isRequestValid()) {
            return;
        }

        Log.e("image-crop-picker", "Promise rejected. " + throwable.getMessage());
        promise.reject(code, throwable);
        resultSent = true;
    }
}
