package modernwarfare.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class MWItems {
    public static Item tie,gangban,zidanjuhenengyuan,paodannengyuan,tanfen,shiying,shiyingsha,lingsuangan,bailing,mei,lei,ying,guitie,leigong,
            chaonengti1xing,chaonengti2xing,chaonengti3xing,
    canHai,wuliuxiansuo,shingyinghej;
    public static void load(){
        tie = new Item("tie", Color.valueOf("light gray")){{
            cost = 1;
        }};

        gangban = new Item("gang-ban", Color.valueOf("dark green")){{
            cost = 1;
        }};

        zidanjuhenengyuan = new Item("zi-dan-ju-he-neng-yuan", Color.valueOf("669933")){{
            cost = 1;
        }};

        paodannengyuan = new Item("pao-dan-neng-yuan", Color.valueOf("FFFFFF")){{
            cost = 1;
        }};

        tanfen = new Item("tan-fen", Color.valueOf("7B7B7BFF")){{
            cost = 1;
        }};

        shiying = new Item("shi-ying", Color.valueOf("ffffff")){{
            cost = 1;
        }};

        shiyingsha = new Item("shi-ying-sha", Color.valueOf("DADADAFF")){{
            cost = 1;
        }};

         lingsuangan = new Item("ling-suan-gai", Color.valueOf("00FFC8FF")){{
            cost = 1;
        }};

        bailing = new Item("bai-ling", Color.valueOf("40B3CDFF")){{
            cost = 1;
            flammability = 200;
        }};

        mei = new Item("mei", Color.valueOf("A1C0D6FF")){{
            cost = 1;
            hardness = 3;
        }};

        lei = new Item("lei", Color.valueOf("57E961FF")){{
            cost = (float) 0.6;
            hardness = 2;
            radioactivity = 300;
        }};

        ying = new Item("ying", Color.valueOf("D0D0D0FF")){{
            cost = 1;
            hardness = 1;
        }};

        guitie = new Item("gui-tie", Color.valueOf("3D3D3DFF")){{
            cost = 1;
            hardness = 2;
        }};

        leigong = new Item("lei-gong", Color.valueOf("E8E67DFF")){{
            cost = (float) 0.6;
            explosiveness = 100;
            flammability = 100;
        }};

        chaonengti1xing = new Item("chao-neng-ti-1-xing", Color.valueOf("E6A432FF")){{
            cost = (float) 0.6;
            explosiveness = 20;
            hardness = 1;
        }};

        chaonengti2xing = new Item("chao-neng-ti-2-xing", Color.valueOf("FF8132FF")){{
            explosiveness = 60;
            flammability = 5;
            hardness = 1;
            cost = (float) 0.6;
        }};

        chaonengti3xing = new Item("chao-neng-ti-3-xing", Color.valueOf("FF4233FF")){{
            explosiveness = 80;
            flammability = 10;
            hardness = 1;
            cost = (float) 0.6;
        }};

        canHai = new Item("can-Hai", Color.valueOf("f5f5f5")){{
            hardness = 1;
            cost = (float) 0.6;
        }};
        wuliuxiansuo = new Item("wu-liu-xian-suo", Color.valueOf("f5f5f5")){{
            hardness = 1;
            cost = (float) 0.6;
        }};

        shingyinghej = new Item("shiying-heji", Color.valueOf("add8e6")){{
            hardness = 1;
            cost = (float) 0.6;
        }};
    }
}