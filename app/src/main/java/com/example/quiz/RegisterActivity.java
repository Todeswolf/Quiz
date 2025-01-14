package com.example.quiz;

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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        // Layout-Elemente verknüpfen
        EditText emailEditText = findViewById(R.id.emailEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button btnOkay = findViewById(R.id.btnOkay);

        btnOkay.setOnClickListener(v -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Prüfen, ob Felder leer sind
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(RegisterActivity.this, "Bitte alle Felder ausfüllen!", Toast.LENGTH_SHORT).show();
                return;
            }

            // API-URL (Mock API in Postman verwenden)
            String url = "https://your-api-url/register";

            // Daten an die API senden
            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    response -> {
                        Toast.makeText(RegisterActivity.this, "Registrierung erfolgreich!", Toast.LENGTH_SHORT).show();
                        finish(); // Zurück zum Hauptmenü
                    },
                    error -> Toast.makeText(RegisterActivity.this, "Fehler bei der Registrierung!", Toast.LENGTH_SHORT).show()) {

                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("email", email);
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

