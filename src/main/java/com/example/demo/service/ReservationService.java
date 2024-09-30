package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.ReservationDTO;
import com.example.demo.entity.Reservation;

public interface ReservationService {
	
	// 등록 메소드
	int register(ReservationDTO dto);
	
	// 목록 조회
	List<ReservationDTO> getList();
	
	// 상세 조회
	ReservationDTO read(int no);
	
	// DTO => Entity
	default Reservation dtoToEntity(ReservationDTO dto) {
		
		Reservation entity = Reservation.builder()
									.no(dto.getNo())
									.checkInDate(dto.getCheckInDate())
									.guestName(dto.getGuestName())
									.guestPhone(dto.getGuestPhone())
									.roomNo(dto.getRoomNo())
									.build();
		
		return entity;
		
	}
	
	// Entity => DTO
	default ReservationDTO entityToDto(Reservation entity) {
		
		ReservationDTO dto = ReservationDTO.builder()
								.no(entity.getNo())
								.checkInDate(entity.getCheckInDate())
								.guestName(entity.getGuestName())
								.guestPhone(entity.getGuestPhone())
								.roomNo(entity.getRoomNo())
								.build();
		
		return dto;
		
	}	

}
