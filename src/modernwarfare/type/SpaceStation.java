package modernwarfare.type;

import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.PlanetGrid;
import mindustry.type.Planet;
import mindustry.type.Sector;
import mindustry.world.meta.Env;
import modernwarfare.content.MWBlocks;

public class SpaceStation extends Planet {
    public SpaceStation(String name, Planet parent) {
        super(name, parent, 0.05f);
        mesh = new HexMesh(this, 0);
        sectors.add(new Sector(this, PlanetGrid.Ptile.empty));
        hasAtmosphere = false;
        updateLighting = false;
        drawOrbit = true;
        accessible = true;
        //clipRadius = -1;
        orbitRadius = parent.radius + 2f;
        alwaysUnlocked = true;
        defaultEnv = Env.space;
        icon = "commandRally";
        defaultCore = MWBlocks.shiyingqiang;
    }
}
