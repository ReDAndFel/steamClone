package org.steamclone.controllers;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.steamclone.dtos.MessageDTO;
import org.steamclone.dtos.SesionDTO;
import org.steamclone.dtos.TokenDTO;
import org.steamclone.dtos.UserDTO;
import org.steamclone.services.interfaces.SesionInterface;
import org.steamclone.services.interfaces.UserInterface;

    @RestController
    @AllArgsConstructor
    @RequestMapping("/api/auth")
    public class AuthController {
        private final UserInterface userInterface;
        private final SesionInterface sesionInterface;
        @PostMapping("/login")
        public ResponseEntity<MessageDTO> login(@Valid @RequestBody SesionDTO loginUser) {
            return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false, sesionInterface.login(loginUser)) );
        }
        @PostMapping("/registro")
        public ResponseEntity<MessageDTO> registerPerson(@Valid @RequestBody UserDTO userDTO) throws Exception {
            userInterface.createUser(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(HttpStatus.CREATED,false, "Persona registrada correctamente"));
        }

       /* @PostMapping("/registroAdmin")
        public ResponseEntity<MessageDTO> registerAdmin(@Valid @RequestBody UserDTO userDTO) throws Exception {
            userInterface.registerAdmin(personDTO);
            */

       /* @PostMapping("/refresh")
        public ResponseEntity<MessageDTO> refreshToken(@Valid @RequestBody TokenDTO tokenDTO) throws Exception {
            sesionInterface.refreshToken(tokenDTO);
            return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK,false, "Token refrescado"));
        }*/
    }