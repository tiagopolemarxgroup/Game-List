package br.com.api.gamelist.dto;

import br.com.api.gamelist.entities.Game;
import lombok.Data;
import org.springframework.beans.BeanUtils;
@Data
public class GameDTO {
    private Long id;
    private String title;
    private Integer year;
    private String genre;
    private String platforms;
    private Double score;
    private String imgUrl;
    private String shortDescription;
    private String longDescription;

    public GameDTO(Game game) {
        BeanUtils.copyProperties(game, this);
    }
}
