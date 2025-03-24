import React from 'react';

import {NativeModules, NativeEventEmitter } from 'react-native';

const ImageCropPicker = NativeModules.ImageCropPicker;

const eventEmitter = new NativeEventEmitter(ImageCropPicker);

// 导出事件监听器添加/移除函数
export const addThumbnailGenerateStartListener = (callback) => eventEmitter.addListener('onThumbnailGenerationStart', callback);
export const addSingleThumbnailCompleteListener = (callback) => eventEmitter.addListener('onSingleThumbnailComplete', callback);
export const addAllThumbnailsCompleteListener = (callback) => eventEmitter.addListener('onAllThumbnailsComplete', callback);
export const addLargeImageGenerateStartListener = (callback) => eventEmitter.addListener('onLargeImageGenerationStart', callback);
export const addSingleLargeImageCompleteListener = (callback) => eventEmitter.addListener('onSingleLargeImageComplete', callback);
export const addAllLargeImageCompleteListener = (callback) => eventEmitter.addListener('onAllLargeImageComplete', callback);
export const addCropPickerErrorListener = (callback) => eventEmitter.addListener('onCropPickerError', callback);
export const removeEventListener = (listener) => listener.remove();

export default ImageCropPicker;
export const openPicker = ImageCropPicker.openPicker;
export const openCamera = ImageCropPicker.openCamera;
export const openCropper = ImageCropPicker.openCropper;
export const clean = ImageCropPicker.clean;
export const cleanSingle = ImageCropPicker.cleanSingle;
export const compressImage = ImageCropPicker.compressImage;