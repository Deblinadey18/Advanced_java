package org.example;

public class TaskDTO {

    // ---------- TASK ----------
    private Long taskId;
    private String task;
    private String description;

    // ---------- TEACHER ----------
    private Long teacherId;
    private String teacherName;
    private String subject;

    // ---------- COURSE ----------
    private Long courseId;
    private String courseName;

    // ---------- ENROLLMENT ----------
    private Long enrollmentId;
    private String studentName;
    private String enrolledCourse;

    public TaskDTO() {}

    // ===== Task Constructor =====
    public TaskDTO(Long taskId, String task, String description) {
        this.taskId = taskId;
        this.task = task;
        this.description = description;
    }

    // ===== Teacher Constructor =====
    public TaskDTO(Long teacherId, String teacherName, String subject, boolean flag) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.subject = subject;
    }

    // ===== Course Constructor =====
    public TaskDTO(Long courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // ===== Enrollment Constructor =====
    public TaskDTO(Long enrollmentId, String studentName, String enrolledCourse, int flag) {
        this.enrollmentId = enrollmentId;
        this.studentName = studentName;
        this.enrolledCourse = enrolledCourse;
    }

    // -------- Getters & Setters --------

    public Long getTaskId() { return taskId; }
    public void setTaskId(Long taskId) { this.taskId = taskId; }

    public String getTask() { return task; }
    public void setTask(String task) { this.task = task; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public Long getTeacherId() { return teacherId; }
    public void setTeacherId(Long teacherId) { this.teacherId = teacherId; }

    public String getTeacherName() { return teacherName; }
    public void setTeacherName(String teacherName) { this.teacherName = teacherName; }

    public String getSubject() { return subject; }
    public void setSubject(String subject) { this.subject = subject; }

    public Long getCourseId() { return courseId; }
    public void setCourseId(Long courseId) { this.courseId = courseId; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public Long getEnrollmentId() { return enrollmentId; }
    public void setEnrollmentId(Long enrollmentId) { this.enrollmentId = enrollmentId; }

    public String getStudentName() { return studentName; }
    public void setStudentName(String studentName) { this.studentName = studentName; }

    public String getEnrolledCourse() { return enrolledCourse; }
    public void setEnrolledCourse(String enrolledCourse) { this.enrolledCourse = enrolledCourse; }

    @Override
    public String toString() {
        return "TaskDTO{" +
                "taskId=" + taskId +
                ", task='" + task + '\'' +
                ", description='" + description + '\'' +
                ", teacherName='" + teacherName + '\'' +
                ", subject='" + subject + '\'' +
                ", courseName='" + courseName + '\'' +
                ", studentName='" + studentName + '\'' +
                '}';
    }
}