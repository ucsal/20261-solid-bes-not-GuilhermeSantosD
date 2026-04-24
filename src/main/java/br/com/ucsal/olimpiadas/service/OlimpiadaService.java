package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.Participante;
import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.Questao;
import br.com.ucsal.olimpiadas.Tentativa;
import br.com.ucsal.olimpiadas.repository.IParticipanteRepository;
import br.com.ucsal.olimpiadas.repository.IProvaRepository;
import br.com.ucsal.olimpiadas.repository.IQuestaoRepository;
import br.com.ucsal.olimpiadas.repository.ITentativaRepository;
import java.util.List;

public class OlimpiadaService implements IOlimpiadaService {

    private final IParticipanteRepository participanteRepository;
    private final IProvaRepository provaRepository;
    private final IQuestaoRepository questaoRepository;
    private final ITentativaRepository tentativaRepository;

    public OlimpiadaService(IParticipanteRepository participanteRepository,
                            IProvaRepository provaRepository,
                            IQuestaoRepository questaoRepository,
                            ITentativaRepository tentativaRepository) {
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
