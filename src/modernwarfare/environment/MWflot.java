package modernwarfare.environment;

import mindustry.world.blocks.environment.OreBlock;
import modernwarfare.content.MWItems;

public class MWflot {
    public static OreBlock tiekuang;

    public static void load() {

        tiekuang = new OreBlock("tie-kuang") {
            {
                playerUnmineable = true;
                itemDrop = MWItems.tie;
                variants = 3;
//        mapColor=;
                useColor = true;
                oreDefault = true;
                oreThreshold = 0.9f;
                oreScale = 35;
            }
        };
    }
}