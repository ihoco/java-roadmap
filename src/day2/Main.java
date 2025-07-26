package day2;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // 定义学生类，保存姓名和成绩
    static class Student{
        String name;  // 学生姓名
        int score;    // 学生成绩


        // 构造方法，用来初始化学生对象
        Student(String name, int score){
            this.name = name;
            this.score = score;
        }
    }


    // 根据分数返回对应的等级
    public static String getGrade(int score){
        if (score >= 90) return "A";
        else if (score >= 80) return "B";
        else if (score >= 70) return "C";
        else if (score >= 60) return "D";
        else return "F";
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);  //创建扫描器对象，用来读取用户输入
        ArrayList<Student> students = new ArrayList<>();  //创建动态数组保存学生信息
        int totalScore = 0;  // 累加所有学生成绩，用于计算平均分


        System.out.println("Please enter students' scores, enter 'q' to stop input");


        // 循环接收用户输入，录入学生姓名和成绩
        while(true){
            System.out.print("Please enter student's name(Or type 'q' to stop input):");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("q")) break;    // 如果输入q，跳出循环，结束录入


            System.out.print("Please enter: " + name + " 's score(0-100): ");
            String scoreInput = scanner.nextLine();


            try{
                int score = Integer.parseInt(scoreInput);   // 把成绩字符串转成整数
                if (score < 0 || score > 100){
                    System.out.println("The score must be between 0 and 100, please enter again.");
                    continue;  // 跳过本次循环，重新输入
                }

                students.add(new Student(name, score));   // 把学生对象加入列表
                totalScore += score; // 累加成绩
            } catch(NumberFormatException e){
                System.out.println("Invail score format, please enter numbers.");
            }
        }

        // 计算并输出平均成绩
        if (!students.isEmpty()){
            double avg = (double) totalScore /students.size();
            System.out.printf("The average score is: %.2f\n", avg);

            System.out.println("\nStudents' scores and grades:");
            for (Student s : students){
                String grade = getGrade(s.score);
                System.out.printf("%s: %d, Grade: %s\n", s.name, s.score, grade);
            }
        }else{
            System.out.println("No scores have been entered.");
        }

        System.out.println("The program ends, thx!");
        scanner.close();
    }
}
