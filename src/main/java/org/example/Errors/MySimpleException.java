package org.example.Errors;
public class MySimpleException extends RuntimeException{
    private int i;
    private int j;
    private String s;

    public MySimpleException(int i, int j, String s){
        super("Найден элемент, соответствующий условию задания: "+ s + "Номер ячейки: " + (i+1)+" x " + (j+1));
        this.i=i;
        this.j=j;
        this.s=s;
    }
}

