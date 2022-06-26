package com.sergdalm.week8.homework;

import com.sergdalm.week8.homework.dto.ClaimLogFileRow;
import com.sergdalm.week8.homework.runnable.ClaimFactory;
import com.sergdalm.week8.homework.runnable.ClaimLogFileParser;
import com.sergdalm.week8.homework.runnable.DispatcherTeam;

import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Реализовать эмулятор сервиса поддержки в Беларуси.
 * <p>
 * Все жалобы клиентов хранятся в хронологическом порядке в виде
 * текстового лог-файла следующего формата (столбцы разделены через запятую):
 * - Порядковый номер клиента
 * - Дата и время звонка в ISO формате
 * - Фамилия и Имя клиента
 * - Телефон клиента
 * - Текст жалобы
 * <p>
 * Каждая новая жалоба идет с новой строки в лог-файле.
 * <p>
 * Например:
 * 1, 2021-09-13T10:15:30, Иванов Иван, +375 29 999 78 90, Не включается свет
 * 2, 2021-12-22T11:38:16, Петров Петр, +375257777765, Почему опять не работает интернет?
 * 3, 2021-12-28T06:55:24, Петров Петр, 333652193, Кто-то оборвал мне телефонный кабель
 * <p>
 * Задача:
 * С какой-то периодичностью (например, раз в 2 минуты) считывать все новые записи
 * из лог-файла и отправлять их диспетчерам для созвона с клиентами
 * (ограничить количество диспетчеров, например, 2-3).
 * <p>
 * Созвон длится какое-то фиксированное время (например, 3-5 секунд),
 * после чего он записывается в другой лог-файл в виде:
 * - Порядковый номер клиента с предыдущего лог файла
 * - Дата и время созвона
 * - Номер телефона клиента
 * <p>
 * Например:
 * 2, 2022-01-04 04:15, +375 (25) 777-77-65
 * 1, 2022-01-04 04:30, +375 (29) 999-78-90
 * 3, 2022-01-04 04:45, +375 (33) 365-21-93
 * <p>
 * Номера телефонов могут быть представлены по-разному,
 * поэтому привести их к одному формату: +375 (29) 999-78-90.
 * <p>
 * * Желательно реализовать функционал добавления новых жалоб в конец лог-файла.
 */
public class SupportServiceRunner {
    private static final int NUMBER_OF_THREADS = 3;

    public static void main(String[] args) throws IOException, InterruptedException {
        Path complainLogFile = Path.of("src", "main", "resources", "claim", "claim-log-file.txt");
        Path callLogFile = Path.of("src", "main", "resources", "claim", "call-log-file.txt");
        BlockingQueue<ClaimLogFileRow> claims = new LinkedBlockingQueue<>();
        AtomicBoolean isLogFileParsed = new AtomicBoolean(false);
        Runnable parser = new ClaimLogFileParser(complainLogFile, claims, isLogFileParsed);
        Runnable dispatcherTeam = new DispatcherTeam(callLogFile, claims, isLogFileParsed);
        Runnable claimFactory = new ClaimFactory(complainLogFile);
        ExecutorService threadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

        // parse new rows in log file
        threadPool.submit(parser);

        // call clients
        threadPool.submit(dispatcherTeam);

        // add new claims
        threadPool.submit(claimFactory);
    }
}
