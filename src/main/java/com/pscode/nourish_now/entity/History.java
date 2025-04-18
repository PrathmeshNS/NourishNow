package com.pscode.nourish_now.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long hId;
	private String time;
	private String date;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "hotel_user_id", referencedColumnName = "id")
	private Users hotelUsers;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "ngo_user_id", referencedColumnName = "id")
	private Users ngoUsers;

}
