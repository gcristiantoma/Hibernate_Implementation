import javax.persistence.*;
import org.hibernate.*;

import java.util.Objects;

@Entity(name = "Cars")
@Table(name="cars") // the table name from sql
public class Cars {
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "model")
    private String model;

    @Column(name = "engine")
    private double engine;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getEngine() {
        return engine;
    }

    public void setEngine(double engine) {
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Cars{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", engine=" + engine +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cars)) return false;
        Cars cars = (Cars) o;
        return getId() == cars.getId() &&
                Double.compare(cars.getEngine(), getEngine()) == 0 &&
                getModel().equals(cars.getModel());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getModel(), getEngine());
    }
}
