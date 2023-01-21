package Lesson05;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AttendancePresenter {
    private AttendanceService attendanceService;
    private AttendanceView attendanceView;

    public AttendancePresenter(AttendanceService attendanceService, AttendanceView attendanceView) {
        this.attendanceService = attendanceService;
        this.attendanceView = attendanceView;
    }

    public void printWholeAttendanceList() {
        attendanceView.showAttendance();
    }

    public void printCurrentAttendanceList() {
        Map<String, Map<LocalDate, Boolean>> logAttendance = attendanceService.getLogAttendance();
        for (String student : logAttendance.keySet()) {
            Map<LocalDate, Boolean> studentLogAttendance = logAttendance.get(student);
            double attendanceGrade = 100.0 * (double) studentLogAttendance.values().stream().filter(a -> a).count()
                    / (double) studentLogAttendance.size();
            System.out.println(student + " : " + attendanceGrade + "%");
        }
        System.out.println();
    }

    public void printSortedAttendanceList() {
        Map<String, Map<LocalDate, Boolean>> logAttendance = attendanceService.getLogAttendance();

        TreeMap<Double, List<String>> sortedLogAttendance = new TreeMap<>();
        for (String student : logAttendance.keySet()) {
            Map<LocalDate, Boolean> studentLogAttendance = logAttendance.get(student);

            double attendanceGrade = 100.0 * (double) studentLogAttendance.values().stream().filter(a -> a).count()
                    / (double) studentLogAttendance.size();

            if (!sortedLogAttendance.containsKey(attendanceGrade)) {
                sortedLogAttendance.put(attendanceGrade, new ArrayList<>());
            }
            sortedLogAttendance.get(attendanceGrade).add(student);
        }

        for (double attendanceGrade : sortedLogAttendance.descendingKeySet()) {
            System.out.println("Посещаемость: " + attendanceGrade + "%");
            for (String student : sortedLogAttendance.get(attendanceGrade)) {
                System.out.println(student);
            }
            System.out.println();
        }
    }

    public void printLowAttendanceList() {
        Map<String, Map<LocalDate, Boolean>> logAttendance = attendanceService.getLogAttendance();

        List<String> studentsLowAttendance = new ArrayList<>();
        for (String student : logAttendance.keySet()) {
            Map<LocalDate, Boolean> studentLogAttendance = logAttendance.get(student);

            double attendanceGrade = 100.0 * (double) studentLogAttendance.values().stream().filter(a -> a).count()
                    / (double) studentLogAttendance.size();
            if (attendanceGrade <= 25.0) {
                studentsLowAttendance.add(student);
            }
        }

        for (String student : studentsLowAttendance) {
            System.out.println(student);
        }
    }
}