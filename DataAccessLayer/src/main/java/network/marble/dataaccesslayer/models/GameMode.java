package network.marble.dataaccesslayer.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import network.marble.dataaccesslayer.exceptions.APIException;
import network.marble.dataaccesslayer.models.base.BaseModel;
import okhttp3.Request;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Data
@ToString(callSuper = true)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GameMode extends BaseModel<GameMode> {
    public GameMode(){
        super("games/modes", "gamemodes", "gamemode");
    }

    @Getter @Setter
    public String name;

    @Getter @Setter
    public UUID game_id;

    @Getter @Setter
    public String description;

    public String iconMap;

    @Getter @Setter
    public boolean isLive;

    @Getter @Setter
    public boolean isActive;

    @Getter @Setter
    public boolean isBeta;

    @Getter @Setter
    public int minPlayerCount;

    @Getter @Setter
    public int maxPlayerCount;

    @Getter @Setter
    public int minJoiningTeamSize;

    @Getter @Setter
    public int maxJoiningTeamSize;

    @Getter @Setter
    public int minTeamCount;

    @Getter @Setter
    public int maxTeamCount;

    /*public Map<String, Object> getIconMap() {
    	Gson g = new Gson();
    	Map<String, Object> map = null;
    	if (iconMap != null && !iconMap.isEmpty()) {
    		map = g.fromJson(iconMap, new TypeToken<Map<String, Object>>(){}.getType());
    	}
		return map;
    }

    public void setIconMap(Map<String, Object> map) {
        Gson g = new Gson();
        iconMap = g.toJson(map);
    }*/

    public List<GameMode> getGameModesByGameId(UUID uuid) throws APIException {
        return getMultiple("games/"+uuid.toString()+"/modes/");
    }

    @Override
    public Class<?> getTypeClass() {
        return GameMode.class;
    }
}
