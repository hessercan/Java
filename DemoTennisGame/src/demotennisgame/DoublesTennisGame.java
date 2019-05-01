/*
 * Mark Hesser
 * HesserCAN
 * mark@hessercan.com
 * www.hessercan.com
 */
package demotennisgame;

/**
 *
 * @author mark
 */
public class DoublesTennisGame extends TennisGame {
    private String Player1B;
    private String Player2B;

    public DoublesTennisGame(String p1a, String p1b, String p2a, String p2b, int s1, int s2)
    {
          super(p1a, p2a, s1, s2);
          setNames(p1b, p2b);

    }

    private void setNames(String p1b, String p2b){
        Player1B = p1b;
        Player2B = p2b;
    }


    public String getPlayer1B(){
        return Player1B;
    }
    public String getPlayer2B(){
        return Player2B;
    }

    @Override
    public String getPlayer1A(){
        return super.getPlayer1A();
    }
    @Override
    public String getPlayer2A(){
        return super.getPlayer2A();
    }
    @Override
    public double getTeam1Score(){
        return super.getTeam1Score();
    }
    @Override
    public double getTeam2Score(){
        return super.getTeam2Score();
    }
    @Override
    public String getTeam1ScoreStr(){
        return super.getTeam1ScoreStr();
    }
    @Override
    public String getTeam2ScoreStr(){
        return super.getTeam2ScoreStr();
    }

    @Override
    public void DisplayResults(){
        System.out.println("Team 1: " + getPlayer1A() + " and " + Player1B);
        System.out.println("Team 2: " + getPlayer2A() + " and " + Player2B);
        System.out.println("Score: " + getTeam1ScoreStr() + " - " + getTeam2ScoreStr());
    }


}
