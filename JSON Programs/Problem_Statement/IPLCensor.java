import org.json.JSONArray;
import org.json.JSONObject;
import java.nio.file.Files;
import java.nio.file.Paths;

public class IPLCensor {
    public static void main(String[] args) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("ipl.json")));
            JSONArray matches = new JSONArray(content);

            for (int i = 0; i < matches.length(); i++) {
                JSONObject match = matches.getJSONObject(i);
                match.put("team1", maskTeam(match.getString("team1")));
                match.put("team2", maskTeam(match.getString("team2")));
                match.put("player_of_match", "REDACTED");
            }

            Files.write(Paths.get("censored_ipl.json"), matches.toString(2).getBytes());
            System.out.println("Censored IPL data saved.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static String maskTeam(String teamName) {
        return teamName.split(" ")[0] + " ***";
    }
}
