package test_classes;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties (ignoreUnknown = true) //игнорирование неопознанных полей в json на уровне класса
public class Car {
    private String color;

    //@JsonProperty (value = "model") //Изменение названия поля класса
    private String type;

    @JsonIgnore //Не нужно отправлять на сервер -> Поле не попадет в сериализованную json-строку.
    private boolean isActive;

    public Car() {
    }

    @JsonCreator
    public Car(@JsonProperty("color") String color, @JsonProperty("model") String type) {
        this.color = color;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "test_classes.Car{" +
                "color='" + color + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
