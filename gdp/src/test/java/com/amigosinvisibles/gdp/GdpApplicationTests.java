package com.amigosinvisibles.gdp;

import com.amigosinvisibles.gdp.model.Grupo;
import com.amigosinvisibles.gdp.service.GrupoService;
import com.amigosinvisibles.gdp.service.IGustoService;
import com.amigosinvisibles.gdp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.amigosinvisibles.gdp.model.User;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
class GdpApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private GrupoService grupoService;

	@Autowired
	private IGustoService gustoService;


	@Test
	void contextLoads() {
		SimpleDateFormat dataFormat=  new SimpleDateFormat("dd-MM-yyyy");
		String fechaLimiteFijaDeGrupo = "20-06-2021";

		//String fechaDelSorteo = "16-06-2021";

		//este caso es por decision del admin por eso no tiene f
		//Grupo g1 = new Grupo("grupo1", "grp001","PENDIENTE",new Date(),true);

		try{
			//g1.setFechaLimite(dataFormat.parse(fechaLimiteFijaDeGrupo));

			//g1.setFechaLimiteFija	DeGrupo(dataFormat.parse(fechaLimiteFijaDeGrupo));
//			grupoService.create(g1);
		}catch (Exception e){

		}
	}

}
