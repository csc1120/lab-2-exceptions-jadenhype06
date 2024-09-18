/*
 * Course: CSC1020
 * Lab 2 - Exceptions
 * DieNotRolledException class
 * Name: Jaden Hipe
 * Last Updated: 9/16/2024
 */
package hipej;

public class DieNotRolledException extends RuntimeException  {
    public DieNotRolledException() {
        super();
    }
    public String getMessage() {
        return "Not In Range";
    }

}
