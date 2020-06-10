package greedy;

public class ff {

  public boolean isMatch(String s, String p) {
    int points = 0;
    int pointp = 0;
    int match = 0;
    int isstalk = -1;
    while (points < s.length()) {
      if (p.length() > pointp && (s.charAt(points) == p.charAt(pointp) || p.charAt(pointp) == '?')) {
        pointp++;
        points++;
      } else if (pointp < p.length() && p.charAt(pointp) == '*') {
        isstalk = pointp; // remember the station of p
        match = points;
        pointp++;
      } else if (pointp < p.length() && isstalk != -1) {
        pointp = isstalk + 1;
        match += 1;
        points = match;
      } else return false;
    }
    while (pointp < p.length() && p.charAt(pointp) == '*') {
      pointp++;
    }
    return pointp == p.length();
  }
}
