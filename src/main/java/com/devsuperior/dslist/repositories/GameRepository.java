// Nota: Inteface Repository ( Camada de acessso a dados) Entities / ORM
//para transações com banco de dados, inserir , deletar editar etc. tudo pelo jpaRepository
package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

//jpaRepository - framework para executar transações de DML no banco
public interface GameRepository extends JpaRepository<Game, Long> {

}
