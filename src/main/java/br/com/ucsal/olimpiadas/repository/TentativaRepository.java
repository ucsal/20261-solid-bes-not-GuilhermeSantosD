package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.Tentativa;
import java.util.ArrayList;
import java.util.List;

public class TentativaRepository implements ITentativaRepository {
    private List<Tentativa> tentativas = new ArrayList<>();

    private long proximoId = 1;

    public void salvar(Tentativa tentativa) {

        if (tentativa.getId() == 0) {
            tentativa.setId(proximoId++);
        }
        tentativas.add(tentativa);
    }

    public List<Tentativa> listarTodas() {

        return new ArrayList<>(tentativas);
    }
}
