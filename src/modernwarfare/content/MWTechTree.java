package modernwarfare.content;

import arc.struct.Seq;
import mindustry.content.Blocks;
import mindustry.content.Items;
import mindustry.content.TechTree;
import mindustry.ctype.UnlockableContent;
import mindustry.game.Objectives.Objective;
import mindustry.type.ItemStack;

import static mindustry.content.Blocks.*;
import static mindustry.content.TechTree.TechNode;

public class MWTechTree {
    public static TechNode context = null;

    public static void load() {
        //S
        addToNode(duo, () -> node(MWBlocks.jiexi));
        addToNode(groundFactory, () -> node(MWUnitTypes.xns));
        addToNode(MWUnitTypes.xns, () -> node(MWUnitTypes.nsxpp));
        addToNode(Blocks.copperWall, () -> node(MWBlocks.gangbanqiang));
        addToNode(MWItems.tie, () -> node(MWBlocks.gangbanlianzhi,() -> node(MWBlocks.yangqishouji,() -> node(MWBlocks.anqiyang,() -> node(MWBlocks.meitanzhuan)))));
        addToNode(MWBlocks.anqiyang, () -> node(MWBlocks.chaonengyuanji));
        addToNode(MWBlocks.yangqishouji,() -> node(MWBlocks.danqiyindaoji,() -> node(MWBlocks.anqihechengchang)));
        addToNode(MWItems.tie,() -> node(MWBlocks.danyaorongzhichang));
        addToNode(MWItems.shiying,() -> node(MWBlocks.huahewulianzhilu));
        addToNode(Items.copper,() -> node(MWBlocks.shiyingfensuichang));
        addToNode(MWBlocks.yangqishouji, () -> node(MWBlocks.kuangzhaningjuji));
        addToNode(MWBlocks.yangqishouji, () -> node(MWBlocks.shuitiefanyingji));

    }

    public static void addToNode(UnlockableContent p, Runnable c) {
        context = TechTree.all.find(t -> t.content == p);
        c.run();
    }
    public static void node(UnlockableContent content, Runnable children){
        node(content, content.researchRequirements(), children);
    }

    public static void node(UnlockableContent content, ItemStack[] requirements, Runnable children){
        node(content, requirements, null, children);
    }

    public static void node(UnlockableContent content, ItemStack[] requirements, Seq<Objective> objectives, Runnable children){
        TechNode node = new TechNode(context, content, requirements);
        if(objectives != null){
            node.objectives.addAll(objectives);
        }

        TechNode prev = context;
        context = node;
        children.run();
        context = prev;
    }

    public static void node(UnlockableContent block){
        node(block, () -> {});
    }
}