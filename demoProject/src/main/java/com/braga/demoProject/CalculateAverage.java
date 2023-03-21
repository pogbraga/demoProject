package com.braga.demoProject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.math.BigDecimal;

@RestController
public class CalculateAverage {
    @GetMapping("/average")
    public BigDecimal average (@RequestParam int[] numbers){

        int sum = 0;
        int total = 0;
        BigDecimal average = new BigDecimal(0);

        while (sum < numbers.length){
            total = numbers[sum] + total;
            sum++;
        }
        return average = BigDecimal.valueOf( total / sum );
    }
}
