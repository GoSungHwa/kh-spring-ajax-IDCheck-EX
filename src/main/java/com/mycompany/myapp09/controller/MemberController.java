package com.mycompany.myapp09.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycompany.myapp09.model.service.MemberService;

@Controller
public class MemberController {

	@Autowired
	private MemberService memberservice;

	@PostMapping("idCheck")
	@ResponseBody
	public String idCheck(@RequestParam("id") String id) {
		System.out.println("id : " + id);
		
		int result = 0;
		String results = "";
		try {
			result = memberservice.idCheck(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (result == 1) {
			results = "false";
		} else {
			results = "true";
		}
		return results;
	}
}
