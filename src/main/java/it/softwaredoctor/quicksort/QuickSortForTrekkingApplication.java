package it.softwaredoctor.quicksort;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class QuickSortForTrekkingApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuickSortForTrekkingApplication.class, args);
	}

//	@Component
//	public static class DataLoader implements CommandLineRunner {
//
//		private final TrekkingRepository trekkingRepository;

//        @Autowired
//        public DataLoader(TrekkingRepository trekkingRepository) {
//            this.trekkingRepository = trekkingRepository;
//        }
//
//        @Override
//        public void run(String... args) throws Exception {
//            // Creazione di 20 oggetti Trekking
//        	double km = 1; 
//            for (int i = 1; i <= 20; i++) {
//                Trekking trekking = new Trekking("Trekking" + i, "Lombardia" + i, km);
//                km += 1; 
//                trekkingRepository.save(trekking);
//                System.out.println("Lista di trekking ---> " + trekking);
//            }
//           
//        }
//	}

}
