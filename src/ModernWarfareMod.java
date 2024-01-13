import arc.util.Log;
import mindustry.mod.Mod;
import modernwarfare.content.*;
import modernwarfare.environment.MWflot;


public class ModernWarfareMod extends Mod {
    public ModernWarfareMod() {
        Log.info("Loaded ModernWarfareMod constructor.");
    }


    @Override
    public void loadContent() {
        super.loadContent();
        Log.info("Loading some ModernWarfareMod content.");
        MWItems.load();
        MWLiquids.load();
        MWflot.load();
        MWUnitTypes.load();
        MWBlocks.load();
        MWStatusEffects.load();
        MWPlanets.load();
        SectorPresets.load();
        MWTechTree.load();
    }
}