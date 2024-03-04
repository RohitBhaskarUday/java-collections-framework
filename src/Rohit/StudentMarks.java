package Rohit;

import java.util.Objects;

public class StudentMarks implements Comparable<StudentMarks> {
    private int maths;
    private int science;
    @Override
    public String toString() {
        return "StudentMarks{" + "maths=" + maths + ", science=" + science + '}';
    }
    public int getMaths() {
        return maths;
    }
    public int getScience() {
        return science;
    }
    public StudentMarks(int maths, int science) {
        this.maths = maths;
        this.science = science;
    }
    @Override
    public int compareTo(StudentMarks o) { // Since we are implementing the comparable interface we have to implement this compareTo method.
        //There can be three instances
        /*
        current object < other object
        return -1;
        current object > other object
        return 1;
        current object = other object
        return 0
         */

//        if (this.maths<o.maths) return -1;
//        if (this.maths>o.maths) return 1;
//        if (this.maths==o.maths) return 0;
        // instead of writing these 3 lines of code look at here
        System.out.println("The Comparable's CompareTo Method is called!!!");
        return this.maths - o.maths;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentMarks that = (StudentMarks) o;
        return maths == that.maths && science == that.science;
    }

    @Override
    public int hashCode() {
        return Objects.hash(maths, science);
    }
}
