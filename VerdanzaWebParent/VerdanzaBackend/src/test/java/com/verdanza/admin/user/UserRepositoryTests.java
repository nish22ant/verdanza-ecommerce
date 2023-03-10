package com.verdanza.admin.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.verdanza.common.entity.Role;
import com.verdanza.common.entity.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateNewUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User userNishant = new User("Nishant", "Kumar", "nknishantkumar378@gmail.com", "nishant");
		userNishant.addRole(roleAdmin);
		
		
		User savedUser = repo.save(userNishant);
		assertThat(savedUser.getId()).isGreaterThan(0);
	}
	
	@Test
	public void testCreateNewUserWitTwoRoles() {
		User userPikachu = new User("Pikachu", "Ketchum", "pikachu@gmail.com", "pikachu");
		Role roleEditor = new Role(3);
		Role roleAssistant = new Role(5);
		
		userPikachu.addRole(roleEditor);
		userPikachu.addRole(roleAssistant);
		
		User savedUser = repo.save(userPikachu);
		assertThat(savedUser.getId()).isGreaterThan(0);
		
	}
	
	@Test
	public void testListAllUsers() {
		Iterable<User> users = repo.findAll();
		users.forEach(user -> System.out.println(user));
	}
	
	@Test
	public void testGetUserById() {
		User userNishant = repo.findById(1).get();
		System.out.println(userNishant);
		assertThat(userNishant).isNotNull();
	}
	
	@Test
	public void testUpdateUserDetails() {
		User userNishant = repo.findById(1).get();
		userNishant.setEnabled(true);
		repo.save(userNishant);
	}
	
	@Test
	public void testUpdateUserRoles() {
		User userPikachu = repo.findById(3).get();
		Role roleEditor = new Role(3);
		Role roleSalesperson = new Role(2);
		userPikachu.getRoles().remove(roleEditor);
		userPikachu.addRole(roleSalesperson);
		repo.save(userPikachu);
	}
	
	@Test
	public void testDeleteUser() {
		repo.deleteById(3);
	}
}
