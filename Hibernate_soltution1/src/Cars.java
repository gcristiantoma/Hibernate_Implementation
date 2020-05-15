import javax.persistence.*;
import org.hibernate.*;

@Entity
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
}
