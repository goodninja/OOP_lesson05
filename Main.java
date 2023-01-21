// Напишите программу, позволяющую анализировать посещаемость студентов. Используйте паттерн MVP.
// Есть группа студентов. Для каждого студента есть журнал его посещаемости:
// список дат занятий и для каждой даты — посетил студент занятие или нет.
// Создайте класс AttendanceService (сервис посещаемости), в котором хранится информация обо всех студентах.
// Создайте класс AttendanceView, который позволяет отображать студентов и их посещаемость.
// Создайте класс presenter со следующими функциями:
// • Распечатать всех студентов и посещаемость каждого в процентах
// • Распечатать студентов, отсортировав их по убыванию посещаемости (вверху самые посещающие)
// • Распечатать студентов с посещаемостью ниже 25%
// Проверьте, как это работает.

package Lesson05;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        AttendanceService attendanceService = new AttendanceService();

        attendanceService.addLogAttendance("Лебедев", LocalDate.of(2023, 2, 21), true);
        attendanceService.addLogAttendance("Лебедев", LocalDate.of(2023, 2, 22), false);
        attendanceService.addLogAttendance("Лебедев", LocalDate.of(2023, 2, 23), true);
        attendanceService.addLogAttendance("Лебедев", LocalDate.of(2023, 2, 24), true);

        attendanceService.addLogAttendance("Соколов", LocalDate.of(2023, 2, 21), true);
        attendanceService.addLogAttendance("Соколов", LocalDate.of(2023, 2, 22), true);
        attendanceService.addLogAttendance("Соколов", LocalDate.of(2023, 2, 23), true);
        attendanceService.addLogAttendance("Соколов", LocalDate.of(2023, 2, 24), true);

        attendanceService.addLogAttendance("Орлов", LocalDate.of(2023, 2, 21), true);
        attendanceService.addLogAttendance("Орлов", LocalDate.of(2023, 2, 22), false);
        attendanceService.addLogAttendance("Орлов", LocalDate.of(2023, 2, 23), false);
        attendanceService.addLogAttendance("Орлов", LocalDate.of(2023, 2, 24), true);

        attendanceService.addLogAttendance("Дроздов", LocalDate.of(2023, 2, 21), true);
        attendanceService.addLogAttendance("Дроздов", LocalDate.of(2023, 2, 22), false);
        attendanceService.addLogAttendance("Дроздов", LocalDate.of(2023, 2, 23), false);
        attendanceService.addLogAttendance("Дроздов", LocalDate.of(2023, 2, 24), false);

        attendanceService.addLogAttendance("Синицин", LocalDate.of(2023, 2, 21), true);
        attendanceService.addLogAttendance("Синицин", LocalDate.of(2023, 2, 22), false);
        attendanceService.addLogAttendance("Синицин", LocalDate.of(2023, 2, 23), false);
        attendanceService.addLogAttendance("Синицин", LocalDate.of(2023, 2, 24), true);

        attendanceService.addLogAttendance("Курицина", LocalDate.of(2023, 2, 21), false);
        attendanceService.addLogAttendance("Курицина", LocalDate.of(2023, 2, 22), false);
        attendanceService.addLogAttendance("Курицина", LocalDate.of(2023, 2, 23), false);
        attendanceService.addLogAttendance("Курицина", LocalDate.of(2023, 2, 24), false);

        AttendanceView attendanceView = new AttendanceView(attendanceService);

        AttendancePresenter attendancePresenter = new AttendancePresenter(attendanceService, attendanceView);

        System.out.println("Вывод посещаемости студентов целиком ->");
        attendancePresenter.printWholeAttendanceList();

        System.out.println("Вывод текущей посещаемости студентов ->");
        attendancePresenter.printCurrentAttendanceList();

        System.out.println("Вывод посещаемости студентов с сортировкой ->");
        attendancePresenter.printSortedAttendanceList();

        System.out.println("Вывод студентов с посещаемостью ниже 25% ->");
        attendancePresenter.printLowAttendanceList();
    }
}
