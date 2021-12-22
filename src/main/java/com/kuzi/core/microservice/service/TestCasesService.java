package com.kuzi.core.microservice.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TestCasesService {

  private int satScore;

  public void calculateSATScore(int mathsScore, int literacyScore) {
    if (mathsScore < 0 || mathsScore > 100 || literacyScore < 0 || literacyScore > 100) {
      satScore = -1;
    } else {
      satScore = mathsScore * literacyScore;
    }
  }

  public int getSatScore() {
    return this.satScore;
  }

  public void testException() {

    throw new IllegalArgumentException("Illegal Argument Exception");
  }

  public List<String> getGrades(List<Integer> scores) {
    List<String> grades = new ArrayList<>();

    for (Integer score : scores) {
      grades.add(computeGrade(score));
    }
    return grades;
  }

  private String computeGrade(Integer score) {
    return score < 70 ? "Fail" : "Pass";
  }
}
