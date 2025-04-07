package com.reactnative.ivpusic.imagepicker;

public class CompressedImage {
    private String path;
    private String filename;
    private String mime;
    private String modificationDate;

    private int size;
    private int width;
    private int height;

    // 构造函数
    public CompressedImage(String path, String filename, String mime, String modificationDate, int size, int width, int height) {
        this.path = path;
        this.filename = filename;
        this.mime = mime;
        this.modificationDate = modificationDate;
        this.size = size;
        this.width = width;
        this.height = height;
    }

    // Getter 和 Setter 方法
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
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
}
