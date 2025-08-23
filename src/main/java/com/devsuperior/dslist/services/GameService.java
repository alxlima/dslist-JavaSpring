
// NOTA: Esta classe ? ( Camada de Servicos ) Entities / ORM -- > retorna um DTO
//para incluir as regras de negocios e opera??es do sistema
package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

//@Component // usado como extensão do jpa como injeção de dependencias.
@Service // usa o GameService como componente do sistema.
public class GameService {

    // injetar uma instancia do gameRepository em gameService.
    @Autowired // notation de dependencia faço injeção do repository
    private GameRepository gameRepository;

    // Busco o DTO da classe GameDTO, entidade Game filtrado todos campos.
    @Transactional(readOnly = true) // defino meu service como transacional operacões do banco de dados vão
                                    // obdecerem o sid id.
                                    // readOnly == true, sem operações scrita, melhora eficiencia transactions.
    public GameDTO findById(@PathVariable Long listId) {
        Game result = gameRepository.findById(listId).get();
        return new GameDTO(result);
    }

    // Busco o DTO da classe GameMinDTO, entidade Game filtrado alguns campos.
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll() {
        // faço uma consulta pegando o games e retorno para service
        List<Game> result = gameRepository.findAll(); // <Game>: entidade classe todos os campos.
        // transformo lista de game para gamesDTO campos filtrados.
        // Exemplo:01
        // List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
        // return dto;
        // Exemplo:01
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(Long listId) {
        List<GameMinProjection> result = gameRepository.searchByList(listId);
        // return games.stream().map(GameMinDTO::new).toList(); // Original back
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    // @Transactional(readOnly = true)
    // public List<GameMinDTO> findByGameList(Long listId) {
    // List<GameMinProjection> games = gameRepository.searchByList(listId);
    // return games.stream().map(GameMinDTO::new).toList();
    // }
}
