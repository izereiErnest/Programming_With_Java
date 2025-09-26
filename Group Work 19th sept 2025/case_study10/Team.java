/**
 * 19th Sept 2025
 *
 * Erneste IZERE NEZA (222001299)
 * Nicyogihe Rebeca (223011370)
 * Kangabe Belise (223007011)
 * Musemakweli Muhamed(223004968)
 * Munyarukundo Joseph (223003209)
 * Munezero Grace (223009957)
 * Ndagijimana Aloys (223017789)
 * Umwari Celine (223008405)
 **/

package case_study10;

public class Team {
    String name;
    Player[] players;

    
    public Team(String name, Player[] players) {
        this.name = name;
        this.players = players;
    }

    
    public int getTotalScore() {
        int total = 0;
        for (Player p : players) {
            total += p.score;
        }
        return total;
    }

    
    public Player getTopPlayer() {
        Player top = players[0];
        for (Player p : players) {
            if (p.score > top.score) {
                top = p;
            }
        }
        return top;
    }
}
