package com.reactnative.ivpusic.imagepicker;

import com.facebook.react.bridge.ReadableMap;

public class OptionUtil {
    public static Integer GetThumbnailWidth(ReadableMap options) {
        return options.hasKey("thumbnailWidth") ? options.getInt("thumbnailWidth") : 300;
    }

    public static Integer GetThumbnailHeight(ReadableMap options) {
        return options.hasKey("thumbnailHeight") ? options.getInt("thumbnailHeight") : 300;
    }

    public static Double GetThumbnailQuality(ReadableMap options) {
        return options.hasKey("thumbnailQuality") ? options.getDouble("thumbnailQuality") : 0.8;
    }

    public static Integer GetLargeImageWidth(ReadableMap options) {
        return options.hasKey("largeImageWidth") ? options.getInt("largeImageWidth") : 1200;
    }

    public static Integer GetLargeImageHeight(ReadableMap options) {
        return options.hasKey("largeImageHeight") ? options.getInt("largeImageHeight") : 1200;
    }

    public static Double GetLargeImageQuality(ReadableMap options) {
        return options.hasKey("largeImageQuality") ? options.getDouble("largeImageQuality") : 0.8;
    }

    public static Integer GetOriginImageWidth(ReadableMap options) {
        return options.hasKey("originImageWidth") ? options.getInt("originImageWidth") : null;
    }

    public static Integer GetOriginImageHeight(ReadableMap options) {
        return options.hasKey("originImageHeight") ? options.getInt("originImageHeight") : null;
    }

    public static Double GetOriginImageQuality(ReadableMap options) {
        return options.hasKey("originImageQuality") ? options.getDouble("originImageQuality") : 0.8;
    }

    public static  boolean GetKeepOriginImage(ReadableMap options) {
        return options.hasKey("keepOriginImage") && options.getBoolean("keepOriginImage");
    }
}
