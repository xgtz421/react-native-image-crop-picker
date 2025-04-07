package com.reactnative.ivpusic.imagepicker;

import java.util.Map;

public class ImageData {
    private String mediaUri;
    private CompressedImage thumbnailImage;
    private CompressedImage largeImage;
    private CompressedImage originImage;


    // Constructor with exifData as an optional parameter
    public ImageData(String mediaUri) {
        this.mediaUri = mediaUri;
    }

    public ImageData(String mediaUri, CompressedImage thumbnailImage, CompressedImage largeImage, CompressedImage originImage) {
        this.mediaUri = mediaUri;
        this.thumbnailImage = thumbnailImage;
        this.largeImage = largeImage;
    }

    // Getters and setters
    public String getMediaUri() {
        return mediaUri;
    }

    public void setMediaUri(String mediaUri) {
        this.mediaUri = mediaUri;
    }

    public CompressedImage getThumbnailImage() { return  thumbnailImage; }
    public void setThumbnailImage(CompressedImage image) { this.thumbnailImage = image; }

    public CompressedImage getLargeImage() { return largeImage; }
    public void setLargeImage(CompressedImage image) { this.largeImage = image; }

    public CompressedImage getOriginImage() { return originImage; }
    public  void setOriginImage(CompressedImage image) { this.originImage = image; }
}
