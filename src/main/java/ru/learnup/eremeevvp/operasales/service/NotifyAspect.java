package ru.learnup.eremeevvp.operasales.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class NotifyAspect {
    @Pointcut("@annotation(ru.learnup.eremeevvp.operasales.annotations.Notifierable)")
    public void sendLetter() {
    }

    @AfterReturning("sendLetter()")
    public void sendLetterAfterSuccess(JoinPoint point) {
        //TODO Реализовать функционал отправки письма
        print("Письмо успешно отправлено");
    }

    public void print(String str) {
        System.out.println(str);
    }
}
