package com.reactnative.ivpusic.imagepicker;

import java.util.Map;

public class ImageData {
    private String mediaUri;;
    private String mime;
    private String modificationDate;

    private String thumbnailPath;
    private String thumbnailName;
    private int thumbnailSize;
    private int thumbnailWidth;
    private int thumbnailHeight;

    private String largeImagePath;
    private String largeImageName;
    private int largeImageSize;
    private int largeImageWidth;
    private int largeImageHeight;

    private String originImagePath;
    private String originImageName;
    private int originImageSize;
    private int originImageWidth;
    private int originImageHeight;

    // Constructor with exifData as an optional parameter
    public ImageData(String mediaUri, String mime, String modificationDate) {
        this.mediaUri = mediaUri;
        this.mime = mime;
        this.modificationDate = modificationDate;
    }

    // Getters and setters
    public String getMediaUri() {
        return mediaUri;
    }

    public void setMediaUri(String mediaUri) {
        this.mediaUri = mediaUri;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getThumbnailPath() {
        return thumbnailPath;
    }

    public void setThumbnailPath(String thumbnailPath) {
        this.thumbnailPath = thumbnailPath;
    }

    public String getThumbnailName() {
        return thumbnailName;
    }

    public void setThumbnailName(String thumbnailName) {
        this.thumbnailName = thumbnailName;
    }

    public int getThumbnailSize() {
        return thumbnailSize;
    }

    public void setThumbnailSize(int thumbnailSize) {
        this.thumbnailSize = thumbnailSize;
    }

    public int getThumbnailWidth() {
        return thumbnailWidth;
    }

    public void setThumbnailWidth(int thumbnailWidth) {
        this.thumbnailWidth = thumbnailWidth;
    }

    public int getThumbnailHeight() {
        return thumbnailHeight;
    }

    public void setThumbnailHeight(int thumbnailHeight) {
        this.thumbnailHeight = thumbnailHeight;
    }

    public String getLargeImagePath() {
        return largeImagePath;
    }

    public void setLargeImagePath(String largeImagePath) {
        this.largeImagePath = largeImagePath;
    }

    public String getLargeImageName() {
        return largeImageName;
    }

    public void setLargeImageName(String largeImageName) {
        this.largeImageName = largeImageName;
    }

    public int getLargeImageSize() {
        return largeImageSize;
    }

    public void setLargeImageSize(int largeImageSize) {
        this.largeImageSize = largeImageSize;
    }

    public int getLargeImageWidth() {
        return largeImageWidth;
    }

    public void setLargeImageWidth(int largeImageWidth) {
        this.largeImageWidth = largeImageWidth;
    }

    public int getLargeImageHeight() {
        return largeImageHeight;
    }

    public void setLargeImageHeight(int largeImageHeight) {
        this.largeImageHeight = largeImageHeight;
    }

    public String getOriginImagePath() {
        return originImagePath;
    }

    public void setOriginImagePath(String originImagePath) {
        this.originImagePath = originImagePath;
    }

    public String getOriginImageName() {
        return originImageName;
    }

    public void setOriginImageName(String originImageName) {
        this.originImageName = originImageName;
    }

    public int getOriginImageSize() {
        return originImageSize;
    }

    public void setOriginImageSize(int originImageSize) {
        this.originImageSize = originImageSize;
    }

    public int getOriginImageWidth() {
        return originImageWidth;
    }

    public void setOriginImageWidth(int originImageWidth) {
        this.originImageWidth = originImageWidth;
    }

    public int getOriginImageHeight() {
        return originImageHeight;
    }

    public void setOriginImageHeight(int originImageHeight) {
        this.originImageHeight = originImageHeight;
    }
}
