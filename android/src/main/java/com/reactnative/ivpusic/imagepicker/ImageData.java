package com.reactnative.ivpusic.imagepicker;

import java.util.Map;

public class ImageData {
    private String path;
    private int width;
    private int height;
    private String mime;
    private int size;
    private String modificationDate;
    private String filename;
    private String base64Data;
    private Map<String, Object> exifData;

    // Constructor with exifData as an optional parameter
    public ImageData(String path, int width, int height, String mime, int size, String modificationDate, String filename, Map<String, Object> exifData) {
        this.path = path;
        this.width = width;
        this.height = height;
        this.mime = mime;
        this.size = size;
        this.modificationDate = modificationDate;
        this.filename = filename;
        this.base64Data = null; // Initialize base64Data as null by default
        this.exifData = exifData; // exifData can be null
    }

    // Overloaded constructor without exifData
    public ImageData(String path, int width, int height, String mime, int size, String modificationDate, String filename) {
        this(path, width, height, mime, size, modificationDate, filename, null);
    }

    // Getters and setters
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(String modificationDate) {
        this.modificationDate = modificationDate;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getBase64Data() {
        return base64Data;
    }

    public void setBase64Data(String base64Data) {
        this.base64Data = base64Data;
    }

    public Map<String, Object> getExifData() {
        return exifData;
    }

    public void setExifData(Map<String, Object> exifData) {
        this.exifData = exifData;
    }
}
