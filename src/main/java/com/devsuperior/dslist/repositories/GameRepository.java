// Nota: Inteface Repository ( Camada de acessso a dados) Entities / ORM
//para transaçõeses com banco de dados, inserir , deletar editar etc. tudo pelo jpaRepository
package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

//jpaRepository - framework para executar transações de DML no banco
public interface GameRepository extends JpaRepository<Game, Long> {

    // Crio um consulta sql customizada padrão jpa
    @Query(nativeQuery = true, value = """
            SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
            tb_game.short_description AS shortDescription, tb_belonging.position
            FROM tb_game
            INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
            WHERE tb_belonging.list_id = :listId
            ORDER BY tb_belonging.position
            	""")
    List<GameMinProjection> searchByList(Long listId); // Parametro Get list ID de entrada, pela interface
                                                       // projections/GameMinProjection
}
