package com.cordia.micomedor.micomedor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cordia.micomedor.micomedor.controller.ComedorController;
import com.cordia.micomedor.micomedor.model.Comedor;

@SpringBootApplication
public class MiComedorApplication {

	public static void main(String[] args) {
		SpringApplication.run(MiComedorApplication.class, args);
		ComedorController c = new ComedorController();
		Comedor come = new Comedor("dasd", "direccion2", "correocomedor@asd.dwqd", 1233412233);
		c.createComedor(come);
	}

}
