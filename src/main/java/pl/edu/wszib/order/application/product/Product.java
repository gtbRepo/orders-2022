package pl.edu.wszib.order.application.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;

@Value
public class Product {
    @NotNull
    private final ProductId id;

    @NotNull
    @Min(2)
    @Max(50)
    private final String name;
    // można docelowo przejść na:
    // https://github.com/JavaMoney/jsr354-api

    @NotNull
    @Positive
    private final BigDecimal price;

    public boolean hasId(final String productId) {
        return id.hasId(productId);
    }
}
