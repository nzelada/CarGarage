package NickZelada;

import java.util.*;

/**
 * This is the Car class, in which would make the car.
 *
 * @author Nick Zelada
 * @version September 19, 2018
 */


public class Car {

    private String plateNum; // plate number
    private int numOfMove; // number of moves

    
    /**
     * Car constructor that would get the plate number and number of moves.
     *
     * @param plateNum 
     */
    public Car(String plateNum) {
        this.plateNum = plateNum;
        this.numOfMove = 0;

    }
/**
 * This method get the strings of plate number.
 * @return the plate number
 */
    public String getPlateNum() {

        return plateNum;

    }
/**
 * This method moves the car.
 */
    public void moveCar() {

        this.numOfMove++;
    }
/**
 * This method gets the number of moves that the car did.
 * @return the number of moves 
 */
    public int getNumOfMove() {

        return this.numOfMove;

    }

}
