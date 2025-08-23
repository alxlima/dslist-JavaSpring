
// Classe que serve com chave primaria pk para entidade Belonging  
package com.devsuperior.dslist.entities;

import java.util.Objects;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable // Defino encapsulamento de 2 atributos classe ( 1 classe: Game e 1 Classe:
			// List), em uma só.
public class BelongingPK {

	@ManyToOne // defino que cardinalidade é muitos para 1
	@JoinColumn(name = "game_id") // defino a chave FK - Game
	private Game game;

	@ManyToOne
	@JoinColumn(name = "list_id") // digino a chave fk - List
	private GameList list;

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public GameList getList() {
		return list;
	}

	public void setList(GameList list) {
		this.list = list;
	}

	// crio uma camparação das chaves tanto game, quanto list
	@Override
	public int hashCode() {
		return Objects.hash(game, list);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BelongingPK other = (BelongingPK) obj;
		return Objects.equals(game, other.game) && Objects.equals(list, other.list);
	}
}
