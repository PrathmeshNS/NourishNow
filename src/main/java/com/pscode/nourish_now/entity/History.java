package com.pscode.nourish_now.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

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

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "hotel_user_id", referencedColumnName = "id")
	private ArrayList<Users> hotelUsers;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinColumn(name = "ngo_user_id", referencedColumnName = "id")
	private ArrayList<Users> ngoUsers;

}
