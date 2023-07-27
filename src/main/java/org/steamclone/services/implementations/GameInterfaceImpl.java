package org.steamclone.services.implementations;

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

import java.util.*;

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
        game.setPrice(calculatePrice(gameDTO.getRealPrice(), gameDTO.getDiscount()));
        game.setDiscount(gameDTO.getDiscount());
        game.setDescription(gameDTO.getDescription());
        game.setRequeriments(gameDTO.getRequeriments());
        game.setClasification(gameDTO.getClasification());
        game.setPuntuation(0);
        game.setState(true);

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

    private double calculatePrice(double realPrice, int discount) {

        double mountDiscount = (realPrice*discount)/100;
        double price = realPrice-mountDiscount;
        return price;

    }

    @Override
    public int updateGame(int id, GameDTO gameDTO) throws Exception {

        Optional<Game> foundGame = gameRepo.findById(id);

        if (foundGame.isEmpty()) {
            throw new Exception("El juego con id " + id + " no existe");
        }

        Game updateGame = foundGame.get();

        updateGame.setName(gameDTO.getName());
        updateGame.setReleaseDate(gameDTO.getReleaseDate());
        updateGame.setRealPrice(gameDTO.getRealPrice());
        double realPrice = gameDTO.getRealPrice();
        int discount = gameDTO.getDiscount();
        updateGame.setPrice(calculatePrice(realPrice, discount));
        updateGame.setDiscount(gameDTO.getDiscount());
        updateGame.setDescription(gameDTO.getDescription());
        updateGame.setRequeriments(gameDTO.getRequeriments());
        updateGame.setClasification(gameDTO.getClasification());
        updateGame.setPuntuation(gameDTO.getPuntuation());
        updateGame.setImages(convert(gameDTO.getImages()));

        List<Tag> listTags = new ArrayList<>();
        for (TagDTO tagDTO: gameDTO.getTags()) {
            listTags.add(tagInterface.getTag(tagDTO.getId()));
        }
        updateGame.setTags(listTags);

        List<Business> listBusiness = new ArrayList<>();
        for (BusinessDTO businessDTO: gameDTO.getBusinesses()) {
            listBusiness.add(businessInterface.getBusiness(businessDTO.getId()));
        }
        updateGame.setBusinesses(listBusiness);

        updateGame.setLanguages(gameDTO.getLanguages());

        gameRepo.save(updateGame);

        return updateGame.getId();
    }

    @Override
    public boolean deleteGame(int id) throws Exception {

        Optional<Game> foundGame = gameRepo.findById(id);

        if (foundGame.isEmpty()) {
            throw new Exception("El juego con id " + id + " no existe");
        }

        Game deleteGame = foundGame.get();

        deleteGame.setState(false);

        gameRepo.save(deleteGame);

        return deleteGame.isState();
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
                convertImageToDTO(game.getImages()),
                game.isState()
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
