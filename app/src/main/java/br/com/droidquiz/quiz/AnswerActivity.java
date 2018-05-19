package br.com.droidquiz.quiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AnswerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().hide();

        ImageView imgResposta = (ImageView) findViewById(R.id.imgView);
        TextView resposta = (TextView) findViewById(R.id.resposta);

        Intent intent = getIntent();
        int mPontuacao = intent.getIntExtra("pontos", 0);
        Button btnJogarNovamente = (Button) findViewById(R.id.btn_jogarnovamente);

        if(intent.hasExtra("acertou")) {
            btnJogarNovamente.setVisibility(View.INVISIBLE);
            boolean respostaUsuario = intent.getBooleanExtra("acertou", false);

            if(respostaUsuario) {
                imgResposta.setImageResource(R.mipmap.ic_launcher_positivo);
                resposta.setText("Acertou! Sua potuação: "+ mPontuacao);
            } else {
                imgResposta.setImageResource(R.mipmap.ic_launcher_negativo);
                resposta.setText("Errou! Sua potuação: "+ mPontuacao);
            }

            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    finish();
                }
            });
            thread.start();
        } else {
            btnJogarNovamente.setVisibility(View.VISIBLE);

            if(mPontuacao >= 7) {
                resposta.setText("Parabéns, você fez "+mPontuacao+" pontos!");
                imgResposta.setImageResource(R.mipmap.ic_launcher_feliz);
            } else if(mPontuacao >= 4 && mPontuacao <= 6) {
                resposta.setText("Moderado, você fez "+mPontuacao+" pontos!");
                imgResposta.setImageResource(R.mipmap.ic_launcher_pensativo);
            } else {
                resposta.setText("Péssimo, você fez "+mPontuacao+" pontos!");
                imgResposta.setImageResource(R.mipmap.ic_launcher_triste);
            }
        }
    }

    public void btnJogarNovamenteOnClick(View v) {
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
        finish();
    }

}
