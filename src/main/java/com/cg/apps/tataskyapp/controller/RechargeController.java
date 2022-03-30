package com.cg.apps.tataskyapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.apps.tataskyapp.entities.Recharge;
import com.cg.apps.tataskyapp.service.RechargeService;

@RestController
@RequestMapping("/recharge")
public class RechargeController {
	@Autowired
	RechargeService rechargeService;

//	@PostMapping
//	public String addRecharge(@RequestBody Recharge recharge) {
//		rechargeService.addRecharge(recharge);
//		return "Recharge added";
//	}
}
