package io.github.alberes.wlperfectnumber.services;

import io.github.alberes.wlperfectnumber.constants.Constants;
import io.github.alberes.wlperfectnumber.controllers.exceptions.dto.FieldErrorDto;
import io.github.alberes.wlperfectnumber.services.exceptions.PerfectNumberException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PerfectNumberService {

    private boolean isPerfectNumber(int number){
        long sum = 0L;
        for(int n = 1; n < number; n++){
            if(number % n == 0){
                sum += n;
            }
        }
        return sum == number;
    }

    /*
    In number theory, a perfect number is a positive integer that is equal to the sum of its positive proper divisors,
    that is, divisors excluding the number itself.[1] For instance, 6 has proper divisors 1, 2 and 3, and 1 + 2 + 3 = 6,
    so 6 is a perfect number. The next perfect number is 28, since 1 + 2 + 4 + 7 + 14 = 28.
     */
    public List<Integer> perfectNumber(Integer start, Integer end){

        if(start <= 0){
            throw new PerfectNumberException(Constants.RANGE_EXCEPTION_MIN_MAX_MESSAGE, List.of(
                    new FieldErrorDto(Constants.START, Constants.VALUE + start)));
        }
        if(end <= 0){
            throw new PerfectNumberException(Constants.RANGE_EXCEPTION_MIN_MAX_MESSAGE, List.of(
                    new FieldErrorDto(Constants.END, Constants.VALUE + end)));
        }
        if(start > end){
            throw new PerfectNumberException(Constants.RANGE_EXCEPTION_MESSAGE, List.of(
                    new FieldErrorDto(Constants.START, Constants.VALUE + start),
                    new FieldErrorDto(Constants.END, Constants.VALUE + end)));
        }

        List<Integer> perfectNumbers = new ArrayList<Integer>();
        for(int index = start; index <= end; index++){
            if(this.isPerfectNumber(index)){
                perfectNumbers.add(index);
            }
        }
        return perfectNumbers;
    }
}
