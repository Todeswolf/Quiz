package com.example.quiz;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Layout-Elemente verknüpfen
        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(v -> {
            String username = usernameEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Prüfen, ob Felder leer sind
            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(LoginActivity.this, "Bitte alle Felder ausfüllen!", Toast.LENGTH_SHORT).show();
                return;
            }

            // API-URL für Login
            String url = "https://your-api-url/login";

            // Daten an die API senden
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    response -> {
                        if (response.equals("success")) {
                            Toast.makeText(LoginActivity.this, "Willkommen!", Toast.LENGTH_SHORT).show();
                            // Weiter zur Hauptseite oder Dashboard
                        } else {
                            Toast.makeText(LoginActivity.this, "Benutzername oder Passwort falsch!", Toast.LENGTH_SHORT).show();
                        }
                    },
                    error -> Toast.makeText(LoginActivity.this, "Fehler beim Login!", Toast.LENGTH_SHORT).show()) {

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("username", username);
                    params.put("password", password);
                    return params;
                }
            };

            // Anfrage in die Warteschlange einfügen
            RequestQueue queue = Volley.newRequestQueue(this);
            queue.add(stringRequest);
        });
    }
}

