package ModernWarfareMod.content;

import arc.graphics.Color;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.game.Team;
import mindustry.graphics.g3d.HexMesh;
import mindustry.graphics.g3d.HexSkyMesh;
import mindustry.graphics.g3d.MultiMesh;
import mindustry.graphics.g3d.SunMesh;
import mindustry.maps.planet.ErekirPlanetGenerator;
import mindustry.type.Planet;
import mindustry.world.meta.Attribute;
import mindustry.world.meta.Env;

import static mindustry.Vars.failedToLaunch;
import static mindustry.Vars.state;
import static mindustry.ctype.ContentType.sector;

public class MWPlanets{
    public static Planet
            bigsun,
            Zion;

    public static void load() {

        bigsun = new Planet("bigsun", null, 4f){{
            bloom = true;
            accessible = false;

            meshLoader = () -> new SunMesh(
                    this, 4,
                    5, 0.3, 1.7, 1.2, 1,
                    1.1f,
                    Color.valueOf("d8bfd8"),
                    Color.valueOf("c71585"),
                    Color.valueOf("dda0dd"),
                    Color.valueOf("8a2be2"),
                    Color.valueOf("7b68ee"),
                    Color.valueOf("6a5acd")
            );
        }};

        Zion = new Planet("Zion", bigsun, 1f, 2) {{
            generator = new ErekirPlanetGenerator();
            meshLoader = () -> new HexMesh(this, 5);
            cloudMeshLoader = () -> new MultiMesh(
                    new HexSkyMesh(this, 2, 0.15f, 0.14f, 5, Color.valueOf("808080").a(0.75f), 2, 0.42f, 1f, 0.43f),
                    new HexSkyMesh(this, 3, 0.6f, 0.15f, 5, Color.valueOf("696969").a(0.75f), 2, 0.42f, 1.2f, 0.45f)
        );
            alwaysUnlocked = true;
            landCloudColor = Color.valueOf("f5f5f5");
            atmosphereColor = Color.valueOf("dcdcdc");
            startSector = 1;
            atmosphereRadIn = 0.02f;
            atmosphereRadOut = 0.3f;
            tidalLock = true;
            orbitSpacing = 2f;
            totalRadius += 2.6f;
            lightSrcTo = 0.5f;
            lightDstFrom = 0.2f;
            clearSectorOnLose = true;
            defaultCore = Blocks.coreBastion;
            iconColor = Color.valueOf("bebebe");
            enemyBuildSpeedMultiplier = 0.4f;

            //TODO disallowed for now
            allowLaunchToNumbered = false;

            //TODO SHOULD there be lighting?
            defaultAttributes.set(Attribute.heat, 0.3f);

            ruleSetter = r -> {
                r.waveTeam = Team.malis;
                r.placeRangeCheck = false;
                r.showSpawns = true;
                r.fog = false;
                r.staticFog = true;
                r.lighting = false;
                r.coreDestroyClear = true;
                r.onlyDepositCore = true;
            };

            unlockedOnLand.add(Blocks.coreBastion);
        }};
    }
}