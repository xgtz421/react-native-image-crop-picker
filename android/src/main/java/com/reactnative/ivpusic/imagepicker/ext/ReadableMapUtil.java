package com.reactnative.ivpusic.imagepicker.ext;

import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;

import java.util.ArrayList;
import java.util.Objects;

public class ReadableMapUtil {
    public static ArrayList<String> getMediaUriList(ReadableMap options) {
        ArrayList<String> mediaUriList = new ArrayList<>();
        if (options.hasKey("mediaUris")) {
            ReadableArray mediaUris = options.getArray("mediaUris");
            for (int i = 0; i < Objects.requireNonNull(mediaUris).size(); i++) {
                mediaUriList.add(mediaUris.getString(i));
            }
        }
        return mediaUriList;
    }
}
