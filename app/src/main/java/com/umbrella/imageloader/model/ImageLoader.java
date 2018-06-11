package com.umbrella.imageloader.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;

import com.umbrella.imageloader.model.Cache.Cache;
import com.umbrella.imageloader.model.Cache.CacheManager;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by liulin07 on 2018/6/10.
 *
 * @author liulin07
 * @version v7.6
 * @since 2018/6/10
 */
public class ImageLoader {

    private static String TAG = "ImageLoader";

    private Cache mCache;

    public ImageLoader(){
        mCache = new CacheManager();
    }

    public void loaderImage(final String url, final ImageLoaderListener listener){

        new AsyncTask<String, Integer, Bitmap>(){
            @Override
            protected Bitmap doInBackground(String... strings) {
                Bitmap bitmap = getBitmap(url);
                mCache.put(url, bitmap);
                return bitmap;
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
//                super.onPostExecute(bitmap);

                listener.loader(bitmap);
            }
        }.execute(url);
//        view.setImageBitmap(getBitmap(url));
    }

    private Bitmap getBitmap(String imageUrl){
        Bitmap result = null;
        result = getBitmapFromCache(imageUrl);
        if (result == null){
            result = getBitmapFromNetwork(imageUrl);
        } else {
            Log.d(TAG, "get bitmap from cache.");
        }
        return result;
    }

    public Bitmap getBitmapFromNetwork(String url){
        Log.d(TAG, "get bitmap from network.");
        Bitmap result = null;
        HttpsURLConnection connection = null;
        InputStream inputStream = null;

        try {
            URL connectionUrl = new URL(url);
            connection = (HttpsURLConnection)connectionUrl.openConnection();
            inputStream = new BufferedInputStream(connection.getInputStream());
            Log.d(TAG, "is available ? " + inputStream.available());
            readInputStream(inputStream);
            result = BitmapFactory.decodeStream(inputStream);
        } catch (Exception exception){
            Log.e(TAG, "exception " + exception);
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException ioException){
                    // Ignore
                }

            }
        }
        return result;
    }


    private void readInputStream(InputStream inputStream){

    }

    private Bitmap getBitmapFromCache(String url){
        return mCache.get(url);
    }

    public interface ImageLoaderListener{
        void loader(Bitmap bitmap);
    }

}
