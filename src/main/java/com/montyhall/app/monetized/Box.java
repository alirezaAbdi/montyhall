package com.montyhall.app.monetized;

class Box {

    private boolean isFull = false;
    private boolean isChosen = false;

    void setIsChosen(boolean isChosen) { this.isChosen = isChosen; }

    void setIsFull(boolean isFull) { this.isFull = isFull; }

    boolean isChosen() { return isChosen; }

    boolean isFull() { return isFull; }

}
