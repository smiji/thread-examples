package lambda;

import java.math.BigDecimal;
import java.util.function.Function;

@FunctionalInterface
public interface MarketCap {
    public BigDecimal calculateMktCap();

}
