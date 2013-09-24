package controle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import modelo.User;
import modelo.persistencia.UserDao;

@RequestScoped
@ManagedBean
public class UserMB {

	private User user;

	private List<User> listUser;

	private UserDao dao;

	public UserMB() {
		user = new User();
		listUser = new ArrayList<User>();
		dao = new UserDao();
	}

	public String gravar(){
		dao.salvar(user);
		return "index";
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getListUser() {
		return listUser;
	}

	public void setListUser(List<User> listUser) {
		this.listUser = listUser;
	}

}
