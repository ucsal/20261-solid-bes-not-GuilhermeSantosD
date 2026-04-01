package br.com.ucsal.olimpiadas.repository;

import br.com.ucsal.olimpiadas.Prova;
import java.util.List;

public interface IProvaRepository {
    void salvar(Prova prova);
    List<Prova> listarTodos();
    Prova buscarPorId(long id);
    boolean existe(long id);
    boolean isEmpty();
}
