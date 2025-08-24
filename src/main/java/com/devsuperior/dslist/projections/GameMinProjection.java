package com.devsuperior.dslist.projections;

//Obtenho metodos get para consulta sql customizados no repository/ gameRepository.
//este metodos retorna dados para cada consulta que for criar customizada.
public interface GameMinProjection {

	Long getId();

	String getTitle();

	Integer getGameYear();

	String getImgUrl();

	String getShortDescription();

	Integer getPosition();
}
