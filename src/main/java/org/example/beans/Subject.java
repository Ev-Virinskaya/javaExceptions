package org.example.beans;

import org.example.constans.Subjects;
import org.example.exception.ScoreOutOfBoundException;

import java.util.List;


public class Subject {
    private final Subjects nameSubject;
    private final List<Integer> scores;

    public Subject(Subjects nameSubjects, List<Integer> scores) throws ScoreOutOfBoundException {
        this.nameSubject = nameSubjects;
        if (!checkScore(scores)) {
            throw new ScoreOutOfBoundException();
        }
        this.scores = scores;
    }

    public boolean checkScore(List<Integer> scores) {
        for (Integer score : scores) {
            if (score < 0 || score > 10) {
                return false;
            }
        }
        return true;
    }

    public Subjects getNameSubject() {
        return nameSubject;
    }

    public List<Integer> getScores() {
        return scores;
    }

    public double getAverageScore() {
        double averageScore = 0;
        for (Integer score : scores) {
            averageScore += score;
        }
        return averageScore / scores.size();
    }
}

