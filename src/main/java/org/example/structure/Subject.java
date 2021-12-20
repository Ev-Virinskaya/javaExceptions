package org.example.structure;

import org.example.constans.Subjects;
import org.example.exception.ScoreOutOfBoundException;

import java.util.List;

public class Subject {
    private Subjects nameSubject;
    private List<Integer> scores;

    public Subject(Subjects nameSubject, List<Integer> scores) throws ScoreOutOfBoundException {
        this.nameSubject = nameSubject;
        this.scores = scores;
        if (!checkScore(scores)){
            throw new ScoreOutOfBoundException();
        }

    }

    private boolean checkScore(List<Integer> scores){
        for (Integer score: scores) {
            if(score < 0 || score > 10) {
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

    public int getOverageScore(){
        int overageScore = 0;
        for (Integer score: scores) {
            overageScore += score;
        }
        return overageScore/scores.size();
    }
}
