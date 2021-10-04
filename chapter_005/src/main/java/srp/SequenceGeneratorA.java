package srp;
/*
Первый неудачный пример реализации интерфейса
 */


/*
public class SequenceGeneratorA implements SequenceGenerator {

    @Override
    public List<Integer> generate(int size) {
        Random random = new Random();
        return IntStream.range(0, size)
                .map(i -> random.nextInt()).boxed()
                .collect(Collectors.toList());
    }

    @Override
    public void print(List<Integer> numbers) {
        numbers.forEach(System.out::println);
    }
}
 */