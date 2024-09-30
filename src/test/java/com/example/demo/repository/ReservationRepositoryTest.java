package com.example.demo.repository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.Reservation;

@SpringBootTest
public class ReservationRepositoryTest {
	
	// 빈 주입
	@Autowired
	ReservationRepository repository;
	
	@Test
	void 리파지토리빈_확인() {
		System.out.println("Reservation: " + repository);
	}
	
	@Test
	void 등록() {
		
		List<Reservation> list = new ArrayList<>();
		
		LocalDate date1 = LocalDate.of(2024, 9, 05);
		LocalDate date2 = LocalDate.of(2024, 9, 10);
		
		Reservation reservation1 = Reservation.builder()
									.checkInDate(date1)
									.guestName("둘리")
									.guestPhone("010-1111-2222")
									.roomNo(201)
									.build();
		
		Reservation reservation2 = Reservation.builder()
									.checkInDate(date1)
									.guestName("또치")
									.guestPhone("010-3333-4444")
									.roomNo(202)
									.build();
		
		Reservation reservation3 = Reservation.builder()
									.checkInDate(date2)
									.guestName("도우너")
									.roomNo(201)
									.build();
		
		list.add(reservation1);
		list.add(reservation2);
		list.add(reservation3);
		
		repository.saveAll(list);
		
	}
	
	@Test
	void 개별등록() {
		
		LocalDate date = LocalDate.of(2024, 9, 10);
		
		Reservation reservation = Reservation.builder()
									.checkInDate(date)
									.guestName("짱구")
									.guestPhone("010-5555-6666")
									.roomNo(203)
									.build();
		
		repository.save(reservation);
		
	}
	
	@Test
	void 목록조회() {
		List<Reservation> list = repository.findAll();
		
		for (Reservation reservation : list) {
			System.out.println(reservation);
		}
	}
	
	@Test
	void 단건조회() {
		Optional<Reservation> post = repository.findById(1);
		
		if (post.isPresent()) {
			System.out.println(post);
		}
	}
	
	@Test
	void 수정() {
		Optional<Reservation> post = repository.findById(4);
		
		Reservation reservation = post.get();
		
		reservation.setGuestName("이름 수정!");
		
		repository.save(reservation);
	}
	
	@Test
	void 삭제() {
		repository.deleteById(4);
	}


}
