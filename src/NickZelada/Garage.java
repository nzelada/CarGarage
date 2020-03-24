package NickZelada;

import java.util.*;

/**
 * This is the Garage class, in which would store the cars and see if there is
 * spaces when arrived. When departed it would get the number of spaces moved.
 *
 * @author Nick Zelada
 * @version September 19, 2018
 */
public class Garage {

    final int CAR_SPACES = 10; // number of car spaces
    private Car[] cars; // arrays of cars
    private int carsParked; // number of cars parked

    /**
     * This constructor consist of the number of cars parked and the new car
     * array with 10 spaces.
     */
    public Garage() {
        this.cars = new Car[CAR_SPACES];
        this.carsParked = 0;

    }

    /**
     * This method would return the number of cars parked.
     *
     * @return the number of cars parked.
     */
    public int getCarsParked() {
        return carsParked;
    }

    /**
     * This method would store the car in the parked car array.
     *
     * @param car
     */
    public void parkCar(Car car) {

        this.cars[getCarsParked()] = car;

        this.carsParked++;

    }

    /**
     * This method would see if there is any spaces available in the garage.If
     * there isn't any then it would say it's full. If there is spaces then it
     * would park the car.
     *
     * @param car
     * @return a string with the plate number along side with the corresponding
     * message.
     *
     */
    public String arrive(Car car) {

        String arrive = "";
        if (getCarsParked() >= this.cars.length) {
            arrive = car.getPlateNum() + " The lot is full and car is turned away.";
        } else if (getCarsParked() < this.cars.length) {
            parkCar(car);
            arrive = car.getPlateNum() + " is parked";
        }
        return arrive;
    }

    /**
     * This method would see if the corresponding plate number is in the garage.
     * If the plate number is there then it would return as departed with the
     * number of moves. If the car isn't there then it would say not in the
     * garage.
     *
     * @param car
     * @return a string with the plate number along side with the corresponding
     */
    public String depart(Car car) {

        String departMessage = "";
        int numOfMove = 0;              // Defining numOfMove for dislay message.
        Boolean carDeparted = false;    // Defining carDeparted boolean variable to check later if car exists in Garrage or not

        for (int i = 0; i < this.cars.length; i++) {
            //Comparing car plate numbers instead of objects
            if (this.cars[i] != null && this.cars[i].getPlateNum().equals(car.getPlateNum())) {
                //Increasing move count for cars till i location
                for (int k = i; k > 0 && i != 0; k--) {
                    this.cars[k - 1].moveCar();
                }

                //stroing number of moves of current car to display in departMessage
                numOfMove = this.cars[i].getNumOfMove();
                this.cars[i] = null;
                //Moving further cars by 1 step ahead
                for (int j = i + 1; j < this.cars.length; j++) {
                    if (this.cars[j] != null) {
                        this.cars[j - 1] = this.cars[j];
                        this.cars[j] = null;
                    }
                }
                //Assinging carDeparted to true as car has been moved out
                carDeparted = true;
                this.carsParked--;
            }

            //checking if car is moved, if not then changing depart message to car does not exist
            if (carDeparted == true) {
                departMessage = car.getPlateNum() + " just left. "
                        + "It has been moved " + numOfMove + " times.";
            } else {
                departMessage = car.getPlateNum() + " is not in Garage.";
            }

        }
        return departMessage;
    }

}
