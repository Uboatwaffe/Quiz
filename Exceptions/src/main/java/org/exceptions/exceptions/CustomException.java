package org.exceptions.exceptions;

import org.exceptions.file.ERRORS;

/**
 * Class that is just custom exception, used in:
 * <ul>
 *     <li>
 *         {@code StringOperations}
 *     </li>
 * </ul>
 * @author Maciej
 * @version 0.1
 */
public class CustomException extends Exception{
    /**
     * Field that contains message
     */
    private final String message;

    /**
     * Constructor
     * @param ob Name of the class
     * @param message Message passed while throwing this exception
     */
    public CustomException(Class<?> ob,String message){
        this.message = message;
        ERRORS errors = new ERRORS();
        errors.writeLog(ob, message);
    }

    /**
     * Method
     * @return String with given message
     */
    @Override
    public String getMessage() {
        return message;
    }
}
