package hello.core.gilbut.IteratorPattern;

public class LetsGoSchool {
    public static void main(String[] args) {
        School school = new School(4);
        school.addStudent(new Student("윤정", 20));
        school.addStudent(new Student("인혁", 20));
        school.addStudent(new Student("진호", 20));
        school.addStudent(new Student("건영", 20));

        Iterator iterator = school.createIterator();
        while(iterator.hasNext()){
            Student student = (Student) iterator.next();
            System.out.println(student.getName() + " " +  student.getAge());
        }

    }
}



