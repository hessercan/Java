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
public class TennisGame {
    private String Player1A;
    private String Player2A;
    private int Team1Score;
    private int Team2Score;
    private String Team1ScoreStr;
    private String Team2ScoreStr;

    public TennisGame(String p1a, String p2a, int s1, int s2){
        setNames(p1a, p2a);
        setScores(s1, s2);
    }

    private void setNames(String p1a, String p2a){
        Player1A = p1a;
        Player2A = p2a;
    }

    public void setScores(int s1, int s2){
        final String[] Calls = {"love", "15", "30", "40", "game"};
        if(s1 < 0 || s1 > 4 || s2 < 0 || s2 > 4 || (s1 == 4 && s2 == 4))
        {
            Team1Score = 0;
            Team2Score = 0;
            Team1ScoreStr = "error";
            Team2ScoreStr = "error";
        }
        else
        {
            Team1Score = s1;
            Team2Score = s2;
            Team1ScoreStr = Calls[s1];
            Team2ScoreStr = Calls[s2];
        }

    }

    public String getPlayer1A(){
        return Player1A;
    }
    public String getPlayer2A(){
        return Player2A;
    }
    public double getTeam1Score(){
        return Team1Score;
    }
    public double getTeam2Score(){
        return Team2Score;
    }
    public String getTeam1ScoreStr(){
        return Team1ScoreStr;
    }
    public String getTeam2ScoreStr(){
        return Team2ScoreStr;
    }

    public void DisplayResults(){
        System.out.println("Player 1: " + Player1A);
        System.out.println("Player 2: " + Player2A);
        System.out.println("Score: " + Team1ScoreStr + " - " + Team2ScoreStr);
    }

}
