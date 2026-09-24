package com.example.chamadotecnico;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.appbar.MaterialToolbar;

public class SobreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sobre);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        MaterialToolbar toolbar = findViewById(R.id.toolBarTop);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        EditText edtNomeContato = findViewById(R.id.edtNomeContato);
        EditText edtEmailContato = findViewById(R.id.edtEmailContato);
        EditText edtMensagemContato = findViewById(R.id.edtMensagemContato);
        Button btnEnviarContato = findViewById(R.id.btnEnviarContato);

        btnEnviarContato.setOnClickListener(v -> {
            String nome = edtNomeContato.getText().toString().trim();
            String email = edtEmailContato.getText().toString().trim();
            String mensagem = edtMensagemContato.getText().toString().trim();

            if (nome.isEmpty()) {
                edtNomeContato.setError("Digite seu nome");
                return;
            }
            if (email.isEmpty()) {
                edtEmailContato.setError("Digite seu e-mail");
                return;
            }
            if (mensagem.isEmpty()) {
                edtMensagemContato.setError("Digite sua mensagem");
                return;
            }

            Toast.makeText(SobreActivity.this,
                    "Mensagem enviada, obrigado pelo contato!",
                    Toast.LENGTH_SHORT
            ).show();

            edtNomeContato.setText("");
            edtEmailContato.setText("");
            edtMensagemContato.setText("");
        });
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_top, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_config) {
            startActivity(new Intent(this, ConfiguracoesActivity.class));
            return true;
        }
        if (item.getItemId() == R.id.menu_sobre) {
            startActivity(new Intent(this, SobreActivity.class));
            return true;
        }
        if (item.getItemId() == R.id.menu_cadastro) {
            startActivity(new Intent(this, CadastroActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
