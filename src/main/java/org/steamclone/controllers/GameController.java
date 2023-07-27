package org.steamclone.controllers;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.steamclone.dtos.GameDTO;
import org.steamclone.dtos.MessageDTO;
import org.steamclone.models.entities.Game;
import org.steamclone.services.interfaces.GameInterface;

import java.util.List;

@SuppressWarnings("unchecked")
@RestController
@AllArgsConstructor
@RequestMapping("api/games")
public class GameController {

    @Autowired
    private GameInterface gameInterface;

    @PostMapping("/crear")
    public ResponseEntity<MessageDTO> createGame(@RequestBody GameDTO gameDTO){
        gameInterface.createGame(gameDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new MessageDTO(HttpStatus.CREATED,
                false, "Juego creado correctamente"));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<MessageDTO> updateGame(@PathVariable int id, @RequestBody GameDTO gameDTO) throws Exception{
        gameInterface.updateGame(id, gameDTO);
        return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK,
                false, "Juego actualizado correctamente"));
    }

    @PutMapping("/eliminar/{id}")
    public ResponseEntity<MessageDTO> deleteGame(@PathVariable int id) throws Exception{
        gameInterface.deleteGame(id);
     return ResponseEntity.status(HttpStatus.OK).body(new MessageDTO(HttpStatus.OK,
                false, "Juego eliminado correctamente"));
    }
    @GetMapping("/obtener")
    public ResponseEntity<MessageDTO> listAllGames(){
       return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                gameInterface.listAllGames()));
    }
    @GetMapping("/obtener/etiqueta/{tag}")
    public ResponseEntity<MessageDTO> listGameByTag( @PathVariable String tag){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                gameInterface.listGameByTag(tag)));
    }
    @GetMapping("/obtener/nombre/{name}")
    public ResponseEntity<MessageDTO> listGameByName(@PathVariable String name){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                gameInterface.listGameByName(name)));
    }
    @GetMapping("/obtener/precio/{minPrice}/{maxPrice}")
    public ResponseEntity<MessageDTO> listGameByPrice(@PathVariable float minPrice, @PathVariable float maxPrice){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                gameInterface.listGameByPrice(minPrice,maxPrice)));
    }
    @GetMapping("/obtener/empresa/{idBusiness}")
    public ResponseEntity<MessageDTO> listGameByIdBusiness(@PathVariable int idBusiness){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                gameInterface.listGameByIdBusiness(idBusiness)));
    }
    @GetMapping("/obtener/favorito/{idUser}")
    public ResponseEntity<MessageDTO> listFavoriteGame(@PathVariable int idUser){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                gameInterface.listFavoriteGame(idUser)));
    }
    @GetMapping("/obtener/user/{idUser}")
    public ResponseEntity<MessageDTO> listGameByIdUser(@PathVariable int idUser){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                gameInterface.listGameByIdUser(idUser)));
    }
    @GetMapping("/obtener/{idGame}")
    public ResponseEntity<MessageDTO> getGameDTO(@PathVariable int idGame){
        return ResponseEntity.status(HttpStatus.OK).body( new MessageDTO(HttpStatus.OK, false,
                gameInterface.getGameDTO(idGame)));
    }

}
