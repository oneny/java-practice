import java.util.ArrayList;
import java.util.List;

public class BaseballTeam {
  private String teamName;
  // 참조 변수에 대한 인터페이스 유형을 사용하는게 최선책
  private List<BaseballPlayer> teamMembers = new ArrayList<>();
  private int totalWins = 0;
  private int totalLosses = 0;
  private int totalTies = 0;

  public BaseballTeam(String teamName) {
    this.teamName = teamName;
  }

  public void addTeamMember(BaseballPlayer player) {
    if (!teamMembers.contains(player)) {
      teamMembers.add(player);
    }
  }

  public void listTeamMembers() {
    System.out.println(teamName + " Roster:");
    System.out.println(teamMembers);
  }

  public int ranking() {
    return (totalLosses * 2) + totalTies + 1;
  }

  public String setScore(int ourScore, int theirScore) {
    String message = "lost to";
    if (ourScore > theirScore) {
      totalWins++;
      message = "beat";
    } else if (ourScore == theirScore) {
      totalTies++;
      message = "tied";
    } else {
      totalLosses++;
    }

    return message;
  }

  @Override
  public String toString() {
    return teamName + " (Ranked " + ranking() + ")";
  }
}
