import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Main {
    public static void main(String[] args) {
/*        Задание 1
        Напишите метод findMinMax, находящий в стриме минимальный и максимальный элементы в соответствии порядком, заданным Comparator'ом.
        Данный метод принимает на вход 3 элемента:
        Stream<? extends T> stream, Comparator<? super T> order,  BiConsumer<? super T, ? super T> minMaxConsumer
        Найденные минимальный и максимальный элементы передайте в minMaxConsumer следующим образом:
        minMaxConsumer.accept(min, max);
        Если стрим не содержит элементов, то вызовите:
        minMaxConsumer.accept(null, null);
 */
        var myArrayStream = new ArrayList<>(Arrays.asList( 2, 32, 25,5, 65, 89 ) );
        BiConsumer<Integer,Integer> myBi = (min,max) -> System.out.println( "min " + min + " max " + max);
        Comparator<Integer> myComp = (x,y) -> x.compareTo(y);

        findMinMax( myArrayStream.stream(), myComp, myBi);



        // Задание 2
        var intList = new ArrayList<>( Arrays.asList(5,7,9,8,6,2,4,3));
        printEven(intList);

    }
    public static <T> void findMinMax( Stream<? extends T> stream,
                                       Comparator<? super T> order,
                                       BiConsumer<? super T, ? super T> minMaxConsumer) {

        List<T> arrayList;
        T min = null, max = null;

        arrayList = stream.sorted(order).collect(Collectors.toList());
        if (arrayList.size() != 0) {
            min = arrayList.get(0);
            max = arrayList.get(arrayList.size() - 1);
        }
        minMaxConsumer.accept(min, max);
    }

    // Задание 2
    // Реализуйте метод, который принимает на вход список целых чисел и определяет количество четных
    // и выводит их в консоль. Решать именно с применением Stream API.

    public static void printEven (List<Integer> numbers){

        Predicate<Integer> isEven = num -> num % 2 == 0;
        System.out.println(" четных чисел : " + numbers.stream().filter(isEven).count());

        numbers.stream().filter(n-> n%2 == 0).forEach(x -> System.out.println(x));
    }
}