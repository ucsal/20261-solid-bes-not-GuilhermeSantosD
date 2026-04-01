package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.Tentativa;
import java.util.List;

public interface ITentativaRepository {
    void salvar(Tentativa tentativa);
    List<Tentativa> listarTodas();
}
