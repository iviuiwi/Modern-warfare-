package ModernWarfareMod.content;

import arc.graphics.Color;
import mindustry.ai.UnitCommand;
import mindustry.content.Fx;
import mindustry.entities.bullet.BasicBulletType;
import mindustry.entities.bullet.BulletType;
import mindustry.entities.bullet.MissileBulletType;
import mindustry.entities.bullet.SapBulletType;
import mindustry.entities.pattern.ShootSpread;
import mindustry.gen.LegsUnit;
import mindustry.gen.MechUnit;
import mindustry.gen.Sounds;
import mindustry.type.UnitType;
import mindustry.type.Weapon;
import mindustry.type.unit.ErekirUnitType;

public class MWUnitTypes {
    public static UnitType nsxpp,xns,feiji1;

    public static void load() {
        MWUnitTypes instance = new MWUnitTypes();
        instance.createUnitType();
    }

    public void createUnitType() {

        feiji1 = new UnitType("fei-ji-1"){
            {
                constructor = MechUnit::create;
                BulletType h = new MissileBulletType(){{
                    lifetime = 90f;
                    damage = 2024f;
                    speed = 12f;
                }};
                weapons.add(
                        new Weapon("2"){
                            {
                                mirror = true;
                                this.top = false;

                                rotate = true;
                                rotationLimit = 15f;

                                x = 5f;
                                y = -1f;
                                shootY = 6f;
                                reload = 15f;
                                shoot = new ShootSpread() {{
                                    shots = 3;
                                    spread = 3;
                                }};
                                inaccuracy = 4f;
                                velocityRnd = 0.15f;
                                shootSound = Sounds.artillery;
                                shake = 0.75f;
                                bullet = h;
                                }}
                        );
                speed = 0.6F;
                hitSize = 8.0F;
                health = 160.0F;
            }};

        nsxpp = new UnitType("ns-x-pp"){{
            constructor = LegsUnit::create;
            speed = 3.2F;
            drag = 0.1F;
            hitSize = 21.0F;
            rotateSpeed = 3.0F;
            health = 2024520;
            armor = 10.0F;
            legCount = 4;//腿数
            legLength = 60.0F;//腿长
            legGroupSize = 1;//腿群大小
            legExtension = -4.5F;//腿伸长
            legBaseOffset = 7.0F;//腿离单位中心距离
            legLengthScl = 0.925F;//每次移动脚尝试向单位中心远离倍率(不能理解为腿长短缩放)
            legMoveSpace = 3.047F;//腿速
            hovering = true;//悬浮
            groundLayer = 74.0F;//图层
            faceTarget = false;

            BulletType s = new SapBulletType(){{
                width = 1.5f;
                damage = 2024f;
                length = 70f;
            }};
            weapons.addAll(
                    new Weapon("1"){{
                        y = -7f;
                        x = 9f;
                        shootY = 7f;
                        reload = 45;
                        shake = 3f;
                        rotateSpeed = 1.5f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.artillery;
                        rotate = true;
                        shadow = 8f;
                        recoil = 3f;
                        bullet = s;
                    }},
                    new Weapon("2"){{
                        y = -7f;
                        x = 9f;
                        shootY = 7f;
                        reload = 45;
                        shake = 3f;
                        rotateSpeed = 1.5f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.artillery;
                        rotate = true;
                        shadow = 8f;
                        recoil = 3f;
                        bullet = s;
                    }},
            new Weapon("3"){{
                y = -12f;
                x = -13f;
                shootY = 7f;
                reload = 35;
                shake = 6f;
                rotateSpeed = 1.5f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.artillery;
                rotate = true;
                shadow = 8f;
                recoil = 5f;
                bullet = s;
            }},
            new Weapon("3"){{
                y = -12f;
                x = 13f;
                shootY = 7f;
                reload = 35;
                shake = 6f;
                rotateSpeed = 1.5f;
                ejectEffect = Fx.casing1;
                shootSound = Sounds.artillery;
                rotate = true;
                shadow = 8f;
                recoil = 5f;
                bullet = s;
            }}
            );
        }
        };

        xns = new UnitType("x-ns"){{
            constructor = LegsUnit::create;
            speed = 3.3F;
            drag = 0.1F;
            hitSize = 21.0F;
            rotateSpeed = 3.0F;
            health = 2024520;
            armor = 20.0F;
            legCount = 4;
            legLength = 15.0F;
            legGroupSize = 2;
            legExtension = 4.5F;
            legBaseOffset = 7.0F;
            legLengthScl = 0.925F;
            legMoveSpace = 4F;
            hovering = true;
            groundLayer = 74.0F;
            faceTarget = false;

            BulletType b = new SapBulletType(){{
                damage = 2024F;
            }};
            weapons.addAll(
                    new Weapon("2"){{
                        y = -7f;
                        x = -9f;
                        shootY = 7f;
                        reload = 45;
                        shake = 3f;
                        rotateSpeed = 2.5f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.artillery;
                        rotate = true;
                        shadow = 8f;
                        recoil = 3f;
                        bullet = b;
                    }},
                    new Weapon("1"){{
                        y = -7f;
                        x = 9f;
                        shootY = 7f;
                        reload = 45;
                        shake = 3f;
                        rotateSpeed = 2.5f;
                        ejectEffect = Fx.casing1;
                        shootSound = Sounds.artillery;
                        rotate = true;
                        shadow = 8f;
                        recoil = 3f;
                        bullet = b;
                    }}
                );
            }
        };
    }
}
