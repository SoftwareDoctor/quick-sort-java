package it.softwaredoctor.quicksort.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.softwaredoctor.quicksort.dto.TrekkingDTO;
import it.softwaredoctor.quicksort.service.TrekkingService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
@RequestMapping("/api/v1/trekking")
public class TrekkingController {

	private final TrekkingService trekkingService;

	@GetMapping("/")
	public ResponseEntity<List<TrekkingDTO>> getEscursioni() {
		List<TrekkingDTO> escursioni = trekkingService.getAllEscursioni();
		return ResponseEntity.ok().body(escursioni);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TrekkingDTO> getTrekking(@PathVariable Long id) {
		TrekkingDTO trekkingDTO = trekkingService.getTrekking(id);
		if (trekkingDTO != null)
			return ResponseEntity.ok(trekkingDTO);
		else
			return ResponseEntity.notFound().build();
	}

	@GetMapping("/sort")
	public ResponseEntity<List<TrekkingDTO>> getEscursioniOrdinatePerKm() {
		List<TrekkingDTO> escursioniOrdinate = trekkingService.getOrderedTrekkingPerKm();
		return ResponseEntity.ok().body(escursioniOrdinate);
	}

	@PostMapping("/")
	public ResponseEntity<Void> createNewTrekking(TrekkingDTO trekkingDTO) {
		trekkingService.newTrekking(trekkingDTO);
		return ResponseEntity.ok().build();
	}
}
