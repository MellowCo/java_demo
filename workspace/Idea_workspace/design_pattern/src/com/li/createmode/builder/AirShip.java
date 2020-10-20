package com.li.createmode.builder;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-08 15:55
 */
public class AirShip {

    private Engine engine;
    private MainBody body;

    public AirShip(Engine engine, MainBody body) {
        this.engine = engine;
        this.body = body;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public MainBody getBody() {
        return body;
    }

    public void setBody(MainBody body) {
        this.body = body;
    }
}
