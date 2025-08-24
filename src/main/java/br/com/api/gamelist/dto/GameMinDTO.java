package br.com.api.gamelist.dto;

import br.com.api.gamelist.entities.Game;
import br.com.api.gamelist.repositories.projections.GameMinProjection;
import lombok.Getter;

@Getter
public class GameMinDTO {
    private Long id;
    private String title;
    private String year;
    private String imgUrl;
    private String shortDescription;

    public GameMinDTO() {}
    public GameMinDTO(Game game) {
        this.id = game.getId();
        this.title = game.getTitle();
        this.year = game.getYear().toString();
        this.imgUrl = game.getImgUrl();
        this.shortDescription = game.getShortDescription();
    }

    public GameMinDTO(GameMinProjection projection) {
        this.id = projection.getId();
        this.title = projection.getTitle();
        this.year = projection.getGameYear().toString();
        this.imgUrl = projection.getImgUrl();
        this.shortDescription = projection.getShortDescription();
    }
}
