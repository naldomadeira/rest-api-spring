package br.madeira.restapispring.controllers;

import br.madeira.restapispring.exceptions.ResourceNotFoundException;
import br.madeira.restapispring.models.UserModel;
import br.madeira.restapispring.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    /**
     * Get all users list.
     *
     * @return the list
     */
    @GetMapping(path = "/users")
    public List<UserModel> getAllUsers() {
        return userRepository.findAll();
    }

    /**
     * Gets users by id.
     *
     * @param id the user id
     * @return the users by id
     * @throws ResourceNotFoundException the resource not found exception
     */
    @GetMapping(path = "/users/{id}")
    public ResponseEntity getUserById(@PathVariable("id") Integer id)  throws ResourceNotFoundException{
        UserModel user =
                userRepository
                        .findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping(path = "/users")
    public UserModel createUser(@RequestBody UserModel user) {
        return userRepository.save(user);
    }


    /**
     * Update user response entity.
     * @param id the user id
     * @param userDetails the user details
     * @return the response entity
     * @throws ResourceNotFoundException the resource not found exception
     */
    @PutMapping(path = "/users/{id}")
    public ResponseEntity updateUser(@PathVariable("id") Integer id, @RequestBody UserModel userDetails) throws ResourceNotFoundException {
        UserModel user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));

        user.setName(userDetails.getName());
        user.setLogin(userDetails.getLogin());
        user.setPassword(userDetails.getPassword());

        final UserModel updateUser = userRepository.save(user);
        return ResponseEntity.ok(updateUser);
   }

    /**
     * Delete user map.
     *
     * @param id the user id
     * @return the map
     * @throws Exception the exception
     */
   @DeleteMapping(path = "/users/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable("id") Integer id) throws Exception {
       UserModel user = userRepository.findById(id)
               .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + id));

       userRepository.delete(user);

       Map<String, Boolean> response = new HashMap<>();
       response.put("deleted", Boolean.TRUE);

       return response;
   }


}
