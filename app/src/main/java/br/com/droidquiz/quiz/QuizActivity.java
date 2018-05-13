package br.com.droidquiz.quiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuizActivity extends AppCompatActivity {
    private TextView pergunta;
    private Button btn_answer1;
    private Button btn_answer2;
    private Button btn_answer3;
    private Button btn_answer4;
    private int mPontuacao = 0;
    private int indicePergunta = 0;

    private List<Question> questao = new ArrayList<Question>() {
        {
            add(new Question(R.string.pergunta1, R.string.alternativaA1, R.string.alternativaB1, R.string.alternativaC1, R.string.alternativaD1, R.string.alternativaC1));
            add(new Question(R.string.pergunta2, R.string.alternativaA2, R.string.alternativaB2, R.string.alternativaC2, R.string.alternativaD2, R.string.alternativaC2));
            add(new Question(R.string.pergunta3, R.string.alternativaA3, R.string.alternativaB3, R.string.alternativaC3, R.string.alternativaD3, R.string.alternativaA3));
            add(new Question(R.string.pergunta4, R.string.alternativaA4, R.string.alternativaB4, R.string.alternativaC4, R.string.alternativaD4, R.string.alternativaB4));
            add(new Question(R.string.pergunta5, R.string.alternativaA5, R.string.alternativaB5, R.string.alternativaC5, R.string.alternativaD5, R.string.alternativaA5));
            add(new Question(R.string.pergunta6, R.string.alternativaA6, R.string.alternativaB6, R.string.alternativaC6, R.string.alternativaD6, R.string.alternativaD6));
            add(new Question(R.string.pergunta7, R.string.alternativaA7, R.string.alternativaB7, R.string.alternativaC7, R.string.alternativaD7, R.string.alternativaC7));
            add(new Question(R.string.pergunta8, R.string.alternativaA8, R.string.alternativaB8, R.string.alternativaC8, R.string.alternativaD8, R.string.alternativaC8));
            add(new Question(R.string.pergunta9, R.string.alternativaA9, R.string.alternativaB9, R.string.alternativaC9, R.string.alternativaD9, R.string.alternativaB9));
            add(new Question(R.string.pergunta10, R.string.alternativaA10, R.string.alternativaB10, R.string.alternativaC10, R.string.alternativaD10, R.string.alternativaC10));
            add(new Question(R.string.pergunta11, R.string.alternativaA11, R.string.alternativaB11, R.string.alternativaC11, R.string.alternativaD11, R.string.alternativaA11));
            add(new Question(R.string.pergunta12, R.string.alternativaA12, R.string.alternativaB12, R.string.alternativaC12, R.string.alternativaD12, R.string.alternativaD12));
            add(new Question(R.string.pergunta13, R.string.alternativaA13, R.string.alternativaB13, R.string.alternativaC13, R.string.alternativaD13, R.string.alternativaA13));
            add(new Question(R.string.pergunta14, R.string.alternativaA14, R.string.alternativaB14, R.string.alternativaC14, R.string.alternativaD14, R.string.alternativaD14));
            add(new Question(R.string.pergunta15, R.string.alternativaA15, R.string.alternativaB15, R.string.alternativaC15, R.string.alternativaD15, R.string.alternativaB15));
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        Collections.shuffle(questao);
        Toast.makeText(this, R.string.mensagem, Toast.LENGTH_SHORT).show();

        pergunta = (TextView) findViewById(R.id.pergunta);
        pergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizarIndece();
                atualizarPergunta();
            }
        });

        btn_answer1 = (Button) findViewById(R.id.btn_alternativa1);
        btn_answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarResposta(questao.get(indicePergunta).getAlternativas().get(0));
            }
        });

        btn_answer2 = (Button) findViewById(R.id.btn_alternativa2);
        btn_answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarResposta(questao.get(indicePergunta).getAlternativas().get(1));
            }
        });

        btn_answer3 = (Button) findViewById(R.id.btn_alternativa3);
        btn_answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarResposta(questao.get(indicePergunta).getAlternativas().get(2));
            }
        });

        btn_answer4 = (Button) findViewById(R.id.btn_alternativa4);
        btn_answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checarResposta(questao.get(indicePergunta).getAlternativas().get(3));
            }
        });

    }

    private void checarResposta(int respostaUsuario) {
        Intent intent = new Intent(this, AnswerActivity.class);
        Integer resposta = questao.get(indicePergunta).getRespostaCorreta();

        if(resposta == respostaUsuario) {
            intent.putExtra("acertou", true);
            mPontuacao++;
        } else {
            intent.putExtra("acertou", false);
        }

        questao.remove(indicePergunta);
        atualizarIndece();
        atualizarPergunta();
        intent.putExtra("pontos", mPontuacao);
        startActivity(intent);

    }

    private void atualizarPergunta() {
        if(questao.size() >= 5) {
            pergunta.setText(questao.get(indicePergunta).getPergunta());
            List<Integer> altenativasLista = questao.get(indicePergunta).getAlternativas();
            Collections.shuffle(altenativasLista);
            btn_answer1.setText(altenativasLista.get(0));
            btn_answer2.setText(altenativasLista.get(1));
            btn_answer3.setText(altenativasLista.get(2));
            btn_answer4.setText(altenativasLista.get(3));
        } else {
            Intent intent = new Intent(this, AnswerActivity.class);
            intent.putExtra("pontos", mPontuacao);
            startActivity(intent);
            finish();
        }
    }

    private void atualizarIndece() {
        indicePergunta = (indicePergunta + 1) % questao.size();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        atualizarIndece();
        atualizarPergunta();
    }

    @Override
    protected void onStart() {
        super.onStart();
        atualizarIndece();
        atualizarPergunta();
    }

}
