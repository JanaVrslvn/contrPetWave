package com.example.contrpetwave;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class MainActivity extends AppCompatActivity {

    private View layoutEncontrarPers;
    private ImageView myPhoto, anim, anim2;
    private Handler handlerAnimationCIMG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        Glide.with(getBaseContext()).load(R.drawable.img).apply(new RequestOptions().circleCrop()).into(myPhoto);

        findViewById(R.id.buttonStar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTask();
            }
        });
        findViewById(R.id.buttonStar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTask();
            }
        });
    }

    private void init() {
        this.handlerAnimationCIMG = new Handler();
        this.layoutEncontrarPers = findViewById(R.id.layoutPers);
        this.myPhoto = findViewById(R.id.myPhoto);
        this.anim = findViewById(R.id.anim);
        this.anim2 = findViewById(R.id.anim2);
    }

    private void startTask(){
        this.runnableAnim.run();
        this.layoutEncontrarPers.setVisibility(View.VISIBLE);
    }

    private void stopTask(){
        this.handlerAnimationCIMG.removeCallbacks(runnableAnim);
        this.layoutEncontrarPers.setVisibility(View.GONE);
    }

    private Runnable runnableAnim = new Runnable() {
        @Override
        public void run() {


            anim.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(1000).withEndAction(new Runnable() {
                @Override
                public void run() {
                    anim.setScaleX(1f);
                    anim.setScaleY(1f);
                    anim.setAlpha(1f);
                }
            });

            anim2.animate().scaleX(4f).scaleY(4f).alpha(0f).setDuration(700).withEndAction(new Runnable() {
                @Override
                public void run() {
                    anim2.setScaleX(1f);
                    anim2.setScaleY(1f);
                    anim2.setAlpha(1f);
                }
            });

            handlerAnimationCIMG.postDelayed(runnableAnim, 1500);
        }
    };


}
