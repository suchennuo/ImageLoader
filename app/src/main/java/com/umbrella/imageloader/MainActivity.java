package com.umbrella.imageloader;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.umbrella.imageloader.model.Cellar;
import com.umbrella.imageloader.model.ImageLoader;

/**
 * Created by liulin07 on 2018/6/10.
 *
 * @author liulin07
 * @version v7.6
 * @since 2018/6/10
 */
public class MainActivity extends AppCompatActivity{

    private String imageUrl = "https://wx2.sinaimg.cn/mw690/819cc17dly1fs5v71gayhj20k00k00ug.jpg";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        final ImageLoader imageLoader = new ImageLoader();
        imageLoader.loaderImage(imageUrl, new ImageLoader.ImageLoaderListener(){
            @Override
            public void loader(Bitmap bitmap) {
                ((ImageView)findViewById(R.id.iv_main)).setImageBitmap(bitmap);
            }
        });
        Button mButton = findViewById(R.id.bt_main);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Cellar.class));
            }
        });
    }
}
