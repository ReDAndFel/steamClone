package org.steamclone.services.interfaces;

import org.steamclone.dtos.GameDTO;
import org.steamclone.models.entities.Game;

import java.util.List;

public interface GameInterface {

    public int createGame(GameDTO gameDTO);
    public int updateGame(int id, GameDTO gameDTO) throws Exception;
    public boolean deleteGame(int id) throws Exception;
    public List<GameDTO> listAllGames();
    public List<GameDTO> listGameByTag(String tag);
    public List<GameDTO> listGameByName(String name);
    public List<GameDTO> listGameByPrice(float minPrice, float maxPrice);
    public List<GameDTO> listGameByIdBusiness(int idBusiness);
    public List<GameDTO> listFavoriteGame(int idUser);
    public List<GameDTO> listGameByIdUser(int idUser);
    public GameDTO getGameDTO(int idGame) throws Exception;
    public Game getGame(int idGame) throws Exception;



}
