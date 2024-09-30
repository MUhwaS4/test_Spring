package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.service.ReservationService;

@Controller
@RequestMapping("/reservation")
public class ReservationController {
	
	@Autowired
	ReservationService service;

	// 예약 목록 조회
	@GetMapping("/list")
	public void list(Model model) {
		
		List<ReservationDTO> list = service.getList();
		
		model.addAttribute("list", list);
	}
	
	// 예약 정보 등록
	@GetMapping("/register")
	public void register() {
		
	}
	
	// 새로운 예약 정보 등록
	@PostMapping("/register")
	public String registerPost(ReservationDTO dto, RedirectAttributes redirectAttributes) {
		
		int no = service.register(dto);
		
		System.out.println("no: " + no);
		
		redirectAttributes.addFlashAttribute("no", no);
		
		return "redirect:/reservation/list";
		
	}
	
	// 예약 상세 조회
	@GetMapping("/read")
	public void read(@RequestParam(name = "no") int no, Model model) {
		
		ReservationDTO dto = service.read(no);
		model.addAttribute("dto", dto);
		
	}

}
