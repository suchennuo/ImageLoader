package com.umbrella.imageloader.model.Cache;

import android.graphics.Bitmap;

import com.umbrella.imageloader.model.Cache.Cache;

/**
 * Created by liulin07 on 2018/6/10.
 *
 * @author liulin07
 * @version v7.6
 * @since 2018/6/10
 */
public class DiskCache implements Cache {

    @Override
    public void put(String key, Bitmap bitmap) {

    }

    @Override
    public Bitmap get(String key) {
        return null;
    }
}
