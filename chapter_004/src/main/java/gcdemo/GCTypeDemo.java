package gcdemo;

import java.util.Random;

/**
 * Запуск приложения с различными сборщиками мусора
 * Для начала стоит отметить флаг -Xlog:gc* (до JDK 9 нужно использовать -XX:-PrintGCDetails) если мы его зададим то, сможем увидеть лог сборщика в консоли
 * Ключи для запуска:
 * - Serial => -XX:+UseSerialGC
 * - Parallel => -XX:+UseParallelGC
 * - CMS => -XX:+UseConcMarkSweepGC (доступен до JDK 14)
 * - G1 => -XX:+UseG1GC
 * - ZGC => -XX:+UseZGC
 *
 * Будем запускать такую программу.
 * Она составляет строку из продублированного несколько
 * раз символа, при этом перезаписывая очейки массивы.
 *
 * Старые строки стираются сборщиком мусора
 */
public class GCTypeDemo {
    public static void main(String[] args) {
        Random random = new Random();
        int length = 100;
        String[] data = new String[1_000_000];
        for (int i = 0; ; i = (i + 1) % data.length) {
            data[i] = String.valueOf(
                    (char) random.nextInt(255)
            ).repeat(length);
        }
    }
}
/* Использованные ключи конфигурации
VM Options: -XX:+UseSerialGC  -Xlog:gc*
 */

/* Вывод
...
[0.034s][info][gc,heap,coops] Heap address: 0x0000000600c00000, size: 8180 MB, Compressed Oops mode: Zero based, Oop shift amount: 3
[0.064s][info][gc           ] Using Serial
[0.325s][info][gc,start     ] GC(0) Pause Young (Allocation Failure)
[0.528s][info][gc,heap      ] GC(0) DefNew: 139776K(157248K)->17472K(157248K) Eden: 139776K(139776K)->0K(139776K) From: 0K(17472K)->17472K(17472K)
[0.528s][info][gc,heap      ] GC(0) Tenured: 0K(349568K)->94088K(349568K)
[0.528s][info][gc,metaspace ] GC(0) Metaspace: 720K(4864K)->720K(4864K) NonClass: 655K(4352K)->655K(4352K) Class: 65K(512K)->65K(512K)
[0.528s][info][gc           ] GC(0) Pause Young (Allocation Failure) 136M->108M(494M) 202.707ms
[0.528s][info][gc,cpu       ] GC(0) User=0.14s Sys=0.06s Real=0.20s
[0.578s][info][gc,start     ] GC(1) Pause Young (Allocation Failure)
[0.778s][info][gc,heap      ] GC(1) DefNew: 157248K(157248K)->17472K(157248K) Eden: 139776K(139776K)->0K(139776K) From: 17472K(17472K)->17472K(17472K)
[0.778s][info][gc,heap      ] GC(1) Tenured: 94088K(349568K)->200573K(349568K)
[0.778s][info][gc,metaspace ] GC(1) Metaspace: 720K(4864K)->720K(4864K) NonClass: 655K(4352K)->655K(4352K) Class: 65K(512K)->65K(512K)
[0.778s][info][gc           ] GC(1) Pause Young (Allocation Failure) 245M->212M(494M) 199.932ms
[0.778s][info][gc,cpu       ] GC(1) User=0.16s Sys=0.03s Real=0.20s
[0.824s][info][gc,start     ] GC(2) Pause Young (Allocation Failure)
[1.021s][info][gc,heap      ] GC(2) DefNew: 157248K(157248K)->17472K(157248K) Eden: 139776K(139776K)->0K(139776K) From: 17472K(17472K)->17472K(17472K)
[1.021s][info][gc,heap      ] GC(2) Tenured: 200573K(349568K)->306357K(349568K)
[1.021s][info][gc,metaspace ] GC(2) Metaspace: 720K(4864K)->720K(4864K) NonClass: 655K(4352K)->655K(4352K) Class: 65K(512K)->65K(512K)
[1.021s][info][gc           ] GC(2) Pause Young (Allocation Failure) 349M->316M(494M) 197.002ms
[1.021s][info][gc,cpu       ] GC(2) User=0.20s Sys=0.00s Real=0.20s
[1.070s][info][gc,start     ] GC(3) Pause Young (Allocation Failure)
[1.272s][info][gc           ] GC(3) Pause Young (Allocation Failure) 452M->419M(556M) 202.318ms
[1.272s][info][gc,cpu       ] GC(3) User=0.16s Sys=0.05s Real=0.20s
[1.272s][info][gc,start     ] GC(4) Pause Full (Allocation Failure)
[1.272s][info][gc,phases,start] GC(4) Phase 1: Mark live objects
[1.331s][info][gc,phases      ] GC(4) Phase 1: Mark live objects 58.918ms
[1.331s][info][gc,phases,start] GC(4) Phase 2: Compute new object addresses
[1.442s][info][gc,phases      ] GC(4) Phase 2: Compute new object addresses 110.750ms
[1.442s][info][gc,phases,start] GC(4) Phase 3: Adjust pointers
[1.511s][info][gc,phases      ] GC(4) Phase 3: Adjust pointers 69.165ms
[1.511s][info][gc,phases,start] GC(4) Phase 4: Move objects
[1.572s][info][gc,phases      ] GC(4) Phase 4: Move objects 60.538ms
[1.581s][info][gc,heap        ] GC(4) DefNew: 157248K(157248K)->0K(157376K) Eden: 139776K(139776K)->0K(139904K) From: 17472K(17472K)->0K(17472K)
...
 */