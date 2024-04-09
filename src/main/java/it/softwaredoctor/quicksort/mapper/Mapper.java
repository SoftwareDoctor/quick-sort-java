package it.softwaredoctor.quicksort.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import it.softwaredoctor.quicksort.dto.TrekkingDTO;
import it.softwaredoctor.quicksort.model.Trekking;

@Component
public class Mapper {

    public static Trekking convertDtoToModel(TrekkingDTO trekkingDTO) {
        Trekking trekking = new Trekking();
        BeanUtils.copyProperties(trekkingDTO, trekking);
        return trekking;
    }
    
    public static TrekkingDTO convertModelToDto(Trekking trekking) {
        TrekkingDTO trekkingDTO = new TrekkingDTO(); 
        BeanUtils.copyProperties(trekking, trekkingDTO);
        return trekkingDTO; 
    }

    public static List<TrekkingDTO> convertModelListToDtoList(List<Trekking> trekkingList) {
        List<TrekkingDTO> trekkingDTOList = new ArrayList<>(); 
        for (Trekking trekking : trekkingList) {
            trekkingDTOList.add(convertModelToDto(trekking));
        }
        return trekkingDTOList;
    }
}
