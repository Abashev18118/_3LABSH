package org.example.Errors;
public class MyArrayDataException extends RuntimeException{
    private int j;
    private int i;
    private Object s;
    public MyArrayDataException(int i, int j, String s){
        super("Проблема с данными в " + (i+1) + " Столбце "+ (j+1) + " Строке , Элемент '" +s + "' ");
        this.i = i;
        this.j = j;
        this.s = s;
    }
}
