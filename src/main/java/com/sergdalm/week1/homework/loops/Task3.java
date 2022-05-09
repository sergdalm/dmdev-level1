package com.sergdalm.week1.homework.loops;

/**
 * Программист Ваня сразу после окончания курсов dmdev устроился
 * в IT компанию на позицию Junior Java Developer с зарплатой 600$ в месяц.
 * Ему обещали, что будут поднимать зарплату на 400$ каждые 6 месяцев.
 * 300$ в месяц Ваня тратит на еду и развлечения.
 * 10% от зарплаты Ваня ежемесячно переводит на счет брокера,
 * чтобы инвестировать в акции с доходностью 2% в месяц.
 * <p>
 * Посчитать, сколько Ваня будет иметь средств на своем счету и на счету брокера за 3 года и 2 месяца.
 */
public class Task3 {

    public static void main(String[] args) {
        int investmentAmount = calculateInvestmentAmount(3, 2, 600, 10);
        System.out.println(investmentAmount);
    }

    private static int calculateInvestmentAmount(int years, int months,
                                                 int initialSalary, int investmentPercent) {
        int totalMonths = years * 12 + months;
        int currentSalary = initialSalary;
        int investmentAmount = 0;
        for (int i = 1; i < totalMonths; i++) {
            if (i == 6) {
                currentSalary += 400;
            }
            investmentAmount += currentSalary * ((double) investmentPercent / 100);

        }
        return investmentAmount;
    }

}
