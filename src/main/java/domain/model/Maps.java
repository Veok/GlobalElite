package domain.model;

/**
 * Created by L on 10.11.2016.
 */
public enum Maps {

    Aztec, Dust, Dust2, Cache, Cobble, Inferno, Mirage, Nuke, Overpass, Train,
    Vertigo, Assault, Italy, Militia, Office;


    public static Maps getByName(String enumName) {
        for (Maps maps : Maps.values()) {
            if (maps.toString().equalsIgnoreCase(enumName)) {
                return maps;
            }
        }
        return null;
    }
}
