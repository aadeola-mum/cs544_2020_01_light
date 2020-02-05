package cs544_2020_01_light_attendanceproject.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Time;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

@Entity
public class Timeslot {
    @Id
    @NotEmpty(message = "Please provide an abbreviation.")
    private String abbreviation;
    @NotEmpty(message = "Please provide a description.")
    private String description;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone="CST")
    @NotNull(message = "Please provide a start time.")
    private Date beginTime;

    @Temporal(TemporalType.TIME)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "HH:mm:ss", timezone="CST")
    @NotNull(message = "Please provide an end time.")
    private Date endTime;

    public Timeslot() {
    }

    public Timeslot(String abbreviation, String description, Date beginTime, Date endTime) {
        this.abbreviation = abbreviation;
        this.description = description;
        this.beginTime = beginTime;
        this.endTime = endTime;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    private void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getBeginTime() {
        return beginTime;
    }

    public void setBeginTime(Date beginTime) {
        this.beginTime = beginTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Timeslot timeslot = (Timeslot) o;
        return Objects.equals(abbreviation, timeslot.abbreviation) &&
                Objects.equals(description, timeslot.description) &&
                Objects.equals(beginTime, timeslot.beginTime) &&
                Objects.equals(endTime, timeslot.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(abbreviation, description, beginTime, endTime);
    }
}
