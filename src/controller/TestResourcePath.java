package controller;

public class TestResourcePath {
    public static void main(String[] args) {
        String path = "fxml/modules/search.fxml";

        var loaderPath = TestResourcePath.class.getClassLoader().getResource(path);
        var contextPath = TestResourcePath.class.getResource("/" + path);

        System.out.println("🔍 ClassLoader 路径: " + loaderPath);
        System.out.println("🔍 getClass().getResource 路径: " + contextPath);
    }
}
