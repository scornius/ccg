package org.nerdizin.ccg.game;

public class ResourcePool {

    private int gold;
    private int lightMana;
    private int darkMana;
    private int earthMana;
    private int fireMana;
    private int waterMana;
    private int airMana;

    public int getGold() {
        return gold;
    }

    public void setGold(final int gold) {
        this.gold = gold;
    }

    public void addGold(final int gold) {
        this.gold += gold;
    }

    public int getLightMana() {
        return lightMana;
    }

    public void setLightMana(final int lightMana) {
        this.lightMana = lightMana;
    }

    public void addLightMana(final int lightMana) {
        this.lightMana += lightMana;
    }

    public int getDarkMana() {
        return darkMana;
    }

    public void setDarkMana(final int darkMana) {
        this.darkMana = darkMana;
    }

    public void addDarkMana(final int darkMana) {
        this.darkMana += darkMana;
    }

    public int getEarthMana() {
        return earthMana;
    }

    public void setEarthMana(final int earthMana) {
        this.earthMana = earthMana;
    }

    public void addEarthMana(final int earthMana) {
        this.earthMana += earthMana;
    }

    public int getFireMana() {
        return fireMana;
    }

    public void setFireMana(final int fireMana) {
        this.fireMana = fireMana;
    }

    public void addFireMana(final int fireMana) {
        this.fireMana += fireMana;
    }

    public int getWaterMana() {
        return waterMana;
    }

    public void setWaterMana(final int waterMana) {
        this.waterMana = waterMana;
    }

    public void addWaterMana(final int waterMana) {
        this.waterMana += waterMana;
    }

    public int getAirMana() {
        return airMana;
    }

    public void setAirMana(final int airMana) {
        this.airMana = airMana;
    }

    public void addAirMana(final int airMana) {
        this.airMana += airMana;
    }

    @Override
    public String toString() {
        return "ResourcePool{" +
                "gold=" + gold +
                ", lightMana=" + lightMana +
                ", darkMana=" + darkMana +
                ", earthMana=" + earthMana +
                ", fireMana=" + fireMana +
                ", waterMana=" + waterMana +
                ", airMana=" + airMana +
                '}';
    }
}
