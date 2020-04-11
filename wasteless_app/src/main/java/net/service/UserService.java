package net.service;

import net.model.User;
import net.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public List<User> listAll() {
		return userRepository.findAll();
	}
	
	public void save(User user) {
		userRepository.save(user);
	}

	public void delete(long id) {
		userRepository.deleteById(id);
	}

	public User findUser(String username, String password) {
		return userRepository.findUserByUsernameAndPassword(username, password);
	}

	public User findUserByUsername(String username){return userRepository.findUserByUsername(username);}

	public User findUserById(long id){return userRepository.findUserById(id);}
}
