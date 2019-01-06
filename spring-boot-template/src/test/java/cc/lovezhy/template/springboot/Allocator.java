package cc.lovezhy.template.springboot;


import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Allocator {

    private static Logger LOG = LoggerFactory.getLogger(Allocator.class);
    @Test
    public void allocateRandomTest() {
        for (int i = 0; i < 10000; i++) {
            List<BigDecimal> res = allocateRandom(BigDecimal.valueOf(200), 800, BigDecimal.valueOf(0.1));
            LOG.info("{}", res.stream().distinct().collect(Collectors.toList()).size());
            BigDecimal total = BigDecimal.valueOf(0);
            for (BigDecimal item : res) {
                total = total.add(item);
            }
            Assert.assertEquals(800, res.size());
            Assert.assertEquals(0, BigDecimal.valueOf(200).compareTo(total));
            res.forEach(item -> {
                Assert.assertTrue(item.compareTo(BigDecimal.valueOf(0.1)) >= 0);
            });
        }
    }

    //把total随机分给num个，设置最小值
    public static List<BigDecimal> allocateRandom(BigDecimal total, int num, BigDecimal min) {
        List<BigDecimal> res = Lists.newArrayList();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            res.add(min);
        }
        total = total.subtract(min.multiply(BigDecimal.valueOf(num)));
        int n = num - 1;
        while (n >= 1) {
            BigDecimal max = total.divide(BigDecimal.valueOf(n + 1), 3, RoundingMode.FLOOR).multiply(BigDecimal.valueOf(2));
            BigDecimal money = BigDecimal.valueOf(random.nextDouble()).multiply(max);
            money = money.multiply(BigDecimal.valueOf(100)).divide(BigDecimal.valueOf(100), 2, RoundingMode.FLOOR);
            total = total.subtract(money);
            res.set(n, min.add(money));
            n--;
        }
        res.set(0, min.add(total));
        return res;
    }
}
