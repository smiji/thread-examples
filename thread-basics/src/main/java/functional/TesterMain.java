package functional;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class TesterMain {

    public static final List<Sale> prepareTestSaleData() {
        return Arrays.asList(
                new Sale(Store.CHICAGO, new Date(), Optional.of("Smiji"),
                        Arrays.asList(
                                new Item("Carrot", 12.00),
                                new Item("Lizard", 88.00),
                                new Item("cookie", 1.2)
                        )),
                new Sale(Store.KANSAS_CITY, new Date(), Optional.of("Smitha"),
                        Arrays.asList(
                                new Item("Lizard", 78.00)
                        )),
                new Sale(Store.ST_LOUIS, new Date(), Optional.of("John"),
                        Arrays.asList(
                                new Item("Lizard", 78.00),
                                new Item("cookie", 1.2)
                        ))
        );
    }

    public static Stream<Sale> salesStream() {
        return prepareTestSaleData().stream();
    }

    public static void main(String[] args) {

        //printMap();

        System.out.println(prepareTestSaleData());

        Supplier<DoubleStream> totalStream = () -> salesStream().mapToDouble(sale -> sale.total());

        //How many sales count
        System.out.println("Counts:" + prepareTestSaleData().stream().count());
        //Any sales over 100
        System.out.println(totalStream.get().anyMatch(total -> total > 100));
        //Any sales over 100
        System.out.println(totalStream.get().summaryStatistics());

        //How many items were sold today
        Supplier<Stream<Item>> itemsStream = () -> salesStream().flatMap(sale -> sale.items.stream());
        System.out.println(itemsStream.get().count());
        //How many unique identity
        long count = itemsStream.get()
                .map(item -> item.identify)
                .peek(System.out::println)
                .distinct()
                .peek(t -> {
                    System.out.println("<-Filtered items->" + t);
                })
                .count();
        System.out.println(count);

    }


    private static void printMap() {
        Map<String, Integer> numberMap = new HashMap<>();

        for (int i = 0; i < 7; i++) {
            numberMap.put(String.valueOf(i), i);
        }

        numberMap.keySet().stream().forEach(item -> {
            System.out.println(numberMap.get(item));
        });

    }
}
