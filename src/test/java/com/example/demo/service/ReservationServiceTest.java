package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.ReservationDTO;

@SpringBootTest
public class ReservationServiceTest {
	
	@Autowired
	ReservationService service;
	
	@Test
	public void 빈주입확인() {
		System.out.println("service: " + service);
	}
	
	@Test
	public void 예약정보등록() {
		
		LocalDate date = LocalDate.of(2024, 9, 15);
		
		ReservationDTO dto = ReservationDTO.builder()
								.checkInDate(date)
								.guestName("짱구")
								.guestPhone("010-1234-5678")
								.roomNo(301)
								.build();
		
		int no = service.register(dto);
		
		System.out.println("새로운 예약 번호: " + no + ", 예약자 성명: " + dto.getGuestName());
		
	}
	
	@Test
	public void 예약정보목록조회() {
		
		List<ReservationDTO> list = service.getList();
		
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
	}
	
	@Test
	public void 예약정보단건조회() {
		
		ReservationDTO dto = service.read(2);
		
		System.out.println(dto);
		
	}

}
