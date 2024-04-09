package it.softwaredoctor.quicksort.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import it.softwaredoctor.quicksort.model.Trekking;

@Repository
public interface TrekkingRepository extends JpaRepository<Trekking, Long>	{

}
