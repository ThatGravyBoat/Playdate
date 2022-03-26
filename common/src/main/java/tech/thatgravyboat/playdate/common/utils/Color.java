package tech.thatgravyboat.playdate.common.utils;

import net.minecraft.util.math.ColorHelper;

import java.util.Timer;
import java.util.TimerTask;

public class Color {

    public static final Color RAINBOW = new Color(0xffff0000);

    static {
        initRainbow();
    }

    private int value;

    public Color(int value) {
        this.value = value;
    }

    public Color(int r, int g, int b, int a) {
        this.value = ColorHelper.Argb.getArgb(a, r, g, b);
    }

    public Color(float r, float g, float b, float a) {
        this.value = ColorHelper.Argb.getArgb((int)(a*255f), (int)(r*255f), (int)(g*255f), (int)(b*255f));
    }

    public int getRGBA() {
        return value;
    }

    public int getRed() {
        return ColorHelper.Argb.getRed(value);
    }

    public int getGreen() {
        return ColorHelper.Argb.getGreen(value);
    }

    public int getBlue() {
        return ColorHelper.Argb.getBlue(value);
    }

    public int getAlpha() {
        return ColorHelper.Argb.getAlpha(value);
    }

    public static void initRainbow() { new Timer().scheduleAtFixedRate(new ColorChange(), 0, 40); }

    private static class ColorChange extends TimerTask {
        @Override
        public void run() {
            int r = RAINBOW.getRed();
            int g = RAINBOW.getGreen();
            int b = RAINBOW.getBlue();
            if(r > 0 && b == 0){
                r--;
                g++;
            }
            if(g > 0 && r == 0){
                g--;
                b++;
            }
            if(b > 0 && g == 0){
                r++;
                b--;
            }
            RAINBOW.value = ColorHelper.Argb.getArgb(255, r, g, b);
        }
    }
}
