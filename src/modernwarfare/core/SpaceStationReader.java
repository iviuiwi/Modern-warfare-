package modernwarfare.core;

import arc.ApplicationListener;
import arc.Core;

import mindustry.Vars;
import mindustry.type.Planet;
import modernwarfare.MWVars;
import modernwarfare.type.SpaceStation;

import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public class SpaceStationReader implements ApplicationListener {
    public void read(){
        for (String s : MWVars.SpaceStationFi.readString().split("/")) {
            Planet parent = Vars.content.planet(s);
            if(parent != null){
                String whiteSpace = Objects.equals(Core.bundle.get("spacestationwhitespace"), "true") ? " " : "";
                SpaceStation spaceStation = new SpaceStation(parent.name + "-spacestation", parent);
                spaceStation.localizedName = parent.localizedName + whiteSpace + Core.bundle.get("spacestation");
                MWVars.spaceStations.add(spaceStation);
                MWVars.spaceStationPlanets.add(parent);
            }
        }
    }
    @Override
    public void exit(){
        Writer writer = MWVars.SpaceStationFi.writer(false);
        try {
            for (Planet p : MWVars.spaceStationPlanets) {
                if (p != null) {
                    writer.write(p.name);
                    writer.append('/');
                }
            }
            writer.flush();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
