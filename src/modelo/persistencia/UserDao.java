package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.User;

public class UserDao {

	private static List<User> LISTA = new ArrayList<User>();

	public void salvar(User usermark) {
		LISTA.add(usermark);
	}

	public List<User> listar() {
		return LISTA;
	}

	public User getByID(String cpf) {
		for (User user : LISTA) {
			if (user.getCpf().getValue() == cpf) {
				return user;
			}
		}
		return new User();
	}

	public void editar(User _user) {
		ArrayList<User> _lista = new ArrayList<User>();
		for (User user : LISTA) {
			if (user.getCpf().getValue() == _user.getCpf().getValue()) {
				_lista.add(_user);
			} else
				_lista.add(user);
		}
		LISTA.clear();
		LISTA.addAll(_lista);

	}

	public void excluir(String cpf) {
		ArrayList<User> _lista = new ArrayList<User>();
		for (User user : LISTA) {
			if (user.getCpf().getValue() == cpf) {
				continue;
			} else
				_lista.add(user);
		}
		LISTA.clear();
		LISTA.addAll(_lista);
	}

}
