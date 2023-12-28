package ModernWarfareMod.content;

import mindustry.type.*;

public class SectorPresets{
    public static SectorPreset
    jingji,xunzhao;

    public static void load(){

        jingji = new SectorPreset("jing-ji-po-jiang", MWPlanets.Zion, 1){{
            difficulty = 1;
        }};

        xunzhao = new SectorPreset("xun-zhao", MWPlanets.Zion, 15){{
            difficulty = 1;
        }};
    }
}
