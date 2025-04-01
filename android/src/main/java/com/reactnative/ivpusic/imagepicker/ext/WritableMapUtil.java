package com.reactnative.ivpusic.imagepicker.ext;


import com.facebook.react.bridge.WritableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeArray;
import com.facebook.react.bridge.WritableNativeMap;
import com.reactnative.ivpusic.imagepicker.dto.FullImage;

import java.util.ArrayList;

public class WritableMapUtil {
    public static WritableMap convertSingleImageToWritableMap(FullImage imageData) {
        WritableMap image = new WritableNativeMap();
        image.putString("mime", imageData.getMime());
        image.putString("modificationDate", imageData.getModificationDate());

        image.putString("mediaUri", imageData.getMediaUri());

        image.putString("thumbnailPath", imageData.getThumbnailPath());
        image.putString("thumbnailName", imageData.getThumbnailName());
        image.putInt("thumbnailSize", imageData.getThumbnailSize());
        image.putInt("thumbnailWidth", imageData.getThumbnailWidth());
        image.putInt("thumbnailHeight", imageData.getThumbnailHeight());

        image.putString("largeImagePath", imageData.getLargeImagePath());
        image.putString("largeImageName", imageData.getLargeImageName());
        image.putInt("largeImageSize", imageData.getLargeImageSize());
        image.putInt("largeImageWidth", imageData.getLargeImageWidth());
        image.putInt("largeImageHeight", imageData.getLargeImageHeight());

        image.putString("originImagePath", imageData.getOriginImagePath());
        image.putString("originImageName", imageData.getOriginImageName());
        image.putInt("originImageSize", imageData.getOriginImageSize());
        image.putInt("originImageWidth", imageData.getOriginImageWidth());
        image.putInt("originImageHeight", imageData.getOriginImageHeight());

        return image;
    }

    public static WritableArray convertImageListToWritableArray(ArrayList<FullImage> imageDataList) {
        WritableArray arrayResult = new WritableNativeArray();
        imageDataList.forEach(imageData -> {
            WritableMap imageMap = convertSingleImageToWritableMap(imageData);
            arrayResult.pushMap(imageMap);
        });
        return  arrayResult;
    }
}
