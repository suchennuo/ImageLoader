package com.umbrella.imageloader.model.Cache;

import android.graphics.Bitmap;

/**
 * Created by liulin07 on 2018/6/10.
 *
 * @author liulin07
 * @version v7.6
 * @since 2018/6/10
 */
public interface Cache {

    public void put(String key, Bitmap bitmap);

    public Bitmap get(String key);
}
