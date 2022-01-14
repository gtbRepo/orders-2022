package pl.edu.wszib.order.application.product;

import java.math.BigDecimal;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Value;
import org.hibernate.validator.constraints.Length;

@Value
public class Product {
    @NotNull
    private final ProductId id;

    @NotNull
    @Length(min = 2, max = 50)
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
