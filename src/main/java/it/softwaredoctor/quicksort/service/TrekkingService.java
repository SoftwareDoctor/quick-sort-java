package it.softwaredoctor.quicksort.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import it.softwaredoctor.quicksort.dto.TrekkingDTO;
import it.softwaredoctor.quicksort.mapper.Mapper;
import it.softwaredoctor.quicksort.model.Trekking;
import it.softwaredoctor.quicksort.repository.TrekkingRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TrekkingService {

	private final TrekkingRepository trekkingRepository;

	public List<TrekkingDTO> getAllEscursioni() {
		List<Trekking> trekkingList = trekkingRepository.findAll();
		return Mapper.convertModelListToDtoList(trekkingList);
	}

	private void quickSortPerKm(List<TrekkingDTO> trekkingDTOList, int low, int high) {
	    // Controllo se l'indice 'low' è inferiore all'indice 'high' per verificare se c'è
	    // almeno un elemento nell'array da ordinare.
	    if (low < high) {
	        // Trovo l'indice del pivot
	        int pi = partitionPerKm(trekkingDTOList, low, high);
	        
	        // Chiamo ricorsivamente quickSortPerKm per la parte sinistra del pivot
	        quickSortPerKm(trekkingDTOList, low, pi - 1);
	        
	        // Chiamo ricorsivamente quickSortPerKm per la parte destra del pivot
	        quickSortPerKm(trekkingDTOList, pi + 1, high);
	    }
	}

	public List<TrekkingDTO> getOrderedTrekkingPerKm() {
	    // Recupero la lista di trekking dal repository
	    List<Trekking> trekkingList = trekkingRepository.findAll();
	    
	    // Converto la lista di modello Trekking in una lista di DTO TrekkingDTO
	    List<TrekkingDTO> trekkingDTOList = Mapper.convertModelListToDtoList(trekkingList);
	    
	    // Ordino la lista di TrekkingDTO utilizzando quicksort basato sui chilometri
	    quickSortPerKm(trekkingDTOList, 0, trekkingDTOList.size() - 1);
	    
	    // Restituisco la lista di TrekkingDTO ordinata
	    return trekkingDTOList;
	}
	
	private int partitionPerKm(List<TrekkingDTO> trekkingDTOList, int low, int high) {
	    // Seleziono il pivot dall'elemento alla posizione 'high' (più semplice da implementare)
	    double pivot = trekkingDTOList.get(high).getKm();
	    
	    // Inizializzo l'indice 'i' per il partizionamento
	    int i = low - 1;
	    
	    // Ciclo attraverso gli elementi da 'low' a 'high-1'
	    for (int j = low; j < high; j++) {
	        // Se l'elemento corrente è minore del pivot, incremento 'i'
	        if (trekkingDTOList.get(j).getKm() < pivot) {
	            i++;
	            
	            // Scambio l'elemento corrente con l'elemento a 'i'
	            TrekkingDTO temp = trekkingDTOList.get(i);
	            trekkingDTOList.set(i, trekkingDTOList.get(j));
	            trekkingDTOList.set(j, temp);
	        }
	    }
	    
	    // Scambio l'elemento successivo dopo 'i' con l'elemento a 'high'
	    TrekkingDTO temp = trekkingDTOList.get(i + 1);
	    trekkingDTOList.set(i + 1, trekkingDTOList.get(high));
	    trekkingDTOList.set(high, temp);
	    
	    // Restituisco l'indice del pivot dopo il partizionamento
	    return i + 1;
	}
	

	public void newTrekking(TrekkingDTO trekkingDTO) {
		Trekking newTrekking = Mapper.convertDtoToModel(trekkingDTO);
		trekkingRepository.save(newTrekking);
	}

	public TrekkingDTO getTrekking(Long id) {
	    Optional<Trekking> optionalTrekking = trekkingRepository.findById(id);
	    if (optionalTrekking.isPresent()) {
	        Trekking trekkingFound = optionalTrekking.get();
	        return Mapper.convertModelToDto(trekkingFound);
	    } else {
	        return null;
	    }
	}


}
