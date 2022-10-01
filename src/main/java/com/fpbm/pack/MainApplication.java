package com.fpbm.pack;

import com.fpbm.pack.emploi_du_temps.Emploi_tuple;
import com.fpbm.pack.emploi_du_temps.Emploi_tuple_org;
import com.fpbm.pack.emploi_du_temps.Groupe_Emploi_tuple_org;
import com.fpbm.pack.entities.*;
import com.fpbm.pack.entities.Module;
import com.fpbm.pack.serviceimpl.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@ComponentScan("com.fpbm.pack")
public class MainApplication {

	public static void main(String[] args) {
		SpringApplication.run(MainApplication.class, args);
	}



}
