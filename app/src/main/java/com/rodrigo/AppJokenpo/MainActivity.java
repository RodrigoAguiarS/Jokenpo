package com.rodrigo.AppJokenpo;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionarPedra(View view){
        this.opcaoSelecionada("pedra");
    }
    public void selecionarPapel(View view){
        this.opcaoSelecionada("papel");
    }
    public void selecionarTesoura(View view){
        this.opcaoSelecionada("tesoura");
    }
    @SuppressLint("SetTextI18n")
    public void opcaoSelecionada(String escolhaUsuario){
        ImageView imagemResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textResultado);

        //gerar número aleatório para escolha do App
        String[] opcoes = {"pedra", "papel", "tesoura"};
        int numero = new Random().nextInt(3);
        String escolhaApp = opcoes[numero];
        switch ( escolhaApp ){
            case "pedra" :
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura" :
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }
        if (
                (escolhaApp.equals("pedra") && escolhaUsuario.equals("tesoura")) ||
                        (escolhaApp.equals("papel") && escolhaUsuario.equals("pedra")) ||
                        (escolhaApp.equals("tesoura") && escolhaUsuario.equals("papel"))
        ){
            //App ganhador
            textoResultado.setText("Você perdeu :( ");
        }else if (
                (escolhaUsuario.equals("pedra") && escolhaApp.equals("tesoura")) ||
                        (escolhaUsuario.equals("papel") && escolhaApp.equals("pedra")) ||
                        (escolhaUsuario.equals("tesoura") && escolhaApp.equals("papel"))
        ){
            //Usuario ganhador
            textoResultado.setText("Você ganhou :) ");
        }else {//Empate
            textoResultado.setText("Empatamos ;) ");
        }
    }
}