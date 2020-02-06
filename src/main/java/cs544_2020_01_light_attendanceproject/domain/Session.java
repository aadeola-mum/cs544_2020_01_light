package cs544_2020_01_light_attendanceproject.domain;

import java.util.Date;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    @Valid
    private CourseOffering courseOffering;
    @ManyToOne
    private Timeslot timeslot;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone="CST")
    @Temporal(TemporalType.DATE)
    private Date date;

    public Session() {}

    public Session(Long id, CourseOffering courseOffering, Timeslot timeslot, Date date) {
        this.id = id;
        this.courseOffering = courseOffering;
        this.timeslot = timeslot;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public CourseOffering getCourseOffering() {
        return courseOffering;
    }

    public void setCourseOffering(CourseOffering courseOffering) {
        this.courseOffering = courseOffering;
    }

    public Timeslot getTimeslot() {
        return timeslot;
    }

    public void setTimeslot(Timeslot timeslot) {
        this.timeslot = timeslot;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Session session = (Session) o;
        return Objects.equals(id, session.id) &&
                Objects.equals(courseOffering, session.courseOffering) &&
                Objects.equals(timeslot, session.timeslot) &&
                Objects.equals(date, session.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseOffering, timeslot, date);
    }
}
