package com.metro.test.ui;

public enum ResizeDirection {
	S(11), SE(15), E(12), NE(14), N(10), NW(17), W(13), SW(16), None(0);
	
	 int cursor;
 
    private ResizeDirection(int direction) {
        this.cursor = direction;
    }
}
