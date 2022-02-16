package vane.fm.delitos.modules.users.rest.controller;

import org.hibernate.boot.model.source.internal.hbm.Helper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vane.fm.delitos.modules.users.domain.service.UserService;
import vane.fm.delitos.modules.users.rest.dto.UserDTO;


import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    public ResponseEntity<List<UserDTO>> index() {
        List<UserDTO> usersDto = userService.listUsers();
        return ResponseEntity.ok().body(usersDto);
    }

//    @ApiOperation(value = "Obtiene un usuario por Id",
//            response = User.class,
//            produces = "application/json",
//            httpMethod = "GET")
//    @GetMapping("/user/{id}")
//    public ResponseEntity<UserDTO> show(@PathVariable Long id) {
//        List<User> usuario = userService.listUser(id);
//        UserDTO usuarioDto = Helper.getMapValuesClient(usuario);
//        return ResponseEntity.ok().body(usuarioDto);
//    }
}
