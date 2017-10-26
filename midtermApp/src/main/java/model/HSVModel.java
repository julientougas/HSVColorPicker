package model;

import java.util.Observable;


/**
 * The model holds the data.
 *
 * @author Julien Tougas toug0008
 * @version 1.0
 */
public class HSVModel extends Observable {

    // CLASS VARIABLES
    public static final Float MAX_HUE = 359f;
    public static final Float MIN_HUE = 0f;
    public static final Float MAX_SAT = 1f;
    public static final Float MIN_SAT = 0f;
    public static final Float MAX_BRIGHT = 1f;
    public static final Float MIN_BRIGHT = 0f;

    // INSTANCE VARIABLES
    private Float hue;
    private Float sat;
    private Float bright;

    /**
     * No argument constructor.
     * <p>
     * Instantiate a new instance of this class, and
     * initialize red, green, blue, and alpha to max values.
     */
    public HSVModel() {

        this(MAX_HUE, MAX_SAT, MAX_BRIGHT);
    }

    /**
     * Convenience constructor.
     */
    public HSVModel(Float hue, Float sat, Float bright) {
        super();

        this.hue = hue;
        this.sat = sat;
        this.bright = bright;
    }

    public void asBlack() {
        this.setHSV(0.0f, 0.0f, 0.0f);
    }

    public void asRed() {
        this.setHSV(0.0f, 1.0f, 1.0f);
    }

    public void asLime() {
        this.setHSV(120.0f, 1.0f, 1.0f);
    }

    public void asBlue() {
        this.setHSV(240.0f, 1.0f, 1.0f);
    }

    public void asYellow() {
        this.setHSV(60.0f, 1.0f, 1.0f);
    }

    public void asCyan() {
        this.setHSV(180.0f, 1.0f, 1.0f);
    }

    public void asMagenta() {
        this.setHSV(300.0f, 1.0f, 1.0f);
    }

    public void asSilver() {
        this.setHSV(0.0f, 0.0f, 0.75f);
    }

    public void asGray() {
        this.setHSV(0.0f, 0.0f, 0.5f);
    }

    public void asMaroon() {
        this.setHSV(0.0f, 1.0f, 0.5f);
    }

    public void asOlive() {
        this.setHSV(60.0f, 1.0f, 0.5f);
    }

    public void asGreen() {
        this.setHSV(120.0f, 1.0f, 0.5f);
    }

    public void asPurple() {
        this.setHSV(300.0f, 1.0f, 0.5f);
    }

    public void asTeal() {
        this.setHSV(180.0f, 1.0f, 0.5f);
    }

    public void asNavy() {
        this.setHSV(240.0f, 1.0f, 0.5f);
    }

    // GETTERS
    public Float getHue() {
        return hue;
    }

    public Float getSat() {
        return sat;
    }

    public Float getBright() {
        return bright;
    }

    // SETTERS

    public void setHue(Float hue) {
        this.hue = hue;

        this.updateObservers();
    }

    public void setSat(Float sat) {
        this.sat = sat;

        this.updateObservers();
    }

    public void setBright(Float bright) {
        this.bright = bright;

        this.updateObservers();
    }

    // Convenient setter: set Hue, Sat, Bright
    public void setHSV(Float hue, Float sat, Float bright) {
        this.hue = hue;
        this.sat = sat;
        this.bright = bright;
        this.updateObservers();
    }

    // the model has changed!
    // broadcast the update method to all registered observers
    private void updateObservers() {
        this.setChanged();
        this.notifyObservers();
    }

}