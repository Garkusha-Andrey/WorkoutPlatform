package com.one.pilot.healtheyes.healtheyes.exercise;

import android.util.Log;

import com.one.pilot.healtheyes.healtheyes.alarm.IAlarm;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Garkusha Andrey on 11/12/15.
 */
public class Exercise {
    public static enum ExerciseStatus {READY, RUNNING, FINISHED};

    private String name;
    private String description;
    private int duration;
    private ExerciseStatus status;
    private List<IAlarm> alarms = new ArrayList();

    private Exercise() {
    }

    public Exercise(String name, String description, int duration) {
        initExercise(name, description, duration);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() { return description; }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getDuration() { return duration; }

    public void setDuration(int seconds) {
        duration = seconds;
    }

    public ExerciseStatus getStatus() { return status; }

    public void addAlarm(IAlarm alarm) { alarms.add(alarm); }

    public void start() {
        status = ExerciseStatus.RUNNING;
        alarm(IAlarm.AlarmType.STARTED);
    }

    public void stop() {
        status = ExerciseStatus.FINISHED;
        alarm(IAlarm.AlarmType.FINISHED);
    }

    /* Private methods */
    private void initExercise(String name, String description, int duration) {
        this.name = name;
        this.description = description;
        this.duration = duration;
        status = ExerciseStatus.READY;
    }

    private void alarm(IAlarm.AlarmType type) {
        Iterator i = alarms.iterator();
        while (i.hasNext()) {
            IAlarm alarm = (IAlarm)i.next();
            alarm.call(type);
        }
    }

}
