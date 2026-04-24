package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.Questao;
import br.com.ucsal.olimpiadas.Tentativa;
import java.util.List;

public interface IOlimpiadaService {
    void cadastrarParticipante(String nome, String email);
    void cadastrarProva(String titulo);
    void cadastrarQuestao(long provaId, String enunciado, String[] alternativas, char correta);
    List<Questao> buscarQuestoesPorProva(long provaId);
    void salvarTentativa(Tentativa tentativa);
    int calcularNota(Tentativa tentativa);
    List<Tentativa> listarTentativas();
}
