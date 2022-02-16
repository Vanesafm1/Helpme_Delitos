package vane.fm.delitos;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import vane.fm.delitos.modules.cases.domain.model.Case;
import vane.fm.delitos.modules.crimes.domain.model.Crime;
import vane.fm.delitos.modules.users.domain.model.Role;
import vane.fm.delitos.modules.users.domain.model.User;
import vane.fm.delitos.modules.cases.domain.repository.ICaseRepository;
import vane.fm.delitos.modules.crimes.domain.repository.ICrimeRepository;
import vane.fm.delitos.modules.users.domain.repository.IRoleRepository;
import vane.fm.delitos.modules.users.domain.repository.IUserRepository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Component
public class AppStartupRunner implements ApplicationRunner {
    private static final Logger logger = LoggerFactory.getLogger(AppStartupRunner.class);

    @Autowired
    private IRoleRepository elRolRepo;

    @Autowired
    private IUserRepository elUserRepo;

    @Autowired
    private ICrimeRepository elCrimeRepo;

    @Autowired
    private ICaseRepository elCaseRepo;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        logger.info("Vamos a cargar unos roles a la base de datos");

        Role r1 = new Role();
        r1.setId(1L);
        r1.setName("Administrador");
        r1.setDescription("Administrador");
        elRolRepo.save(r1);

        Role r2 = new Role();
        r2.setId(2L);
        r2.setName("Usuario");
        r2.setDescription("Usuario");
        elRolRepo.save(r2);

        //Si tengo un repo, lo uso para buscar todos los roles...
        List<Role> todosLosRolesEncontrados = elRolRepo.findAll();
        System.out.println( todosLosRolesEncontrados );

        for (Role r : todosLosRolesEncontrados){
            System.out.println(r.toString());
            logger.info(r.getName() + r.getDescription());
        }

        logger.info("Vamos a cargar unos users a la base de datos");
        User user1 = new User();
        user1.setId(2L);
        user1.setNombre("Pepe");

//        List<Role> listaderoles = Arrays.asList(r1);
//        user1.setRoles(listaderoles);
//
//        Role rolDefinido = elRolRepo.findAll().get(0);
//        List<Role> rr = Arrays.asList(rolDefinido);
//        user1.setRoles(rr);

        List <Role> tt = elRolRepo.findAll();

        user1.setRoles(tt);

//        user1.setRoles(elRolRepo.findAll());

        elUserRepo.save(user1);

        List<User> todosLosUsuarios = elUserRepo.findAll();
        System.out.println(todosLosUsuarios);

        for (User user : todosLosUsuarios) {
            System.out.println(user.getNombre().toString());
            System.out.println(user.getId().toString());
        }

        //crear un new crimen y guardarlo en elrepository
        logger.info("Vamos a cargar Crimenes ");
        Crime crime1 = new Crime();

        crime1.setId(201L);
        crime1.setDescripcion("Robo");
        crime1.setNombre("robet");

        // user1 no es valido el id no coincide
        // crime1.setUsuario(user1);

        //Busquemos el primer usuario que encontremos
        User elprimerusuarioqueencuentre = elUserRepo.findAll().get(0);
        crime1.setUsuario(elprimerusuarioqueencuentre);

        elCrimeRepo.save(crime1);

        List<Crime> todoslosCrime = elCrimeRepo.findAll();

        System.out.println(todoslosCrime);

        for (Crime crime : todoslosCrime) {
            System.out.println(crime.getNombre());
            System.out.println(crime.getId().toString());
        }

        logger.info("Vamos a crear Los casos");
        Case case1 = new Case();
        case1.setId(301L);

        case1.setVisible(Boolean.TRUE);
        case1.setDescripcion("robo con cuchillo");
        case1.setFechaHora(LocalDateTime.now());
        case1.setAltitud(56.0F);
        case1.setLatitud(34.5F);
        case1.setLongitud(67.9F);
        case1.setRmiUrl("j");
        case1.setUrlMap("h");
        case1.setUsers(elUserRepo.findAll().get(0));

        Crime catalogoCrimen = elCrimeRepo.findAll().get(0);
//        case1.setDelito (crime1);
        case1.setCrime(catalogoCrimen);
        elCaseRepo.save(case1);



        List<Case> todoslosCasos = elCaseRepo.findAll();
        System.out.println(todoslosCasos);

        for (Case kase : todoslosCasos ) {
            System.out.println(kase.getId().toString());
            System.out.println(kase.getFechaHora().toString());
        }
    }

}