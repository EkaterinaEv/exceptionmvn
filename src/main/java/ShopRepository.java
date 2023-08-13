public class ShopRepository {
    private Product[] products = new Product[0];

    private Product[] addToArray(Product[] current, Product product) {
        Product[] tmp = new Product[current.length + 1];
        for (int i = 0; i < current.length; i++) {
            tmp[i] = current[i];
        }
        tmp[tmp.length - 1] = product;
        return tmp;
    }

    public void add(Product product) {
        products = addToArray(products, product);
    }

    public Product[] findAll() {
        return products;
    }

    public void remove(int id) {
        Product[] tmp = new Product[products.length - 1];
        int copyToIndex = 0;
        for (Product product : products) {
            if (product.getId() != id) {
                tmp[copyToIndex] = product;
                copyToIndex++;
            }
        }
        products = tmp;
    }

    public Product findById(int id) { //СДЕЛАЛА
        for (Product product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

//    public Product removeById() {
//        for (Product product : products) {
//            if (findById()==null) {
//                return NotFoundException();
//            }
//    }

//    try {
//        removeById(-5);
//        //System.out.println("Hello!");
//    } catch (NegativeArraySizeException e) {
//        System.out.println("Element with id: " + id + " not found");
//    }
}