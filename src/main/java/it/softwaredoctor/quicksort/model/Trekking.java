package it.softwaredoctor.quicksort.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Trekking")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trekking {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="trekking_id")
	private Long id;
	
	@Column(name ="nameTrekking", nullable = false)
	private String nameTrekking;
	
	@Column(name ="cityTrekking", nullable = false)
	private String cityTrekking;
	
	@Column(name ="km", nullable = false)
	private double km;

}
