package com.one.pilot.healtheyes.healtheyes.exercise;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Garkusha Andreys on 11/12/15.
 */
public class ExerciseContainer {
    protected List<Exercise> Container;
    protected int currentExercise;

    public ExerciseContainer() {
        Container = new ArrayList<Exercise>();
        currentExercise = 0;
    }

    public void add(Exercise exercise) {
        Container.add(exercise);
    }

    public Exercise getCurrentExercise() {
        if (Container.isEmpty()) {
            Log.e("Exercise", "The container is empty");
            return null;
        }
        return Container.get(currentExercise);
    }

    public Exercise next() {
        if (currentExercise < Container.size() -1)
            currentExercise++;
        return getCurrentExercise();
    }

    public Exercise prev() {
        if (currentExercise > 0)
            currentExercise--;
        return getCurrentExercise();
    }

}
