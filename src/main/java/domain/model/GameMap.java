package domain.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author L on 30.11.2016.
 */

public class GameMap implements IHaveId {


    private int id;
    private String name;

    public GameMap() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameOfMap() {
        return name;
    }

    public void setNameOfMap(String nameOfMap) {
        this.name = nameOfMap;
    }


}
