import java.util.Scanner;

public class SalaryCalculator {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Input working hours
        int[] hours = new int[7];
        for (int i = 0; i < 7; i++) {
            hours[i] = scan.nextInt();
        }

        //total working hours in a week
        int totalHours = 0;

        int[] salary = new int[7];
        for (int days = 0; days < 7; days++) {
            totalHours += hours[days];
            int totalSalary = 0;
            for (int work = 0; work < hours[days]; work++) {
                if (work >= 8) {
                    totalSalary += 115;
                } else {
                    totalSalary += 100;
                }
            }
            salary[days] = totalSalary;
        }
        int finalSalary = 0;
        for (int salaryDays : salary) {
            finalSalary += salaryDays;
        }

        if (hours[0] != 0) {
            finalSalary += (int) (0.5 * salary[0]); // 50% bonus for Saturday
        }
        if (hours[6] != 0) {
            finalSalary += (int) (0.25 * salary[6]); // 25% bonus for Sunday
        }

        if (totalHours > 40) {
            int extraHours = totalHours - 40;
            finalSalary += 25 * extraHours;
        }

        System.out.println(finalSalary);
    }
}
