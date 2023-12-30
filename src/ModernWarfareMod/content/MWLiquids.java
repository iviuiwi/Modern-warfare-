package ModernWarfareMod.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

import static mindustry.content.StatusEffects.burning;
import static mindustry.content.StatusEffects.freezing;

public class MWLiquids {

    //Load Mod Liquids

    public static Liquid
            fusheye,xiaosuan,danqi,yedan,jiujing,anqi,yangqi,qingqi,gong,tianranqi;

    public static void load() {

        fusheye = new Liquid("fu-she-ye",Color.valueOf("2CA92EFF")) {{
            flammability = (float) 0.2;
            temperature = (float) 0.9;
            heatCapacity = (float) 0.00001;
            viscosity = (float) 0.9;
        }};

        xiaosuan = new Liquid("xiao-suan", Color.valueOf("EAE5A2FF")) {{
            flammability = (float) 0.555555; 
            temperature= 3.5F; 
            heatCapacity= 63.5F; 
            effect = burning;
        }};

        danqi = new Liquid("dan-qi", Color.valueOf("E5E5E5FF"));


        yedan = new Liquid("ye-dan", Color.valueOf("F0FFFF")) {{
            effect=burning ;
            flammability= (float) 0.9; 
            temperature= (float) 0.9; 
            heatCapacity= 0.5F; 
            viscosity= (float) 0.3; 
            explosiveness= 0.5F; 
        }};

        jiujing = new Liquid("jiu-jing",Color.valueOf("C35123FF")) {{
            effect=freezing;
            heatCapacity= 3.5F; 
            viscosity= (float) 0.1; 
        }};

        anqi = new Liquid("an-qi",Color.valueOf("7984D7FF")) {{
            temperature= (float) -12.6; 
            heatCapacity= (float) -33.6; 
        }};

        yangqi = new Liquid("yang-qi",Color.valueOf("47A9E1FF")) {{
            flammability= (float) 0.3; 
            temperature= (float) 0.6; 
            heatCapacity= (float) 0.01; 
        }};

        qingqi = new Liquid("qing-qi",Color.valueOf("7AB5B8FF")) {{
            flammability= (float) 3.3; 
            temperature= (float) 0.1; 
            heatCapacity= (float) 10.6; 
        }};

        gong = new Liquid("gong",Color.valueOf("C6C6C6FF")) {{
            temperature= (float) 0.2; 
            heatCapacity= (float) 0.9; 
            viscosity= (float) 0.1; 
        }};

        tianranqi = new Liquid("tian-ran-qi",Color.valueOf("A1EEF2FF")) {{
            flammability= (float) 12.3; 
            temperature= (float) 12.6; 
            heatCapacity= (float) 33.6; 
        }};
    }
}