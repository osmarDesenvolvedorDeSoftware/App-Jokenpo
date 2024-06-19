package com.example.jogopapelpedratesoura;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

        String escolhaUsuario,escolhaMaquina;
        ImageView minhaImagem;
        ImageView resultado;
        int contaGanhou = 0,contaPerdeu =0,contaEmpatou =0;

        TextView texto,ganhou,perdeu,empatou;

     public void novoJogo(View view){

         contaGanhou=0;
         contaEmpatou=0;
         contaPerdeu=0;
         ganhou.setText(String.valueOf(contaGanhou));
         perdeu.setText(String.valueOf(contaPerdeu));
         empatou.setText(String.valueOf(contaEmpatou));

     }


      public void selecionarPedra(View view){

        escolhaUsuario = "pedra";
        escolhaMaquina();
        verificarGanhador();


    }

    public void selecionarPapel(View view){

        escolhaUsuario = "papel";
        escolhaMaquina();
        verificarGanhador();
    }


    public void selecionarTesoura(View view){

        escolhaUsuario = "tesoura";
        escolhaMaquina();
        verificarGanhador();
    }


    public String escolhaMaquina(){

        String[] gerado = {"papel","pedra","tesoura"};

        int numeroAleatorio = new Random().nextInt(3);

        this.escolhaMaquina = gerado[numeroAleatorio];
        trocarImagem();

         return this.escolhaMaquina;
    }

        public void trocarImagem(){

          switch (escolhaMaquina){

              case "pedra":

                  minhaImagem = findViewById(R.id.imgMaquina);
                  minhaImagem.setImageResource(R.drawable.pedra);
                  break;

              case "papel":

                  minhaImagem = findViewById(R.id.imgMaquina);
                  minhaImagem.setImageResource(R.drawable.papel);
                  break;

              case "tesoura":

                  minhaImagem = findViewById(R.id.imgMaquina);
                  minhaImagem.setImageResource(R.drawable.tesoura);
                  break;


            }


    }

    public void verificarGanhador(){

            if (( escolhaUsuario == "pedra" && escolhaMaquina == "tesoura") ||
               ( escolhaUsuario == "papel" && escolhaMaquina == "pedra") ||
               ( escolhaUsuario == "tesoura" && escolhaMaquina == "papel") ){

                resultado = findViewById(R.id.imgResultado);
                resultado.setImageResource(R.drawable.ganhou);
                texto = findViewById(R.id.txtResultado);
                texto.setText("Ganhou");
                contaGanhou++;
                ganhou = findViewById(R.id.txtPlacarGanhou);
                ganhou.setText(String.valueOf(contaGanhou));


            }else if (( escolhaMaquina == "pedra" && escolhaUsuario == "tesoura") ||
                    ( escolhaMaquina == "papel" && escolhaUsuario == "pedra") ||
                    ( escolhaMaquina == "tesoura" && escolhaUsuario == "papel") ){

                resultado = findViewById(R.id.imgResultado);
                resultado.setImageResource(R.drawable.perdeu);
                texto = findViewById(R.id.txtResultado);
                texto.setText("Perdeu");
                contaPerdeu++;
                perdeu= findViewById(R.id.txtPlacarPerdeu);
                perdeu.setText(String.valueOf(contaPerdeu));
            }else{

                resultado = findViewById(R.id.imgResultado);
                resultado.setImageResource(R.drawable.empatou);
                texto = findViewById(R.id.txtResultado);
                texto.setText("Empatou");
                contaEmpatou++;
                empatou = findViewById(R.id.txtPlacarEmpatou);
                empatou.setText(String.valueOf(contaEmpatou));
            }




    }







}