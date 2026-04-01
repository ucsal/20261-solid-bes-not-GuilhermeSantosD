package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.Prova;
import java.util.ArrayList;
import java.util.List;

public class ProvaRepository {

    private List<Prova> provas = new ArrayList<>();

    private long proximoId = 1;

    public void salvar(Prova prova) {

        if (prova.getId() == 0) {

            prova.setId(proximoId++);
        }
        provas.add(prova);
    }

    public List<Prova> listarTodos() {

        return new ArrayList<>(provas);
    }

    public Prova buscarPorId(long id) {

        return provas.stream()

                .filter(p -> p.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean existe(long id) {

        return provas.stream().anyMatch(p -> p.getId() == id);
    }

    public boolean isEmpty() {

        return provas.isEmpty();
    }
}
