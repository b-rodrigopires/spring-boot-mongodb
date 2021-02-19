package com.example.mongo.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.mongo.domain.User;
import com.example.mongo.dto.UserDTO;
import com.example.mongo.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> list = userService.findAll();
		
		//List<UserDTO> listDTO = list.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(retDTO(list));
	}
	
	public List<UserDTO> retDTO(List<User> list) {
		List<UserDTO> uDTOList = new ArrayList<>();
		for (User u : list) {
			uDTOList.add(new UserDTO(u));
		}
		return uDTOList;
	}
	
}
