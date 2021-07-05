package com.amigosinvisibles.gdp;

import com.amigosinvisibles.gdp.model.*;
import com.amigosinvisibles.gdp.repository.TipoSorteoRepo;
import com.amigosinvisibles.gdp.repository.UserInGrupoRepoParaTests;
import com.amigosinvisibles.gdp.service.GrupoService;
import com.amigosinvisibles.gdp.service.IGustoService;
import com.amigosinvisibles.gdp.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class GdpApplicationTests {

	@Autowired
	private UserService userService;

	@Autowired
	private GrupoService grupoService;

	@Autowired
	private IGustoService gustoService;

	@Autowired
	private TipoSorteoRepo tipoSorteoRepo;

	@Autowired
	private UserInGrupoRepoParaTests userInGrupoRepoParaTests;


	@Test
	void contextLoads() {

		//User(Long id, String email, String userName, String firstName, String lastName
		// , String password, Date birthDate, String nationality)
		User uPedro= new User("pedro_zanchez@hotmail.com","uPedro","Pedro","Zanchez"
				,"123",new Date(),"Argentino");
		User uOmar= new User("uOmar@hotmail.com","uOmar","Omar","Larrosa"
				,"123",new Date(),"Argentino");
		User uJacinto= new User("uJacinto@hotmail.com","uJacinto","Jacinto","Rivas"
				,"123",new Date(),"Argentino");

		//guardo los usuarios en la bd
		try {
			userService.create(uOmar);
			userService.create(uJacinto);
			userService.create(uPedro);
		}catch(Exception e){}


//-----------------------------------------------------------------------------------------------------------

        //Listas de usuarios con este gusto
        List<User> usuariosGusto1 = new ArrayList<User>();
        usuariosGusto1.add(uJacinto);
        usuariosGusto1.add(uOmar);
        //Gusto(String nombre, String codigo, List<User> usuarios)
        Gusto gusto1 =  new Gusto("Electronicos", "1", usuariosGusto1);

//-----------------------------------------------------------------------------------------------------------

		//new TipoSorteo(Date fechaDelSorteo, int capacidadMaxima, boolean decisionDelAdmin)
		String temp_date1="07/28/2021 11:06:37 AM";
		Date date1= new Date(temp_date1);
		String temp_date2="01/01/2021 11:06:37 AM";
		Date date2 = new Date(temp_date2);
		String temp_date3="12/25/2021 11:06:37 AM";
		Date date3 = new Date(temp_date3);
		TipoSorteo sorteo1= new TipoSorteo(date1,4,true);
		TipoSorteo sorteo2= new TipoSorteo(date2,10,true);
		TipoSorteo sorteo3= new TipoSorteo(date3,2,false);

		//guardo los tipos sorteos en la bd
		try {
			tipoSorteoRepo.save(sorteo1);
			tipoSorteoRepo.save(sorteo2);
			tipoSorteoRepo.save(sorteo3);
		}catch(Exception e){}

//-----------------------------------------------------------------------------------------------------------


		//new Grupo(TipoSorteo tipoSorteo, String nombre, String codigo, String estado
		// , Date fechaLimite,Integer capacidadMaxima)
		String temp_dateGrupo1="07/28/2021 11:06:37 AM";
		Date dateGrupo1= new Date(temp_dateGrupo1);
		Grupo g1 = new Grupo (sorteo1, "Empresa 1", "1", "activo",dateGrupo1, 10 );
		Grupo g2 = new Grupo (sorteo3, "Empresa 10", "2", "activo",dateGrupo1, 5 );
		try {
			grupoService.create(g1);
			grupoService.create(g2);
		}catch(Exception e){}

//-----------------------------------------------------------------------------------------------------------

		//new UserInGrupo(User usuario, Grupo grupo, boolean isAdmin)
		UserInGrupo userInGrupo1 = new UserInGrupo(uPedro, g1, true);
		UserInGrupo userInGrupo2 = new UserInGrupo(uOmar, g1, false);
		try{
		userInGrupoRepoParaTests.save(userInGrupo1);
		userInGrupoRepoParaTests.save(userInGrupo2);}
		catch (Exception e){}


//-----------------------------------------------------------------------------------------------------------





    }

}
