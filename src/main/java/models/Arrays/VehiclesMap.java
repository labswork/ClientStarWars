package models.Arrays;

import models.Vehicle;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by rootid on 24.02.2017.
 */
public class VehiclesMap {
    private Map<String, Vehicle> vehicleMap = new HashMap<String, Vehicle>();

    public Map<String, Vehicle> getVehicleMap() {
        return vehicleMap;
    }
    public void addVehicles(String url, Vehicle vehicle){
        vehicleMap.put(url, vehicle);
    }
    public Vehicle getVehicle(String url){
        return vehicleMap.get(url);
    }
    public void addAllVehicles(VehiclesMap vehiclesMap){
        this.vehicleMap.putAll(vehiclesMap.getVehicleMap());
    }
}
