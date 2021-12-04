package hw.week13;
//12214031 김승구
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.DoubleFunction;
import java.util.function.Function;
import java.util.function.ToIntFunction;

class Student {
    private String name;
    private int korean, english, math;

    public Student(String name, int korean, int english, int math) {
        this.name = name;
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

     public static List<Student> students = Arrays.asList(
            new Student("지호진",100,99,100),
            new Student("오석진", 80,81,83),
            new Student("박재수", 90,75,87),
            new Student("노경두", 91, 100, 90),
            new Student("박춘규", 89,87,71)
    );


    public int returnKr() {return korean;}
    public int returnEn() {return english;}
    public int returnMt() {return math;}
}

    class StudentTest {
        public static double average(ToIntFunction<Student> function) {
            int total = 0;
            for (Student stu : Student.students) {
                total += function.applyAsInt(stu);
            }
            return (double) total / Student.students.size();
        }

        public static void main(String[] args) {
            double koreaAverage = average(f -> f.returnKr());
            double englishAverage = average(f -> f.returnEn());
            double mathAverage = average(f -> f.returnMt());

            System.out.println("국어 평균 : " + koreaAverage);
            System.out.println("영어 평균 : " + englishAverage);
            System.out.println("수학 평균 : " + mathAverage);
        }
    }

