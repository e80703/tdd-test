package tdd.vote;

public class Vote {
  private int votes[];
  
  public Vote(int number) {
    //zero means spoiled vote
    votes = new int[number+1];
  }

  public String poll(int candidate) {
    if (isValid(candidate)) {
      votes[candidate]++;
      return "poll candidate " + candidate;
    }
    else {
      votes[0]++;
      return "spoiled vote";
    }
  }

  public int votes(int candidate) {
    return votes[candidate];
  }
  
  public boolean isValid(int candidate){
    return candidate > 0 && candidate < votes.length;
  }

  public int number() {
    return votes.length;
  }

  public String result(int candidate) {
    switch (candidate) {
    case 0:
      return "spoiled vote: " + votes[0];

    default:
      return "candidate " + candidate + ": " + votes[candidate];
    }
  }

}
