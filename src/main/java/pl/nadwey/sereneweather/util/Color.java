package pl.nadwey.sereneweather.util;

import net.minecraft.util.FastColor;

public class Color {
    private int r;
    private int g;
    private int b;
    private int a;

    public Color(int r, int g, int b, int a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(int r, int g, int b) {
        this(r, g, b, 1);
    }

    public Color(int argb) {
        this.a = (argb >> 24) & 0xFF;
        this.r = (argb >> 16) & 0xFF;
        this.g = (argb >> 8) & 0xFF;
        this.b = argb & 0xFF;
    }

    public int toARGB() {
        return (a << 24) | (r << 16) | (g << 8) | b;
        // return FastColor.ARGB32.color(a, r, g, b);
    }

    public Color interpolate(Color colorB, float t) {
        int r = (int) ((1 - t) * this.r + t * colorB.getR());
        int g = (int) ((1 - t) * this.g + t * colorB.getG());
        int b = (int) ((1 - t) * this.b + t * colorB.getB());
        int a = (int) ((1 - t) * this.a + t * colorB.getA());

        return new Color(r, g, b, a);
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
