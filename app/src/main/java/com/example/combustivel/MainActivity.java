package com.example.combustivel;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    //Instanciando dos elementos como objeto

    private textInputEditText textInputgasolina;
    private textInputEditText textInputAlcool;
    private textView textResultado;
    private Button btncCalcular;
    private Button btnLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        //Vincule o objeto com o R.id no front

        textInputAlcool = findViewById(R.id.textinputalcool);
        textinputgasolina = findViewById(R.id.textinputgasolina);
        textResultado = findViewById(R.id.textResultado);
        btncCalcular = findViewById(R.id.btnCalcular);
        btnLimpar = findViewById(R.id.btnLimpar);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    public void calcular(View view){
        String precoAlcool = textInputAlcool.getText().toString();
        String precoGasolina = textinputgasolina.getText().toString();
        //Chama o metodo validadados e confirma que não estão null ou "";
        Boolean resultado = validaDados(precoAlcool, precoGasolina);

        if(resultado){
            //processa a informacao
            //Converter string para -> numerico(double)
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);

            //compara a diferenca entre os conbustiveis
            double calculaResultado = valorAlcool/valorGasolina;
            //Analisa o combustivel que vale a pena;
            if(calculaResultado >= 0.7){
                textResultado.setText("Melhor Gasolina");
            }else{
                textResultado.setText("Melhor Alcool");
            }
        }else{
            //Apresenta um erro para o usuario caso dados invalidos
            textResultado.setText("ERRO >> COD.51");
        }
    }

    public Boolean validaDados(String pAlcool, String pGasolina){
        Boolean campoValidado = true;

        if(pAlcool == null || pAlcool.equals("")){
            campoValidado = false;
        }else if(pGasolina == null || pGasolina.equals("")){
            return campoValidado = false;
        }
        return campoValidado;
    }

    public void limpar(View view){

    }
}