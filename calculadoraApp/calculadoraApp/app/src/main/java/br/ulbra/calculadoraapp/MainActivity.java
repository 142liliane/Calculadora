package br.ulbra.calculadoraapp;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText Val1, Val2;
    private Button btnSomar, btnSub, btnMult, btnDiv;
    private TextView result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        Val1 = findViewById(R.id.editVal1);
        Val2 = findViewById(R.id.editVal2);
        btnSomar = findViewById(R.id.btnSomar);
        btnSub = findViewById(R.id.btnSub);
        btnMult = findViewById(R.id.btnMult);
        btnDiv = findViewById(R.id.btnDiv);
        result = findViewById(R.id.txtResultado);

        // Botão de Somar
        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular("+");
            }
        });

        // Botão de Subtrair
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular("-");
            }
        });

        // Botão de Multiplicar
        btnMult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular("*");
            }
        });

        // Botão de Dividir
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular("/");
            }
        });
    }

    private void calcular(String operador) {
        String strNum1 = Val1.getText().toString();
        String strNum2 = Val2.getText().toString();

        if (strNum1.isEmpty() || strNum2.isEmpty()) {
            Toast.makeText(this, "Insira ambos os números", Toast.LENGTH_SHORT).show();
            return;
        }

        double numero1 = Double.parseDouble(strNum1);
        double numero2 = Double.parseDouble(strNum2);
        double resultado = 0;

        switch (operador) {
            case "+":
                resultado = numero1 + numero2;
                break;
            case "-":
                resultado = numero1 - numero2;
                break;
            case "*":
                resultado = numero1 * numero2;
                break;
            case "/":
                if (numero2 != 0) {
                    resultado = numero1 / numero2;
                } else {
                    Toast.makeText(this, "Divisão por zero não é permitida", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
        }

        result.setText("Resultado: " + resultado);
}
}