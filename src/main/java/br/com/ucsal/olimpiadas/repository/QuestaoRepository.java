package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.Questao;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class QuestaoRepository {

    private List<Questao> questoes = new ArrayList<>();

    private long proximoId = 1;

    public void salvar(Questao questao) {

        if (questao.getId() == 0) {

            questao.setId(proximoId++);
        }
        questoes.add(questao);
    }

    public List<Questao> listarTodas() {

        return new ArrayList<>(questoes);
    }

    public List<Questao> buscarPorProvaId(long provaId) {

        return questoes.stream()
                .filter(q -> q.getProvaId() == provaId)
                .collect(Collectors.toList());
    }
}
