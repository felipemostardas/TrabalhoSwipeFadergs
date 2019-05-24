package com.example.trabalhoswipefadergs;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout layoutContainer;
    private TextView tvRegBR;
    private TextView tvUF;
    private String[] regiao;
    private String[][] estado;
    private ImageView ivTop, ivBottom;
    private int contador, contadorEstados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutContainer = (LinearLayout) findViewById(R.id.LayoutContainer);
        tvRegBR =  (TextView) findViewById(R.id.tvRegiao);
        tvUF = (TextView) findViewById(R.id.tvEstados);
        contador = 0;
        contadorEstados = 0;

        regiao = new String[] {

                "Centro-Oeste",
                "Nordeste",
                "Norte",
                "Sul",
                "Sudeste"


        };

        estado = new String[][] {
                {"Distrito Federal", "Goiás", "Mato Grosso", "Mato Grosso do Sul"},
                {"Alagoas", "Bahia", "Ceará", "Maranhão", "Paraíba", "Pernambuco", "Piauí", "Rio Grande do Norte", "Sergipe"},
                { "Acre",  "Amapá", "Amazonas","Pará"," Rondônia", "Roraima", "Tocantins"},
                {"Paraná","Rio Grande do Sul", "Santa Catarina"},
                {"Espírito Santo", "Minas Gerais", "Rio de Janeiro", "São Paulo"},


        };

        //inicialização
        tvRegBR.setText( regiao[contador]);
        tvUF.setText(estado[contador][contadorEstados]);

        layoutContainer.setOnTouchListener( new OnSwipeTouchListener(this){

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                contadorEstados ++;
                if (contadorEstados >= estado[contador].length){
                    contadorEstados = 0;
                }
                tvUF.setText(estado[contador][contadorEstados]);
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                contadorEstados --;
                if(contadorEstados < 0 ){
                    contadorEstados = estado[contador].length-1;
                }
                tvUF.setText(estado[contador][contadorEstados]);
            }

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();

                contador ++;
                if (contador >= regiao.length){
                    contador = 0;
                }
                tvRegBR.setText(regiao[contador]);
                contadorEstados = 0;
                tvUF.setText(estado[contador][contadorEstados]);
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                contador --;
                if(contador < 0 ){
                    contador = regiao.length-1;
                }
                tvRegBR.setText( regiao[contador]);
                contadorEstados = 0;
                tvUF.setText(estado[contador][contadorEstados]);
            }
        });
    }
}
