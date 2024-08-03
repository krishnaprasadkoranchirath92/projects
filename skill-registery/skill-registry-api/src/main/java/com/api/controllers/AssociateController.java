package com.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.models.Associate;
import com.api.repos.AssociateRepo;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class AssociateController {

	@Autowired
	private AssociateRepo repo;

	@PostMapping("/saveAssociateDetails")
	public ResponseEntity<String> saveUser(@RequestBody Associate associate) {
		repo.save(associate);
		return new ResponseEntity<String>("Associate Saved", HttpStatus.OK);
	}

	@GetMapping("/getAssociates")
	public ResponseEntity<List<Associate>> getUser(@RequestParam(required = false) String releaseDate,
			@RequestParam(required = false) String primarySkill, @RequestParam(required = false) String baseLocation,
			@RequestParam(required = false) String designation) {
		List<Associate> assocateList = repo.findAll();
		Associate a1 = new Associate("ag49", "kp");
		assocateList.add(a1);
		return new ResponseEntity<List<Associate>>(assocateList, HttpStatus.OK);
	}

}
