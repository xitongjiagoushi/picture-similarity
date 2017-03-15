package com.brctl.vo;

/**
 * Created by Duan Xiaoxing on 2017-03-07.
 */
public enum ResponseStatus {

    OK(200), ERR(500);

    private final int value;

    private ResponseStatus(int value) {
        this.value = value;
    }

}
