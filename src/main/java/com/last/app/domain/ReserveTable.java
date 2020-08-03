package com.last.app.domain;
import lombok.Data;

@Data
public class ReserveTable {
	private int reserve_table_id;
	private Room room;
	private Reservation reservation;	
}
