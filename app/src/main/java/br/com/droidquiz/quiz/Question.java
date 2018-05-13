package br.com.droidquiz.quiz;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kaio César Bezerra da Silva on 10/05/2018.
 */

public class Question {
    private Integer pergunta;
    private List<Integer> alternativas = new ArrayList<>();
    private Integer respostaCorreta;

    public Question(Integer pergunta, Integer alternativas1, Integer alternativas2, Integer alternativas3,
                    Integer alternativas4, Integer respostaCorreta) {
        this.pergunta = pergunta;
        this.alternativas.add(alternativas1);
        this.alternativas.add(alternativas2);
        this.alternativas.add(alternativas3);
        this.alternativas.add(alternativas4);
        this.respostaCorreta = respostaCorreta;
    }

    public Integer getPergunta() {
        return this.pergunta;
    }

    public void setPergunta(Integer pergunta) {
        this.pergunta = pergunta;
    }

    public List<Integer> getAlternativas() {
        return this.alternativas;
    }

    public void setAlternativas(List<Integer> alternativas) {
        this.alternativas = alternativas;
    }

    public Integer getRespostaCorreta() {
        return this.respostaCorreta;
    }

    public void setRespostaCorreta(Integer respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

}
