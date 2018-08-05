class Product<T,M>{
	public T brand;
	public M modelNumber;

}


public class MultiParameterEx{
	public static void main(String[] args) {
		Product<String, Integer> product1 = new Product<String,Integer>();
		// 1.7부터 생략가능

		product1.brand = "samsung";
		product1.modelNumber = 10920;
		System.out.println("brand : " + product1.brand + "\nmodelNumber : " + product1.modelNumber);

	}
}
