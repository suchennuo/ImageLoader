package com.umbrella.imageloader.model.Cache;

import android.graphics.Bitmap;

/**
 * Created by zhangyongchao02 on 2018/6/11.
 *
 * @author zhangyongchao02
 * @since 2018/6/11
 */
public class CacheManager implements Cache{
    private MemoryCache mMemoryCache = new MemoryCache();
    private DiskCache mDiskCache = new DiskCache();

    public CacheManager(){

    }

    @Override
    public void put(String key, Bitmap bitmap) {
        mMemoryCache.put(key, bitmap);
    }

    @Override
    public Bitmap get(String key) {
        return mMemoryCache.get(key);
    }
}
