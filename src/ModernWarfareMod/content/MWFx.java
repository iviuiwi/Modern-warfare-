package ModernWarfareMod.content;

import arc.graphics.Color;
import arc.graphics.g2d.Fill;
import arc.math.geom.Vec2;
import mindustry.entities.Effect;

import static arc.graphics.g2d.Draw.color;
import static arc.math.Angles.randLenVectors;
import static java.awt.Color.white;

public class MWFx {

    public static Effect maoyan;

    public static void load() {
        maoyan = new Effect(90, e -> {
            randLenVectors(e.id, 7, 9f + e.fin() * 5f, (x, y) -> {
                color(Color.white, e.color, e.fin());
                Fill.square(e.x + x, e.y + y, 1f + e.fout() * 2f, 45);
            }
            );
        }
        );
    }
}

