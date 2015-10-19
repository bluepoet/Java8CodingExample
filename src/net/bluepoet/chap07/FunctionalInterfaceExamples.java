package net.bluepoet.chap07;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Created by Mac on 2015. 10. 15..
 */
public class FunctionalInterfaceExamples {
    public static void main(String[] args) {
        Product productA = new Product(1L, "A", new BigDecimal("10.00"));
        Product productB = new Product(2L, "A", new BigDecimal("55.00"));
        Product productC = new Product(3L, "A", new BigDecimal("17.00"));
        final List<Product> products = Arrays.asList(
                productA,
                productB,
                productC,
                new Product(4L, "A", new BigDecimal("23.00")),
                new Product(5L, "A", new BigDecimal("55.00")));

        BigDecimal twenty = new BigDecimal("20");
        System.out.println(filter(products, product -> product.getPrice().compareTo(twenty) >= 0));
        System.out.println(filter(products, product -> product.getPrice().compareTo(new BigDecimal("10")) <= 0));
        final List<Product> expensiveProducts = filter(products, product -> product.getPrice().compareTo(new BigDecimal("50")) > 0);
        final List<DiscountedProduct> discountedProducts = map(expensiveProducts, product -> new DiscountedProduct(product.getId(), product.getName(), product.getPrice().multiply(new BigDecimal("0.5"))));

        for (final Product product : expensiveProducts) {
            discountedProducts.add(new DiscountedProduct(product.getId(), product.getName(), product.getPrice()));
        }

        System.out.println(expensiveProducts);
        System.out.println(discountedProducts);

        final Predicate<Product> lessThanOrEqualTo30 = product -> product.getPrice().compareTo(new BigDecimal("30")) <= 0;
        filter(discountedProducts, lessThanOrEqualTo30);

        List<BigDecimal> prices = map(products, product -> product.getPrice());
        BigDecimal total = BigDecimal.ZERO;
        for (final BigDecimal price : prices) {
            total = total.add(price);
        }

        System.out.println(total);
        System.out.println(total(products, product -> product.getPrice()));
        System.out.println(total(discountedProducts, product -> product.getPrice()));

        Order order = new Order(1L, "on-1234", Arrays.asList(
                new OrderItem(1L, productA, 3),
                new OrderItem(2L, productB, 10),
                new OrderItem(3L, productC, 5)
        ));

        System.out.println(order.totalPrice());
    }

    private static <T> List<T> filter(List<T> list, Predicate<? super T> predicate) {
        final List<T> result = new ArrayList<>();
        for (final T t : list) {
            if (predicate.test(t)) {
                result.add(t);
            }
        }
        return result;
    }

    private static <T, R> List<R> map(List<T> list, Function<T, R> function) {
        final List<R> result = new ArrayList<>();
        for (final T t : list) {
            result.add(function.apply(t));
        }
        return result;
    }

    private static <T> BigDecimal total(List<T> list, Function<T, BigDecimal> mapper) {
        BigDecimal total = BigDecimal.ZERO;

        for (final T t : list) {
            total = total.add(mapper.apply(t));
        }

        return total;
    }

    static class Product {
        private Long id;
        private String name;
        private BigDecimal price;

        public Product() {
        }

        public Product(Long id, String name, BigDecimal price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public BigDecimal getPrice() {
            return price;
        }

        public void setPrice(BigDecimal price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Product{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", price=" + price +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Product product = (Product) o;

            if (id != null ? !id.equals(product.id) : product.id != null) return false;
            if (name != null ? !name.equals(product.name) : product.name != null) return false;
            return !(price != null ? !price.equals(product.price) : product.price != null);

        }

        @Override
        public int hashCode() {
            int result = id != null ? id.hashCode() : 0;
            result = 31 * result + (name != null ? name.hashCode() : 0);
            result = 31 * result + (price != null ? price.hashCode() : 0);
            return result;
        }
    }

    static class DiscountedProduct extends Product {
        public DiscountedProduct(Long id, String name, BigDecimal price) {
            super(id, name, price);
        }
    }

    static class OrderItem {
        private Long id;
        private Product product;
        private int quantity;

        public OrderItem(long id, Product product, int quantity) {
            this.id = id;
            this.product = product;
            this.quantity = quantity;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public Product getProduct() {
            return product;
        }

        public void setProduct(Product product) {
            this.product = product;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public BigDecimal getItemTotal() {
            return product.getPrice().multiply(new BigDecimal(quantity));
        }
    }
    
    static class Order {
        private Long id;
        private String orderNumber;
        private List<OrderItem> items;

        public Order(Long id, String orderNumber, List<OrderItem> items) {
            this.id = id;
            this.orderNumber = orderNumber;
            this.items = items;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getOrderNumber() {
            return orderNumber;
        }

        public void setOrderNumber(String orderNumber) {
            this.orderNumber = orderNumber;
        }

        public List<OrderItem> getItems() {
            return items;
        }

        public void setItems(List<OrderItem> items) {
            this.items = items;
        }

        public BigDecimal totalPrice() {
            return total(items, item -> item.getItemTotal());
        }
    }
}

