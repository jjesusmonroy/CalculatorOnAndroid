package com.example.jjesusmonroy.calculadora;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Calculadora extends AppCompatActivity {
    EditText cajatexto;
    Boolean banderapunto,banderasigno;
    Button uno,dos,tres,cuatro,cinco,seis,siete,ocho,nueve,por,menos,mas,dividir,igual,punto,limpiar,cero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        banderapunto=false;
        banderasigno=false;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        cajatexto=findViewById(R.id.caja);
        uno = findViewById(R.id.uno);
        dos = findViewById(R.id.dos);
        tres = findViewById(R.id.tres);
        cuatro = findViewById(R.id.cuatro);
        cinco = findViewById(R.id.cinco);
        seis = findViewById(R.id.seis);
        siete = findViewById(R.id.siete);
        ocho = findViewById(R.id.ocho);
        nueve = findViewById(R.id.nueve);
        por = findViewById(R.id.por);
        menos = findViewById(R.id.menos);
        mas = findViewById(R.id.mas);
        dividir = findViewById(R.id.dividir);
        igual = findViewById(R.id.igual);
        punto = findViewById(R.id.punto);
        limpiar = findViewById(R.id.clean);
        cero = findViewById(R.id.cero);

        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.append("0");
            }
        });
        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.append("1");
            }
        });
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.append("2");
            }
        });
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.append("3");
            }
        });
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.append("4");
            }
        });
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.append("5");
            }
        });
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.append("6");
            }
        });
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.append("7");
            }
        });
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.append("8");
            }
        });
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.append("9");
            }
        });
        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(banderapunto==false){cajatexto.append(".");}
                banderapunto=true;
            }
        });
        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!banderasigno) {
                    int length = cajatexto.getText().toString().length();
                    String a = cajatexto.getText().toString().substring(length - 1);
                    if (a.equals("-") || a.equals("*") || a.equals("/")) {
                        cajatexto.setText(cajatexto.getText().toString().substring(0, length - 1) + "+");
                        banderasigno = true;
                    }
                    cajatexto.append("+");
                    banderasigno = true;
                    banderapunto = false;
                }
            }
        });
        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = cajatexto.getText().toString().length();
                String a=cajatexto.getText().toString().substring(length-1);
                if(a.equals("+") || a.equals("*") || a.equals("/")){
                    cajatexto.setText(cajatexto.getText().toString().substring(0,length-1)+"-");
                    banderasigno=true;
                }
                if(!banderasigno){cajatexto.append("-");
                    banderasigno=true;
                }
                banderapunto=false;
            }
        });
        por.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = cajatexto.getText().toString().length();
                String a=cajatexto.getText().toString().substring(length-1);
                if(a.equals("-") || a.equals("+") || a.equals("/")){
                    cajatexto.setText(cajatexto.getText().toString().substring(0,length-1)+"*");
                    banderasigno=true;
                }
                if(!banderasigno){cajatexto.append("*");
                    banderasigno=true;
                }
                banderapunto=false;
            }
        });
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int length = cajatexto.getText().toString().length();
                String a=cajatexto.getText().toString().substring(length-1);
                if(a.equals("-") || a.equals("*") || a.equals("+")){
                    cajatexto.setText(cajatexto.getText().toString().substring(0,length-1)+"/");
                    banderasigno=true;
                }
                if(!banderasigno){cajatexto.append("/");
                    banderasigno=true;
                }
                banderapunto=false;
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                banderasigno=false;
                String [] cadena = cajatexto.getText().toString().split("");
                for(int i=0;i<cadena.length;i++){
                    if(cadena[i].equals("+")){
                        Double a = Double.parseDouble(cajatexto.getText().toString().substring(0,i-1));
                        Double b = Double.parseDouble(cajatexto.getText().toString().substring(i));
                        Double mas = a+b;
                        cajatexto.setText("");
                        cajatexto.append(mas+"");
                        banderasigno=false;
                        banderapunto=false;
                    }
                    if(cadena[i].equals("-")){
                        Double c = Double.parseDouble(cajatexto.getText().toString().substring(0,i-1));
                        Double d = Double.parseDouble(cajatexto.getText().toString().substring(i));
                        Double menos =c-d;
                        cajatexto.setText("");
                        cajatexto.append(menos+"");
                        banderasigno=false;
                        banderapunto=false;
                    }
                    if(cadena[i].equals("*")){
                        Double g = Double.parseDouble(cajatexto.getText().toString().substring(0,i-1));
                        Double h = Double.parseDouble(cajatexto.getText().toString().substring(i));
                        Double por = g*h;
                        cajatexto.setText("");
                        cajatexto.append(por+"");
                        banderasigno=false;
                        banderapunto=false;
                    }
                    if(cadena[i].equals("/")){
                        Double e = Double.parseDouble(cajatexto.getText().toString().substring(0,i-1));
                        Double f = Double.parseDouble(cajatexto.getText().toString().substring(i));
                        if(f==0.0){return;}
                        Double dividir = e/f;
                        cajatexto.setText("");
                        cajatexto.append(dividir+"");
                        banderasigno=false;
                        banderapunto=false;
                    }
                }
            }
        });
        limpiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cajatexto.setText("");
                banderasigno=false;
                banderapunto=false;
            }
        });

    }

}
