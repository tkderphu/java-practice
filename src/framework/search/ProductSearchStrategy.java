package framework.search;

import java.util.function.Predicate;

public abstract class ProductSearchStrategy {
    private String jsonData;
//    private Root<Product>
//    private CriteriaBuilder criteriaBuilder
    public abstract Predicate search();
}
