import java.util.ArrayList;

public class ScraperThread implements Runnable {
    private Website website;
    private ThreadListener listener;
    private String prefix;
    private String year;
    private int suffixFirst;
    private int suffixLast;
    private ArrayList<Student> arrayOfStudents;

 	// TODO: constructor
 	public ScraperThread(Website website, ThreadListener listener, String prefix, String year, int suffixFirst, int suffixLast) {
              this.website = website;
              this.listener = listener;
              this.prefix = prefix;
              this.year = year;
              this.suffixFirst = suffixFirst;
              this.suffixLast = suffixLast;
              this.arrayOfStudents = new ArrayList<Student>();
 	}
 
 	// TODO: thread method
 	// PROCEDURE:
 	// 1. Construct NIM from given prefix, year, and suffixes.
 	// 2. For each NIM constructed, get data from website.
 	// 3. For each student data got from website, store in ArrayList
 	public void run() {
              String suffix, nim;
              Student student;
              int i;

              for (i = this.suffixFirst; i < this.suffixLast + 1; i++) {
                     suffix = String.format("%03d", i);
                     nim = this.prefix + this.year + suffix;
                     student = website.getStudentDataByNIM(nim);
                     this.arrayOfStudents.add(student);
              }
              listener.onSuccess(this.arrayOfStudents);
 	}
}