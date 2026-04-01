package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.Participante;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteRepository {

    private List<Participante> participantes = new ArrayList<>();

    private long proximoId = 1;

    public void salvar(Participante participante) {
        if (participante.getId() == 0) {

            participante.setId(proximoId++);
        }
        participantes.add(participante);
    }

    public List<Participante> listarTodos() {

        return new ArrayList<>(participantes);
    }

    public Participante buscarPorId(long id) {

        return participantes.stream()

                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean existe(long id) {

        return participantes.stream().anyMatch(p -> p.getId() == id);
    }
}
