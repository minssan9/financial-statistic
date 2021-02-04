package com.voyagerss.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;


@Component
@Aspect
@Order(Ordered.LOWEST_PRECEDENCE)
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);

//    @Pointcut("within(com.mk.charger.station.*)")
//    private void pointcutMethod() {
//    }

    //    @Around("@annotation(LogExecutionTime)")
//    @Around("pointcutMethod()")
    @Around("execution(* com.mk.charger.station.Controller.*(..))")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String signatureStr = joinPoint.getSignature().toShortString();
        System.out.println(signatureStr + "시작"); //메서드 실행
        System.out.println("시간 체크 시작 " + System.currentTimeMillis());

        Object proceed = joinPoint.proceed(); //핵심 기능 실행

        stopWatch.stop();
        System.out.println("시간 체크 종료 " + System.currentTimeMillis());
        logger.info(stopWatch.prettyPrint());
        return proceed;
    }

    @After("execution(* com.mk.charger.station.Repository.*(..))")
    public void logServiceAccess(JoinPoint joinPoint) {

        String result = "";

        result += "\n*****\n";
        result += joinPoint.getTarget().getClass().getName() + "."
                + joinPoint.getSignature().getName() + "(";

        int index = joinPoint.getArgs().length;
        for (Object o : joinPoint.getArgs()) {

            result += o;
            if (--index != 0) {
                result += ", ";
            }

        }
        result += ")\n";

        result += "Completed:" + joinPoint + "\n";
        result += "*****\n";

        logger.debug(result);
    }
}
