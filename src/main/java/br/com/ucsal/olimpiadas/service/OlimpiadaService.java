package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.Participante;
import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.Questao;
import br.com.ucsal.olimpiadas.Tentativa;
import br.com.ucsal.olimpiadas.repository.ParticipanteRepository;
import br.com.ucsal.olimpiadas.repository.ProvaRepository;
import br.com.ucsal.olimpiadas.repository.QuestaoRepository;
import br.com.ucsal.olimpiadas.repository.TentativaRepository;
import java.util.List;

public class OlimpiadaService {

    private final ParticipanteRepository participanteRepository;
    private final ProvaRepository provaRepository;
    private final QuestaoRepository questaoRepository;
    private final TentativaRepository tentativaRepository;

    public OlimpiadaService(ParticipanteRepository participanteRepository,
                            ProvaRepository provaRepository,
                            QuestaoRepository questaoRepository,
                            TentativaRepository tentativaRepository) {
        this.participanteRepository = participanteRepository;
        this.provaRepository = provaRepository;
        this.questaoRepository = questaoRepository;
        this.tentativaRepository = tentativaRepository;
    }

    public void cadastrarParticipante(String nome, String email) {
        var p = new Participante();
        p.setNome(nome);
        p.setEmail(email);
        participanteRepository.salvar(p);
    }

    public void cadastrarProva(String titulo) {
        var prova = new Prova();
        prova.setTitulo(titulo);
        provaRepository.salvar(prova);
    }

    public void cadastrarQuestao(long provaId, String enunciado, String[] alternativas, char correta) {
        var q = new Questao();
        q.setProvaId(provaId);
        q.setEnunciado(enunciado);
        q.setAlternativas(alternativas);
        q.setAlternativaCorreta(correta);
        questaoRepository.salvar(q);
    }

    public List<Questao> buscarQuestoesPorProva(long provaId) {
        return questaoRepository.buscarPorProvaId(provaId);
    }

    public void salvarTentativa(Tentativa tentativa) {
        tentativaRepository.salvar(tentativa);
    }

    public int calcularNota(Tentativa tentativa) {
        int acertos = 0;
        for (var r : tentativa.getRespostas()) {
            if (r.isCorreta())
                acertos++;
        }
        return acertos;
    }

    public List<Tentativa> listarTentativas() {
        return tentativaRepository.listarTodas();
    }
}
