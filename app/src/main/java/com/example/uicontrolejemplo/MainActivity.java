package com.example.uicontrolejemplo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    TextView miPrimerTexto;
    Button miPrimerBotton;
    CheckBox miPrimerCheck;
    Switch miPrimerSwtich;
    RadioButton miPrimerBotonGrupal;
    RadioButton miSegundoBotonGrupal;
    RadioGroup miPrimerGrupo;
    Spinner miPrimerSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(this);
        miPrimerTexto = (TextView) findViewById(R.id.textoCambiar);
        miPrimerBotton = (Button) findViewById(R.id.button);
        miPrimerCheck = (CheckBox) findViewById(R.id.checkBox);
        miPrimerCheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (miPrimerCheck.isChecked()){
                    miPrimerBotton.setBackgroundColor(Color.parseColor("#FFFF00"));
                }else{
                    miPrimerBotton.setBackgroundColor(Color.parseColor("#0000FF"));
                }
            }
        });
        miPrimerSwtich = (Switch) findViewById(R.id.switch1);
        miPrimerSwtich.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (miPrimerSwtich.isChecked()){
                    miPrimerTexto.setTextSize(28);
                }else{
                    miPrimerTexto.setTextSize(14);
                }
            }
        });
        miPrimerBotonGrupal = (RadioButton) findViewById(R.id.radioButton);
        miSegundoBotonGrupal = (RadioButton) findViewById(R.id.radioButton2);
        miPrimerGrupo = (RadioGroup) findViewById(R.id.radioGroup);
        miPrimerGrupo.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.radioButton:
                        miPrimerSwtich.setEnabled(true);
                        break;
                    case R.id.radioButton2:
                        miPrimerSwtich.setEnabled(false);
                        break;
                }
            }
        });
        miPrimerSpinner = (Spinner) findViewById(R.id.spinner);
        miPrimerSpinner.setOnItemSelectedListener(this);
    }


    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String seleccion = adapterView.getItemAtPosition(i).toString();
        miPrimerTexto.setText(seleccion);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

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