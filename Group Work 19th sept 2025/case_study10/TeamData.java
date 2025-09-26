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

public class TeamData {
    public static void main(String[] args) {
        // Team A
        Player[] teamAPlayers = {
            new Player("Alice", 12),
            new Player("Bob", 8),
            new Player("Charlie", 15)
        };
        Team teamA = new Team("Team A", teamAPlayers);

        // Team B 
        Player[] teamBPlayers = {
            new Player("David", 20),
            new Player("Eva", 18),
            new Player("Frank", 10)
        };
        Team teamB = new Team("Team B", teamBPlayers);

        // Compare total scores 
        System.out.println(teamA.name + " Total Score: " + teamA.getTotalScore());
        System.out.println(teamB.name + " Total Score: " + teamB.getTotalScore());

        // Find top players 
        Player topA = teamA.getTopPlayer();
        Player topB = teamB.getTopPlayer();

        // Find overall top player
        Player topPlayer = topA.score > topB.score ? topA : topB;
        System.out.println("Top Scorer: " + topPlayer.name + " with " + topPlayer.score + " points");

        // Find best team
        if (teamA.getTotalScore() > teamB.getTotalScore()) {
            System.out.println("Champion: " + teamA.name);
        } else if (teamB.getTotalScore() > teamA.getTotalScore()) {
            System.out.println("Champion: " + teamB.name);
        } else {
            System.out.println("It's a Tie!");
        }
    }
}
