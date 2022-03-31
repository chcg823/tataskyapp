package com.cg.apps.tataskyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.tataskyapp.entities.Pack;
import com.cg.apps.tataskyapp.service.PackService;

@RestController
@RequestMapping("/pack")
public class PackController {
	@Autowired
	PackService packService;

	@PostMapping
	public String addUser(@RequestBody Pack pack) {
		packService.addPack(pack);
		return "User added";
	}

}
