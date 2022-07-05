package hello.core.gilbut.IteratorPattern;

public class School implements Aggregate{

    private Student[] students;
    private int num = 0;

    public School(int size) {
        students = new Student[size];
    }

    public Student getStudent(int index) {
        return students[index];
    }

    public int getLength(){
        return num;
    }

    public void addStudent(Student student) {
        if (num < students.length){
            this.students[num] = student;
            num++;
        } else {
            System.out.println("정원 초과입니다.");
        }

    }

    @Override
    public Iterator createIterator() {
        return new SchoolIterator(this);
    }
}
