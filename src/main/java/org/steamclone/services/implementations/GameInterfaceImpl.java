package org.steamclone.services.implementations;

import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.ManyToMany;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.steamclone.dtos.BusinessDTO;
import org.steamclone.dtos.GameDTO;
import org.steamclone.dtos.ImageDTO;
import org.steamclone.dtos.TagDTO;
import org.steamclone.models.entities.Business;
import org.steamclone.models.entities.Game;
import org.steamclone.models.entities.Tag;
import org.steamclone.repositories.GameRepo;
import org.steamclone.services.interfaces.BusinessInterface;
import org.steamclone.services.interfaces.GameInterface;
import org.steamclone.services.interfaces.TagInterface;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GameInterfaceImpl implements GameInterface {

    GameRepo gameRepo;
    BusinessInterface businessInterface;
    TagInterface tagInterface;

    @Override
    public int createGame(GameDTO gameDTO) {

        Game game = new Game();

        game.setName(gameDTO.getName());
        game.setReleaseDate(gameDTO.getReleaseDate());
        game.setRealPrice(gameDTO.getRealPrice());
        game.setPrice(gameDTO.getPrice());
        game.setDiscount(gameDTO.getDiscount());
        game.setDescription(gameDTO.getDescription());
        game.setRequeriments(gameDTO.getRequeriments());
        game.setClasification(gameDTO.getClasification());
        game.setPuntuation(0);

        List<Business> listBusiness = new ArrayList<>();

        for (BusinessDTO businessDTO: gameDTO.getBusinesses()) {
            listBusiness.add(businessInterface.getBusiness(businessDTO.getId()));
        }

        game.setBusinesses(listBusiness);

        List<Tag> listTags = new ArrayList<>();

        for (TagDTO tagDTO: gameDTO.getTags()) {
            listTags.add(tagInterface.getTag(tagDTO.getId()));
        }

        game.setTags(listTags);

        game.setLanguages(gameDTO.getLanguages());

        gameRepo.save(game);


        return game.getId();
    }

    @Override
    public int updateGame(int id, GameDTO gameDTO) {
        return 0;
    }

    @Override
    public int deleteGame(int id) {
        return 0;
    }

    @Override
    public List<GameDTO> listAllGames() {

        List<Game> listGame = gameRepo.findAll();
        List<GameDTO> listGameDTO = new ArrayList<>();

        for (Game game: listGame) {
            listGameDTO.add(converToDTO(game));
        }

        return listGameDTO;
    }

    @Override
    public List<GameDTO> listGameByTag(String tag) {
        List<Game> listGame = gameRepo.listGameByTag(tag);
        List<GameDTO> listGameDTO = new ArrayList<>();

        for (Game game: listGame) {
            listGameDTO.add(converToDTO(game));
        }

        return listGameDTO;
    }

    @Override
    public List<GameDTO> listGameByName(String name) {
        List<Game> listGame = gameRepo.listGameByName(name);
        List<GameDTO> listGameDTO = new ArrayList<>();

        for (Game game: listGame) {
            listGameDTO.add(converToDTO(game));
        }

        return listGameDTO;
    }

    @Override
    public List<GameDTO> listGameByPrice(float minPrice, float maxPrice) {

        List<Game> listGame = gameRepo.listGameByPrice(minPrice,maxPrice);
        List<GameDTO> listGameDTO = new ArrayList<>();

        for (Game game: listGame) {
            listGameDTO.add(converToDTO(game));
        }

        return listGameDTO;
    }

    @Override
    public List<GameDTO> listGameByIdBusiness(int idBusiness) {
        List<Game> listGame = gameRepo.listGameByIdBusiness(idBusiness);
        List<GameDTO> listGameDTO = new ArrayList<>();

        for (Game game: listGame) {
            listGameDTO.add(converToDTO(game));
        }

        return listGameDTO;
    }

    @Override
    public List<GameDTO> listFavoriteGame(int idUser) {

        List<Game> listGame = gameRepo.listFavoriteGame(idUser);
        List<GameDTO> listGameDTO = new ArrayList<>();

        for (Game game: listGame) {
            listGameDTO.add(converToDTO(game));
        }

        return listGameDTO;
    }

    @Override
    public List<GameDTO> listGameByIdUser(int idUser) {
         List<Game> listGame = gameRepo.listGameByIdUser(idUser);
        List<GameDTO> listGameDTO = new ArrayList<>();

        for (Game game: listGame) {
            listGameDTO.add(converToDTO(game));
        }

        return listGameDTO;
    }

    @Override
    public GameDTO getGameDTO(int idGame) {
        return converToDTO(gameRepo.findById(idGame).get());
    }

    public Game getGame(int idGame) {
        return gameRepo.findById(idGame).get();
    }

    public GameDTO converToDTO(Game game){

        GameDTO gameDTO = new GameDTO(
                game.getId(),
                game.getName(),
                game.getReleaseDate(),
                game.getRealPrice(),
                game.getPrice(),
                game.getDiscount(),
                game.getDescription(),
                game.getRequeriments(),
                game.getClasification(),
                game.getPuntuation(),
                businessInterface.listByIdGame(game.getId()),
                tagInterface.listTagByIdGame(game.getId()),
                game.getLanguages(),
                convertImageToDTO(game.getImages())
        );

        return gameDTO;
    }

    private Map<String, String> convert(List<ImageDTO> imageDTOS){
        Map<String, String> mapa = new HashMap<>();
        imageDTOS.forEach(obj -> mapa.put(obj.getId(), obj.getUrl()));
        return mapa;
    }

    private List<ImageDTO> convertImageToDTO(Map<String, String> map){

        List<ImageDTO> lista = new ArrayList<>();

        for(String key : map.keySet()){
            lista.add(new ImageDTO(key, map.get(key)));
        }

        return lista;
    }
}
