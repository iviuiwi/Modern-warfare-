package modernwarfare;

import arc.files.Fi;
import arc.files.ZipFi;
import arc.struct.Seq;
import arc.util.serialization.Jval;
import mindustry.Vars;
import mindustry.type.Planet;
import modernwarfare.core.SpaceStationReader;
import modernwarfare.type.SpaceStation;
import modernwarfare.ui.MWUI;
import modernwarfare.util.MWUtil;

import java.util.Objects;

public class MWVars {
    public static String modName = "disintegration";
    public static int spaceStationRequirement = 10000;
    public static int spaceStationBaseRequirement = 2;
    public static boolean debugMode = true;

    public static MWUI DTUI = new MWUI();
    public static SpaceStationReader spaceStationReader = new SpaceStationReader();

    public static Fi DTRoot = MWUtil.getFiChild(Vars.dataDirectory, modName + "/");
    public static ZipFi DTModFile;
    public static Fi SpaceStationFi = MWUtil.createFi(DTRoot, "spaceStations.txt");

    public static Seq<SpaceStation> spaceStations = new Seq<>();
    public static Seq<Planet> spaceStationPlanets = new Seq<>();

    public static void init() {
        Seq<Fi> modFiles = Vars.modDirectory.findAll(f -> {
            Fi metaFile = null;
            try {
                Fi zip = f.isDirectory() ? f : new ZipFi(f);
                for(String name : new String[]{"mod.json", "mod.hjson", "plugin.json", "plugin.hjson"}){
                    if((metaFile = zip.child(name)).exists()){
                        break;
                    }
                }
                if (!metaFile.exists()) return false;
                String name = Jval.read(metaFile.readString()).getString("name");
                return Objects.equals(name, modName);
            }catch(Throwable ignored){
                return false;
            }
        });
        if (!modFiles.isEmpty()) DTModFile = new ZipFi(modFiles.first());
        DTUI.init();
    }
}
