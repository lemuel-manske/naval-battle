import java.util.ArrayList;
import java.util.List;

public class Chain {

    private final List<Ship.Part> parts = new ArrayList<>();

    public Chain(Ship.Part... parts) {
        this.parts.addAll(List.of(parts));
    }

    public void add(Ship.Part part) {
        parts.add(part);
    }

    public int size() {
        return parts.size();
    }

    @Override
    public boolean equals(Object object) {
        Chain chain = (Chain) object;
        return chain.parts.size() == parts.size();
    }
}
