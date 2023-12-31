import ModernWarfareMod.content.*;
import ModernWarfareMod.content.expand.block.drawer.DrawFactories;
import arc.util.Log;
import mindustry.mod.Mod;

public class ModernWarfareMod extends Mod {
    public ModernWarfareMod() {
        Log.info("Loaded ModernWarfareMod constructor.");
    }


    @Override
    public void loadContent() {
        super.loadContent();
        Log.info("Loading some ModernWarfareMod content.");
        DrawFactories.load();
        MWFx.load();
        MWItems.load();
        MWLiquids.load();
        MWBlocks.load();
        MWUnitTypes.load();
        MWStatusEffects.load();
        MWPlanets.load();
        SectorPresets.load();
        MWTechTree.load();
    }

}