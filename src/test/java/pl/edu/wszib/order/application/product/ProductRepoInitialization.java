package pl.edu.wszib.order.application.product;

public class ProductRepoInitialization {

    public void init(final ProductFacade productFacade) {
        productFacade.create(ProductSamples.CHOCKOLATE);
        productFacade.create(ProductSamples.COCA_COLA_ZERO);
    }
}
