package com.iteratrlearning.realsoftwaredevelopment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Month;
import java.util.List;

public class BankStatementAnalizer {
    
    private static final String RESOURCES = "C:/Users/andre.p.cassiano/Java - Estudos da linguagem/desenvolvimento-real-de-software/analise_de_extratos_bancarios/Real-Word-Software-Development/drs/src/main/resources/";
    private static final BankStatementCVSParser bankStatementParser = new BankStatementCVSParser();

    public static void main(final String[] args) throws IOException {

        final String fileName = "bank-data-simple.csv";
        final Path path = Paths.get(RESOURCES + fileName);
        final List<String> lines = Files.readAllLines(path);

        final List<BankTransaction> bankTransactions = bankStatementParser.parseLinesFromCSV(lines);
        final BankStatementProcessorV1 bankStatementProcessor = new BankStatementProcessorV1(bankTransactions);

        collectSummary(bankStatementProcessor);
    }

    private static void collectSummary(final BankStatementProcessorV1 bankStatementProcessor) {
        System.out.println("The total for all transactions is " + bankStatementProcessor.calculateTotalAmount());

        System.out.println("The total for transactions in January is " + bankStatementProcessor.calculateTotalInMonth(Month.JANUARY));

        System.out.println("The total for transactions in february i " + bankStatementProcessor.calculateTotalInMonth(Month.FEBRUARY));

        System.out.println("The total salary received is " + bankStatementProcessor.calculateTotalForCategory("Salary"));
    }

    public void analyze(String string, BankStatementParser bankStatementParser2) {
      // TODO document why this method is empty
    }

}
