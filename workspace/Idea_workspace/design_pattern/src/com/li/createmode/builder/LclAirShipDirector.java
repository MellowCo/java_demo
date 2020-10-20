package com.li.createmode.builder;

/**
 * @Description:
 * @Author: li
 * @Create: 2020-01-08 16:13
 */
public class LclAirShipDirector implements AirShipDirector{
    private AirShipBuilder builder;

    public LclAirShipDirector(AirShipBuilder builder) {
        this.builder = builder;
    }

    @Override
    public AirShip createAirShip() {
        Engine engine = builder.createEngine();
        MainBody mainBody = builder.createMainBody();

        AirShip ship = new AirShip(engine, mainBody);

        return ship;
    }
}
