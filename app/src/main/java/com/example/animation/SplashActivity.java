package com.example.animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Encontrar el ImageView
        ImageView imageView = findViewById(R.id.imageview);

        // Cargar la animación
        Animation customAnimation = AnimationUtils.loadAnimation(this, R.anim.custom_anim);

        // Aplicar la animación al ImageView
        imageView.startAnimation(customAnimation);

        // Listener para redirigir después de la animación
        customAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // Opcional: acciones al iniciar la animación
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // Redirigir a MainActivity al terminar la animación
                startActivity(new Intent(SplashActivity.this, MainActivity.class));
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // Opcional: acciones en repetición de la animación
            }
        });
    }
}
