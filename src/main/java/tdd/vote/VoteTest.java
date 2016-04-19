package tdd.vote;

import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class VoteTest {
  private Vote vote;
  
  @Before
  public void setUp(){
    vote = new Vote(3);
  }

  @Test
  public void testStart() {
    assertEquals("spoiled vote", vote.poll(0));
    assertEquals(0, vote.votes(1));
  }
  
  @Test
  public void voteOne(){
    assertEquals("poll candidate 1", vote.poll(1));
    assertEquals(1, vote.votes(1));
  }
  
  @Test
  public void spoiledVote(){
    assertEquals("spoiled vote", vote.poll(0));
    assertEquals("spoiled vote", vote.poll(20));
  }
  
  @Test
  public void resultTest(){
    vote.poll(4);
    vote.poll(1);
    vote.poll(3);
    vote.poll(2);
    vote.poll(1);
    vote.poll(0);
    assertEquals(4, vote.number());
    assertEquals("candidate 1: 2", vote.result(1));
    assertEquals("spoiled vote: 2", vote.result(0));

  }
  
  @Test
  public void result() {
    randomVote();
    for (int i = 0; i < vote.number(); i++) {
      System.out.println(vote.result(i));
    }
  }
  
  public void randomVote(){
    for (int i = 0; i < (int)(Math.random()*100+1); i++) {
      vote.poll((int)(Math.random()*5));
    }
  }

}
