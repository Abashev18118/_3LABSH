package org.example.Errors;

public class MainApp2 {
    static double sum = 0;

    public static void main(String[] args) {
        String[][] array = {
                {"198", "232", "136", "346"},
                {"322", "222", "190", "244"},
                {"134", "322", "334", "323"},
                {"458", "242", "124", "104"}
        };
        try {
            if (array.length != 4) {
                throw new MyArraySizeException("Размер массива задан не верно");
            }
            for (String[] row : array) {
                if (row.length != 4) {
                    throw new MyArraySizeException("Размер массива задан не верно");
                }
            }

            if (check(array)) {
                System.out.println("Результат: " + sum);
            }
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } catch (MySimpleException e) {
            e.printStackTrace();
        }
    }

    public static boolean isPrime(double number) {
        if (number <= 1 || number != Math.floor(number)) {
            return false; // 1, нецелые и отрицательные числа не считаются простыми
        }
        if (number <= 3) {
            return true; // 2 и 3 - простые числа
        }
        if (number % 2 == 0 || number % 3 == 0) {
            return false; // Если число делится на 2 или 3 без остатка, то оно не простое
        }
        // Проверяем делители, начиная с 5
        for (double i = 5; i * i <= number; i += 6) {
            if (number % i == 0 || number % (i + 2) == 0) {
                return false;
            }
        }
        return true; // Если не найдены делители, то число простое
    }

    static double doubleValue;

    public static boolean check(String[][] array) throws MyArrayDataException, MySimpleException {
        boolean tmp = true;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Double.parseDouble(array[i][j]);
                } catch (NumberFormatException e) {
                    tmp = false;
                    throw new MyArrayDataException(i, j, array[i][j]);
                }
                try {
                    doubleValue = Double.parseDouble(array[i][j]);
                    if (doubleValue % 1 == 0 && doubleValue > 100 && doubleValue < 500 && isPrime(doubleValue)) {
                        throw new MySimpleException(i, j, array[i][j]);
                    }
                } catch (MySimpleException e) {
                    e.printStackTrace();
                }
            }
        }
        return tmp;
    }

}
//Идея: сделать счетчик, который сможет вызывать в конце
// всех посчетов столько ошибок, сколько элементов не соответствуют условию.