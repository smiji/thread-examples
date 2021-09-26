package lambda;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class Caller {
    static Function<Constituents,BigDecimal> mktCap = c -> c.getPrice()
            .multiply(c.getWeights())
            .multiply(c.getShares());


    static Function<Constituents,BigDecimal> mktCapStyle = c -> c.getPrice()
            .multiply(c.getWeights())
            .multiply(c.getShares())
            .multiply(c.getStyleWt());


    static Map<String,Function<Constituents,BigDecimal>> marketCapMapper = new HashMap<>();

    public static void main(String[] args) {
        marketCapMapper.put("IWT", mktCap);
        marketCapMapper.put("IWTSTYLE", mktCapStyle);
        new Caller().calculate();
    }
    private void calculate(){
        BigDecimal price = BigDecimal.valueOf(10);
        BigDecimal shares =BigDecimal.valueOf(11);
        BigDecimal weights =BigDecimal.valueOf(12);
        BigDecimal fundWeight=BigDecimal.valueOf(1);
        BigDecimal styleWt=BigDecimal.valueOf(1);
        Constituents constituents = new Constituents(price,shares,weights,fundWeight,styleWt);
        BigDecimal result =marketCapMapper.get("IWTSTYLE").apply(constituents);
        System.out.println(result);

    }
}
