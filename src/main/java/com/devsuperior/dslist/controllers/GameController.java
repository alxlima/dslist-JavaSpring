// NOTA: Esta classe ? (Controler REST)- Camada (DTO) Data Transfer Objects
// porta de entrada do FrontEnd , para uso na API - Front-End chama o controlador (expoem EndPont - para mundo externo)
// este controlador chama o services-> repository -> Entidade do banco de dados.
//---------------------------------------------------------------------------
package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.services.GameService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@RestController // notation que config. a class como controller.
@RequestMapping(value = "/games") // crio recurso, configuro o caminho da minha API.
public class GameController {

    @Autowired // notation, fa�o a inje��o de um service no controller.
    private GameService gameService;

    @GetMapping(value = "/{id}") // notation, fa�o uso do metodo GET com parametro ID( game)
    public GameDTO findById(@PathVariable Long id) {
        GameDTO result = gameService.findById(id);
        return result;
    }

    @GetMapping // notation, fa�o uso do metodo GET sem parametros. mais campos filtrado
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> result = gameService.findAll();
        return result;
    }

}
