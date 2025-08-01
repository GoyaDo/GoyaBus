package com.ysmjjsy.goya.bus.exception;

/**
 * <p></p>
 *
 * @author goya
 * @since 2025/6/29 00:31
 */
public class BusException extends RuntimeException{

    public BusException() {
        super();
    }

    public BusException(String message) {
        super(message);
    }

    public BusException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusException(Throwable cause) {
        super(cause);
    }

    protected BusException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
