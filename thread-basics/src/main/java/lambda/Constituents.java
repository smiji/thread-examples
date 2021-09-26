package lambda;

import java.math.BigDecimal;

public class Constituents {

    private BigDecimal price;
    private BigDecimal shares;
    private BigDecimal weights;

    private BigDecimal fundWeight;
    private BigDecimal styleWt;

    public Constituents(BigDecimal price, BigDecimal shares, BigDecimal weights, BigDecimal fundWeight, BigDecimal styleWt) {
        this.price = price;
        this.shares = shares;
        this.weights = weights;
        this.fundWeight = fundWeight;
        this.styleWt = styleWt;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public BigDecimal getShares() {
        return shares;
    }

    public BigDecimal getWeights() {
        return weights;
    }

    public BigDecimal getFundWeight() {
        return fundWeight;
    }

    public BigDecimal getStyleWt() {
        return styleWt;
    }
}
