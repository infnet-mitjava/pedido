package br.edu.infnet.pedido.model.persistencia;

import java.util.List;

public interface IDAO<T> {

	//CRUD
	//CREATE RETRIEVE UPDATE DELETE
	Boolean salvar(T obj);

	Boolean atualizar(T obj);

	Boolean deletar(T obj);

	List<T> listarTodos();

	T obter(Long codigo);

}