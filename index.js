import React from 'react';

import {NativeModules, NativeEventEmitter } from 'react-native';

const ImageCropPicker = NativeModules.ImageCropPicker;

const eventEmitter = new NativeEventEmitter(ImageCropPicker);

// 导出事件监听器添加/移除函数
export const addCompressionStartListener = (callback) => eventEmitter.addListener('onCompressionStart', callback);
export const addSingleCompressionCompleteListener = (callback) => eventEmitter.addListener('onSingleCompressionComplete', callback);
export const addAllCompressionCompleteListener = (callback) => eventEmitter.addListener('onAllCompressionComplete', callback);
export const addCompressionErrorListener = (callback) => eventEmitter.addListener('onCompressionError', callback);
export const removeEventListener = (listener) => listener.remove();

export default ImageCropPicker;
export const openPicker = ImageCropPicker.openPicker;
export const openCamera = ImageCropPicker.openCamera;
export const openCropper = ImageCropPicker.openCropper;
export const clean = ImageCropPicker.clean;
export const cleanSingle = ImageCropPicker.cleanSingle;
