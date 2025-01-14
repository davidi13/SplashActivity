package com.example.animation;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class QuizMenuActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        // Obtén el ListView por su ID
        ListView menuList = findViewById(R.id.ListView_Menu);

        // Define los elementos del menú como un array de strings
        String[] items = {
                getResources().getString(R.string.menu_item_play),
                getResources().getString(R.string.menu_item_scores),
                getResources().getString(R.string.menu_item_settings),
                getResources().getString(R.string.menu_item_help)
        };

        // Configura un adaptador para enlazar los datos al diseño de cada elemento
        ArrayAdapter<String> adapt = new ArrayAdapter<>(
                this,
                R.layout.menu_item, // Diseño del layout para cada elemento
                items               // Datos a mostrar
        );

        // Asigna el adaptador al ListView
        menuList.setAdapter(adapt);

        // Puedes agregar un listener para manejar clics en los elementos del menú
        menuList.setOnItemClickListener((parent, view, position, id) -> {
            switch (position) {
                case 0:
                    // Acción para "Play Game"
                    // startActivity(new Intent(this, PlayGameActivity.class));
                    break;
                case 1:
                    // Acción para "View Scores"
                    // startActivity(new Intent(this, ViewScoresActivity.class));
                    break;
                case 2:
                    // Acción para "Settings"
                    // startActivity(new Intent(this, SettingsActivity.class));
                    break;
                case 3:
                    // Acción para "Help"
                    // startActivity(new Intent(this, HelpActivity.class));
                    break;
            }
        });
    }
}
