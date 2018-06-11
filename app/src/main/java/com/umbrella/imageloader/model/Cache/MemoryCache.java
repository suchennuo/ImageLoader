package com.umbrella.imageloader.model.Cache;

import android.graphics.Bitmap;
import android.util.Log;

import com.umbrella.imageloader.model.Cache.Cache;

import java.util.LinkedHashMap;
import java.util.Map;


/**
 * Created by liulin07 on 2018/6/10.
 *
 * @author liulin07
 * @version v7.6
 * @since 2018/6/10
 */
public class MemoryCache implements Cache {

    private static final String TAG = "MemoryCache";

    private final Map<String, Bitmap> memoryCache;

    MemoryCache(){

        final int maxCacheSize = (int)(Runtime.getRuntime().maxMemory() / 1024);
        final int cacheSize = maxCacheSize / 8;


        memoryCache = new LinkedHashMap<>(0, 0.75f, true);

    }

    @Override
    public void put(String key, Bitmap bitmap) {
        Log.d(TAG, "put into memory cache.");
        memoryCache.put(key, bitmap);
        // 10007515110485222664
    }

    @Override
    public Bitmap get(String key) {
        Log.d(TAG, "get bitmap from memory cache.");
        return memoryCache.get(key);
    }
}
