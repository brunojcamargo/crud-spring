var db = db.getSiblingDB('product-catalog');

var productsCollectionExists = db.getCollectionNames().indexOf("products") >= 0;
var categoriesCollectionExists = db.getCollectionNames().indexOf("categories") >= 0;

if (!productsCollectionExists) {
    db.createCollection("products");
}

if (!categoriesCollectionExists) {
    db.createCollection("categories");
}