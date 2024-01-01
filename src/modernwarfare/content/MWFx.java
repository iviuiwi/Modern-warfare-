package modernwarfare.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.math.Angles;
import arc.math.Interp;
import mindustry.entities.Effect;

import static arc.Core.atlas;
import static arc.graphics.g2d.Draw.color;
import static arc.input.KeyCode.e;
import static arc.math.Angles.randLenVectors;

public class MWFx {

    public static final Effect

        maoyan = new Effect(110, e -> {
            randLenVectors(e.id, 10, 9f + e.fin() * 5f, (x, y) -> {
                color(Color.white, e.color, e.fin());
                Fill.square(e.x + x, e.y + y, 1f + e.fout() * 2f, 45);
            }
            );
        });
    public static Effect

    quarryDrillEffect = new Effect(60, e -> {
        color(e.color, Color.gray, e.fin() * 3 >= 1 ? 1 : e.fin() * 3);
        Draw.rect(atlas.find("large-orb"), e.x + Angles.trnsx(e.rotation, e.fin(Interp.pow5Out) * 20), e.y + Angles.trnsy(e.rotation, e.fin(Interp.pow5Out) * 20), e.foutpow() * 8f + 2, e.foutpow() * 8f + 2);
    });
}
