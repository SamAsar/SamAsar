package devlabs.inc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import devlabs.inc.entity.User;
import devlabs.inc.exception.ResourceNotFoundException;
import devlabs.inc.repository.UserRepository;

@RestController
@RequestMapping("/api/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> getAll(){
		
		return this.userRepository.findAll();
		
	}
	//get user by id
	@GetMapping("/{id}")
	public User findById(@PathVariable(name = "id") Long userId) {
		
		return this.userRepository.findById(userId).orElseThrow(()  -> new ResourceNotFoundException("user not found with id :" +userId));
		
	}
	//create user
	@PostMapping("/users")
	public User CreateUser(@RequestBody User user) {
		
		return this.userRepository.save(user);
		
	}
	
	//update user
		@PutMapping("/{id}")
		public User updateUser(@RequestBody User user, @PathVariable(name = "id") Long userId) {
			
			User existUser = this.userRepository.findById(userId).orElseThrow(()  -> new ResourceNotFoundException("user not found with id :" +userId));
			
			existUser.setFirstname(user.getFirstname());
			existUser.setLastname(user.getLastname());
			existUser.setEmail(user.getEmail());
			
			return this.userRepository.save(existUser);
			
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<User> deleteUserById(@PathVariable(name = "id") Long  userid) {
			User exisUser = this.userRepository.findById(userid).orElseThrow(() -> new ResourceNotFoundException(" user not found with id :" + userid));
			this.userRepository.delete(exisUser);
			
			return ResponseEntity.ok().build();
			
		}
}
