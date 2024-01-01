package modernwarfare.ui;

import arc.ApplicationListener;
import arc.scene.ui.layout.Table;
import mindustry.gen.Icon;
import mindustry.type.Planet;
import modernwarfare.type.SpaceStation;

import static mindustry.Vars.ui;
import static modernwarfare.MWVars.spaceStationPlanets;
import static modernwarfare.MWVars.spaceStations;

public class MWUI implements ApplicationListener {
    /*public SpaceStationDialog spaceStation;
    public SpaceStationBuildDialog spaceStationBuild;

    public boolean added = false;

    @Override
    public void init(){
        spaceStation = new SpaceStationDialog();
        spaceStationBuild = new SpaceStationBuildDialog();
    }*/
    public boolean added = false;
    Planet p;
    @Override
    public void update(){
        ui.planet.shown(() -> {
            added = false;
        });
        p = ui.planet.state.planet;
        if(!added)ui.planet.stack(new Table(t -> {
            t.button(Icon.trash, () -> ui.showConfirm("@confirm", "@disintegration.clearspacestation.confirm", () -> {
                spaceStations.remove((SpaceStation) p);
                spaceStationPlanets.remove(p.parent);
                p.accessible = false;
                p.visible = false;
                p.sectors.clear();
                ui.planet.show();
            })).visible(() -> p instanceof SpaceStation);
        }));
        added = true;
    }
}
