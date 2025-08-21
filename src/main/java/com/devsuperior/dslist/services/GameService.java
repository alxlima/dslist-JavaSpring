
// NOTA: Esta classe é ( Camada de Servicos ) Entities / ORM -- > retorna um DTO
//para incluir as regras de negocios e operações do sistema
package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

//@Component // usado como extensão do jpa como injeção de dependencias.
@Service // usa o GameService como componente do sistema.
public class GameService {

    // injetar uma instancia do gameRepository em gameService.
    @Autowired // notation de dependencia faço injeção do repository
    private GameRepository gameRepository;

    // Busco do banco de dados DTO da classe GameMinDTO , lista de games
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
}
