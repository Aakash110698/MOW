package com.snackhoop.mealsonwheels.library;

/**
 * Created by guru on 7/31/2017
 */

public class LayoutCannotResolve extends Exception {

    private String className;
    private String message;

    public LayoutCannotResolve(String className, String message) {
        super(message);
        this.className = className;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public String toString() {
        return "Layout not found: "+className+"\n"+message;
    }

    @Override
    public synchronized Throwable getCause() {
        return new Throwable("The given layout is not found to mount!. In "+className+". "+message);
    }
}
