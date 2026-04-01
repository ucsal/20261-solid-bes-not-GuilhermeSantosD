package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.Questao;
import java.util.List;

public interface IQuestaoRepository {
    void salvar(Questao questao);
    List<Questao> listarTodas();
    List<Questao> buscarPorProvaId(long provaId);
}
