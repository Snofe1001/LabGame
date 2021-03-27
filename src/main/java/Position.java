import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Position {

    @EqualsAndHashCode.Include
    private int x;

    @EqualsAndHashCode.Include
    private int y;

    @Override
    public String toString() {
        return x + ":" + y;
    }
}
