package deserialize;

import com.google.gson.*;
import models.Arrays.VehiclesMap;
import models.Vehicle;

import java.lang.reflect.Type;

/**
 * Created by rootid on 24.02.2017.
 */
public class VehiclesDeserializer implements JsonDeserializer<VehiclesMap> {
    public VehiclesMap deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context){
        VehiclesMap vehiclesMap = new VehiclesMap();
        JsonObject jsonObject = json.getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("results");

        for (int i = 0; i < jsonArray.size(); i++) {
            Vehicle vehicle = context.deserialize(jsonArray.get(i), Vehicle.class);
            String url = vehicle.getUrl();
            vehiclesMap.addVehicles(url, vehicle);
        }
        return vehiclesMap;
    }
}
