package test_classes;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper()
                //указание поведения при обнаружении неизвестных полей
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        Car car = new Car("blue", "BMW");
//        objectMapper.writeValue(new File("car.json"), car);
//        String jsonString = objectMapper.writeValueAsString(car);
//        byte[] jsonBytes = objectMapper.writeValueAsBytes(car);

//        test_classes.Car carFromFile = objectMapper.readValue(new File("car.json"), test_classes.Car.class);
//        System.out.println(carFromFile.toString());
        String carsList = "[{\"color\":\"red\", \"type\":\"BMW\"}," +
                " {\"color\":\"black\", \"type\":\"LADA\"}]";
        List<Car> carList = objectMapper.readValue(carsList, new TypeReference<List<Car>>() {
        });
        //System.out.println(carList);
        //System.out.println(carList.get(0));

        String jsonString = "{ \"color\" : \"white\", \"type\" : \"Volga\", \"year\" :\"1970\" }";
        Car car1 = objectMapper.readValue(jsonString, Car.class);
        System.out.println(car1);

        JsonNode colorCar = objectMapper
                .readTree(jsonString)
                .at("/color");
        System.out.println(colorCar.asText());
    }
}