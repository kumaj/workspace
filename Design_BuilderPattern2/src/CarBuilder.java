/**
 * Interface to build all types of car here
 * @author kumaj04
 *
 */
public interface CarBuilder {
	CarBuilder setWheels(int wheels);
	CarBuilder setColour(String colour);
	Car build();
}
