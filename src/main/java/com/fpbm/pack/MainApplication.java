package com.fpbm.pack;


import com.fpbm.pack.serviceimpl.DepartementServiceImpl;
import com.fpbm.pack.serviceimpl.SalleServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fpbm.pack")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}


    @Bean
    CommandLineRunner commandLineRunner(SalleServiceImpl salleService, DepartementServiceImpl depser){
        return args -> {

           /* salleService.save(new Salle(5,"c05",30,50,null,null));
            salleService.save(new Salle(2,"c02",30,20,null,null));
            salleService.save(new Salle(3,"c03",30,30,null,null));
            salleService.save(new Salle(4,"c04",30,40,null,null));*/
            salleService.getAll().forEach( p-> {System.out.println(p.getName());});
            depser.getAll().forEach( p-> {System.out.println(p.getName());});

        };
    }



}
