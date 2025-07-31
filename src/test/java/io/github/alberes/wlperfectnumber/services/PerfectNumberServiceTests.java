package io.github.alberes.wlperfectnumber.services;

import io.github.alberes.wlperfectnumber.constants.Constants;
import io.github.alberes.wlperfectnumber.services.exceptions.PerfectNumberException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PerfectNumberServiceTests {

    @Autowired
    private PerfectNumberService service;

    @Test
    public void test_perfectNumber(){
        List<Integer> perfectNumbers = this.service.perfectNumber(1, 1);
        Assertions.assertTrue(perfectNumbers.isEmpty());

        perfectNumbers = this.service.perfectNumber(1, 6);
        Assertions.assertTrue(perfectNumbers.size() == 1);

        perfectNumbers = this.service.perfectNumber(6, 6);
        Assertions.assertTrue(perfectNumbers.size() == 1);

        perfectNumbers = this.service.perfectNumber(28, 30);
        Assertions.assertTrue(perfectNumbers.size() == 1);

        perfectNumbers = this.service.perfectNumber(6, 30);
        Assertions.assertTrue(perfectNumbers.size() == 2);

        perfectNumbers = this.service.perfectNumber(1, 10000);
        Assertions.assertTrue(perfectNumbers.size() == 4);
    }

    @Test
    public void test_perfectNumberException(){
        PerfectNumberException pnex = Assertions
                .assertThrows(PerfectNumberException.class, ()-> {
                    this.service.perfectNumber(0, 10);
                });
        Assertions.assertTrue(Constants.RANGE_EXCEPTION_MIN_MAX_MESSAGE.equals(pnex.getMessage()));
        System.out.println(pnex.getMessage());
        pnex = Assertions
                .assertThrows(PerfectNumberException.class, ()-> {
                    this.service.perfectNumber(10, 0);
                });
        Assertions.assertTrue(Constants.RANGE_EXCEPTION_MIN_MAX_MESSAGE.equals(pnex.getMessage()));
        System.out.println(pnex.getMessage());
        pnex = Assertions
                .assertThrows(PerfectNumberException.class, ()-> {
                    this.service.perfectNumber(10, 5);
                });
        Assertions.assertTrue(Constants.RANGE_EXCEPTION_MESSAGE.equals(pnex.getMessage()));
        System.out.println(pnex.getMessage());
    }

}
