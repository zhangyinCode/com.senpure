package com.senpure.base.spring;


import com.senpure.base.annotation.Retry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;

/**
 * Created by DZ on 2016-07-19 16:25
 */
@Aspect
public class HibernateVersionProxy {

    private ThreadLocal<Proxy> proxy = new ThreadLocal();
    private static Logger log = LogManager.getLogger(HibernateVersionProxy.class);
    public HibernateVersionProxy() {
    }

    @Pointcut("@annotation(com.senpure.base.annotation.Retry)")
    private void proxyAspect() {

    }

    @Around("proxyAspect()")
    public Object execute(ProceedingJoinPoint pjp) throws Throwable {
        Object result ;
        try {
            result = pjp.proceed();
        } catch (Throwable throwable) {
            log.info("throwable class {}", throwable.getClass());
            if (throwable instanceof HibernateOptimisticLockingFailureException) {
                Proxy p = proxy.get();
                if (p == null) {
                    p = new Proxy();
                    java.lang.reflect.Method method = ((MethodSignature) pjp.getSignature()).getMethod();
                    p.method = method;
                    Retry retry = method.getAnnotation(Retry.class);
                    p.retryTime = retry.retryTimes();
                    p.invertal=retry.interval();
                    proxy.set(p);
                }
                if (p.times >= p.retryTime) {
                    log.warn("重试次数上限 {} ", p.retryTime);
                    throw throwable;
                }

                p.times++;
                Thread.sleep(p.invertal);
                log.debug("进行 第{}次重试",p.times);
                return execute(pjp);

            } else {
                throw throwable;
            }


        }
        return result;
    }

    private class Proxy {

        int times;
        java.lang.reflect.Method method;
        int retryTime;
        int invertal;
    }


}
