package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.Participante;
import java.util.List;

public interface IParticipanteRepository {
    void salvar(Participante participante);
    List<Participante> listarTodos();
    Participante buscarPorId(long id);
    boolean existe(long id);
}
