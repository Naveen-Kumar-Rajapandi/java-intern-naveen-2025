package com.expensemanager.smartexpenseapplication.aspect;


import com.expensemanager.smartexpenseapplication.annotation.TrackTime;
import lombok.extern.java.Log;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class TrackTimeAspect {

    private static final Logger logger = LoggerFactory.getLogger(TrackTimeAspect.class);

    @Around("@annotation(com.expensemanager.smartexpenseapplication.annotation.TrackTime)")
    public Object measureTime(ProceedingJoinPoint joinPoint) throws Throwable{
        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();  // Executing the Specific method

        long stop = System.currentTimeMillis();
        long timetaken = stop - start;

        logger.info( "Method {} executed in {} ms ",
                joinPoint.getSignature().toShortString(),  // Logging the specific method name and its time taken
                timetaken
        );
        return result;
    }
}
