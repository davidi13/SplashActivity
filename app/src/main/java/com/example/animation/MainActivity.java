package com.example.animation;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Encontrar las vistas
        TextView topTitle = findViewById(R.id.TextViewTopTitle);
        TextView bottomTitle = findViewById(R.id.TextViewBottomTitle);
        TableLayout tableLayout = findViewById(R.id.TableLayout01);

        // Cargar las animaciones
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fade_in);
        Animation fadeIn2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
        Animation customAnim = AnimationUtils.loadAnimation(this, R.anim.custom_anim);

        // Aplicar la animación fade_in al TextView superior
        topTitle.startAnimation(fadeIn);

        // Aplicar la animación fade_in2 al TextView inferior (espera 2.5 segundos y luego fade in)
        fadeIn2.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                // Cuando la animación fade_in2 termine, inicia la nueva actividad
                startActivity(new Intent(MainActivity.this, QuizMenuActivity.class));
                finish(); // No queremos que el Splash Screen siga en el stack
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
        bottomTitle.startAnimation(fadeIn2);

        // Aplicar la animación a cada TableRow en el TableLayout
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            row.startAnimation(customAnim); // Animación de rotación, escala y fade
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Detener las animaciones cuando la actividad se pause
        TextView topTitle = findViewById(R.id.TextViewTopTitle);
        topTitle.clearAnimation();
        TextView bottomTitle = findViewById(R.id.TextViewBottomTitle);
        bottomTitle.clearAnimation();
        TableLayout tableLayout = findViewById(R.id.TableLayout01);
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow row = (TableRow) tableLayout.getChildAt(i);
            row.clearAnimation();
        }
    }
}
