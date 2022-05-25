/* Byron Young
   Text File Handling With GUI Assignment 6
   218155077 
 */
package za.ac.cput.textFileHandlingAssignment6;

public class Student {

    private String title;
    private String firstName;
    private String lastName;
    private String studentNo;
    private String email;
    private String academicYear;
    private String academicStream;
    private boolean streamChanged;

    FileHandler objFile = new FileHandler();

    public Student() {
    }

    public Student(String title, String firstName, String lastName, String studentNo, String email, String academicYear, String academicStream, boolean streamChanged) {
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNo = studentNo;
        this.email = email;
        this.academicYear = academicYear;
        this.academicStream = academicStream;
        this.streamChanged = streamChanged;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getfirstName() {
        return firstName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAcademicYear() {
        return academicYear;
    }

    public void setAcademicYear(String academicYear) {
        this.academicYear = academicYear;
    }

    public String getAcademicStream() {
        return academicStream;
    }

    public void setAcademicStream(String academicStream) {
        this.academicStream = academicStream;
    }

    public boolean isStreamChanged() {
        return streamChanged;
    }

    public void setStreamChanged(boolean streamChanged) {
        this.streamChanged = streamChanged;
    }

    public boolean writeToFile() {

        try {
            objFile.openFile();
            objFile.processFile(String.format("%s# %s# %s# %s# %s# %s# %s# %b\n", title, firstName, lastName, email,studentNo, academicYear, academicStream, streamChanged));
            objFile.closeFile();
        } catch (Exception ex) {
            return false;
        }

        return true;

    }

 @Override
    public String toString() {
        return String.format("Title: %s\nFirst Name: %s\nLast Name: %s\nEmail Address: %s\nStudent Number: "
                + "%s\nAcademic Year: %s\nAcademic Stream: %s\nStream Changed: %b", title, firstName, lastName, email, studentNo, academicYear, academicStream, streamChanged);
    }
}
