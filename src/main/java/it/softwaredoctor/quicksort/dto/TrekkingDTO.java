package it.softwaredoctor.quicksort.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrekkingDTO {

	private String nameTrekking;
	private String cityTrekking;
	private double km;
}
