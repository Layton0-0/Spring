package hello.core.gilbut.IteratorPattern;

public class SchoolIterator implements Iterator{
    private School school;
    private int index;

    public SchoolIterator(School school) {
        this.school = school;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if(index < school.getLength())
        { return true;}
        else
        { return false;}
    }

    @Override
    public Object next() {
        Student student = school.getStudent(index);
        index++;
        return student;
    }
}
