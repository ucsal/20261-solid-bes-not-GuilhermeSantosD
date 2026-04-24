package br.com.ucsal.olimpiadas.service;

import br.com.ucsal.olimpiadas.Participante;
import br.com.ucsal.olimpiadas.Prova;
import br.com.ucsal.olimpiadas.Questao;
import br.com.ucsal.olimpiadas.Tentativa;
import br.com.ucsal.olimpiadas.Resposta;
import br.com.ucsal.olimpiadas.repository.ParticipanteRepository;
import br.com.ucsal.olimpiadas.repository.ProvaRepository;
import br.com.ucsal.olimpiadas.repository.QuestaoRepository;
import br.com.ucsal.olimpiadas.repository.TentativaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OlimpiadaServiceTest {

    private OlimpiadaService service;
    private ParticipanteRepository participanteRepository;
    private ProvaRepository provaRepository;
    private QuestaoRepository questaoRepository;
    private TentativaRepository tentativaRepository;

    @BeforeEach
    void setUp() {
        participanteRepository = new ParticipanteRepository();
        provaRepository = new ProvaRepository();
        questaoRepository = new QuestaoRepository();
        tentativaRepository = new TentativaRepository();
        service = new OlimpiadaService(participanteRepository, provaRepository, questaoRepository, tentativaRepository);
    }

    @Test
    void deveCalcularNotaCorretamente() {
        // Arrange
        Tentativa tentativa = new Tentativa();
        
        Resposta r1 = new Resposta();
        r1.setCorreta(true);
        tentativa.getRespostas().add(r1);
        
        Resposta r2 = new Resposta();
        r2.setCorreta(false);
        tentativa.getRespostas().add(r2);
        
        Resposta r3 = new Resposta();
        r3.setCorreta(true);
        tentativa.getRespostas().add(r3);

        // Act
        int nota = service.calcularNota(tentativa);

        // Assert
        assertEquals(2, nota);
    }

    @Test
    void deveCadastrarParticipante() {
        // Act
        service.cadastrarParticipante("Teste", "teste@email.com");

        // Assert
        assertFalse(participanteRepository.listarTodos().isEmpty());
        assertEquals("Teste", participanteRepository.listarTodos().get(0).getNome());
    }
}
