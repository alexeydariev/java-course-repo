package student.examples;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@AllArgsConstructor
@Data
public class Player implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String nickname;
    private int score;

    @Override
    public int hashCode() {
        return Objects.hash(this.nickname);
    }

    @Override
    public boolean equals(Object obj) {

        Player player = (Player) obj; ////https://www.geeksforgeeks.org/override-equalsobject-hashcode-method/
        return (player.nickname.equals(this.nickname));
    }
}
