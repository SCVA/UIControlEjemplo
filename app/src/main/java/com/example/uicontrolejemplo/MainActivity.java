package com.example.uicontrolejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView miPrimerTexto;
    Button miPrimerBotton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        miPrimerTexto = (TextView) findViewById(R.id.textoCambiar);
        miPrimerBotton = (Button) findViewById(R.id.button);
    }


    public void onClick(View v){
        switch(v.getId()){
            case R.id.button:
                if(miPrimerTexto.getText().equals(getText(R.string.texto_2))){
                    miPrimerBotton.setEnabled(false);
                    miPrimerBotton.setVisibility(View.INVISIBLE);
                    miPrimerTexto.setText(R.string.texto_3);
                    miPrimerTexto.setTextColor(Color.parseColor("#FF0000"));
                }
                else{
                    miPrimerTexto.setText(R.string.texto_2);
                }
                break;
            default:
                break;
        }
    }
}