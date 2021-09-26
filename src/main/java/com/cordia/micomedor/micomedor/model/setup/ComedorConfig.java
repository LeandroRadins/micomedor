package com.cordia.micomedor.micomedor.model.setup;

import com.cordia.micomedor.micomedor.model.Comedor;
import com.cordia.micomedor.micomedor.repository.ComedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class ComedorConfig {

    @Autowired
    ComedorRepository comedorRepository;

    @Bean
    CommandLineRunner commandLineRunner(ComedorRepository comedorRepository) {
        return args -> {
            List<Comedor> comedors = new ArrayList<>();
            Comedor comedor = new Comedor("nombreComedor", "direccion1", "correoComedor1", "376412323");
            for (int i = 1; i <= 10; i++) {
                Comedor ccomedor = new Comedor(comedor);
                ccomedor.setCorreo("correo_" + String.valueOf(i));
                comedors.add(ccomedor);
            }
            comedorRepository.saveAll(comedors);
        };
    }
}
