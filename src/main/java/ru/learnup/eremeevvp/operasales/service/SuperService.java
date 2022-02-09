package ru.learnup.eremeevvp.operasales.service;

public class SuperService {
    private Logger logger;

    public SuperService(Logger logger) {
        this.logger = logger;
    }

    public void doWork() {
        logger.log("I start working!");
    }
}
