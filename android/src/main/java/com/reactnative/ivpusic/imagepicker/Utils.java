package com.reactnative.ivpusic.imagepicker;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;

import java.util.ArrayList;

public class Utils {
    public static WritableMap getImageWritableMap(ImageData imageData) {
        WritableMap image = new WritableNativeMap();

        image.putString("path", imageData.getPath());
        image.putInt("width", imageData.getWidth());
        image.putInt("height", imageData.getHeight());
        image.putString("mime", imageData.getMime());
        image.putInt("size", imageData.getSize());
        image.putString("modificationDate", imageData.getModificationDate());
        image.putString("filename", imageData.getFilename());

        return image;
    }

    public static WritableArray getImageWritableArray(ArrayList<ImageData> imageDataList) {
        WritableArray arrayResult = new WritableNativeArray();
        imageDataList.forEach(imageData -> {
            WritableMap imageMap = getImageWritableMap(imageData);
            arrayResult.pushMap(imageMap);
        });
        return  arrayResult;
    }
}
