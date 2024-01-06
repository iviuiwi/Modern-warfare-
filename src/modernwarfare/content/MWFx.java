package modernwarfare.content;

import arc.graphics.Color;
import arc.graphics.g2d.Draw;
import arc.graphics.g2d.Fill;
import arc.graphics.g2d.Lines;
import arc.math.Angles;
import arc.math.Interp;
import arc.math.Mathf;
import mindustry.entities.Effect;
import mindustry.graphics.Drawf;
import mindustry.graphics.Layer;
import modernwarfare.util.graphic.DrawFunc;

import static arc.Core.atlas;
import static arc.graphics.g2d.Draw.*;
import static arc.graphics.g2d.Lines.*;
import static arc.math.Angles.randLenVectors;
import static arc.math.Mathf.rand;

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


    public static Effect xuan(float size, float angleRange){
        int num = Mathf.clamp((int)size / 6, 6, 20);
        float thick = Mathf.clamp(0.75f, 2f, size / 22f);

        return new Effect(37f, e -> {
            color(e.color, Color.white, e.fout() * 0.7f);
            rand.setSeed(e.id);
            DrawFunc.randLenVectors(e.id, num, 4 + (size * 1.2f) * e.fin(), size * 0.15f * e.fin(), e.rotation, angleRange, (x, y) -> {
                Lines.stroke(thick * e.fout(0.32f));
                lineAngle(e.x + x, e.y + y, Mathf.angle(x, y), (e.fslope() + e.fin()) * 0.5f * (size * rand.random(0.15f, 0.5f) + rand.random(2f)) + rand.random(2f));
                Drawf.light(e.x + x, e.y + y, e.fslope() * (size * 0.5f + 14f) + 3, e.color, 0.7f);
            });
        });
    }


    public static Effect lle
            (Color color, float range){
        float lifetime = Mathf.clamp(range * 1.5f, 90f, 600f);
        return new Effect(lifetime, range * 2.5f, e -> {
            color(color);
            Drawf.light(e.x, e.y, e.fout() * range, color, 0.7f);

            e.scaled(lifetime / 3, t -> {
                stroke(3f * t.fout());
                circle(e.x, e.y, 8f + t.fin(Interp.circleOut) * range * 1.35f);
            });

            e.scaled(lifetime / 2, t -> {
                Fill.circle(t.x, t.y, t.fout() * 8f);
            });

            Draw.z(Layer.bullet - 0.001f);
            color(Color.gray);
            alpha(0.85f);
            float intensity = Mathf.clamp(range / 10f, 5f, 25f);
            for(int i = 0; i < 4; i++){
                rand.setSeed(((long)e.id << 1) + i);
                float lenScl = rand.random(0.4f, 1f);
                int fi = i;
                e.scaled(e.lifetime * lenScl, eIn -> {
                    randLenVectors(eIn.id + fi - 1, eIn.fin(Interp.pow10Out), (int)(intensity / 2.5f), 8f * intensity, (x, y, in, out) -> {
                        float fout = eIn.fout(Interp.pow5Out) * rand.random(0.5f, 1f);
                        Fill.circle(eIn.x + x, eIn.y + y, fout * ((2f + intensity) * 1.8f));
                    });
                });
            }
        });
    }
}
