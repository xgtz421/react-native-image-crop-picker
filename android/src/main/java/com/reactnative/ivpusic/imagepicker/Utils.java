package com.reactnative.ivpusic.imagepicker;

import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;

import java.util.ArrayList;

public class Utils {

    public static WritableMap getImageWritableMap(ImageData imageData) {
        WritableMap imageMap = new WritableNativeMap();
        imageMap.putString("mediaUri", imageData.getMediaUri());

        if (imageData.getThumbnailImage() != null) {
            imageMap.putMap("thumbnailImage", GetImageWriteableMap(imageData.getThumbnailImage()));
        }
        if (imageData.getLargeImage() != null) {
            imageMap.putMap("largeImage", GetImageWriteableMap(imageData.getLargeImage()));
        }
        if (imageData.getOriginImage() != null) {
            imageMap.putMap("originImage", GetImageWriteableMap(imageData.getOriginImage()));
        }
        return imageMap;
    }

    public static WritableArray getImageWritableArray(ArrayList<ImageData> imageDataList) {
        WritableArray arrayResult = new WritableNativeArray();
        imageDataList.forEach(imageData -> {
            WritableMap imageMap = getImageWritableMap(imageData);
            arrayResult.pushMap(imageMap);
        });
        return  arrayResult;
    }

    private static WritableMap GetImageWriteableMap(CompressedImage image) {
        WritableMap imageMap = new WritableNativeMap();
        imageMap.putString("path", image.getPath());
        imageMap.putString("filename", image.getFilename());
        imageMap.putInt("width", image.getSize());
        imageMap.putInt("height", image.getWidth());
        imageMap.putInt("size", image.getHeight());
        imageMap.putString("mime", image.getMime());
        imageMap.putString("modificationDate", image.getModificationDate());
        return imageMap;
    }
}
