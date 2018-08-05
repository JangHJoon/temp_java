class Pizza{

	private String topping;

	public void setTopping(String newTopping){
		topping=newTopping;
	}
	public String getTopping(){
		return topping;
	}

}
class Cooker{
	
	public Pizza makePizza(String newTopping){
		Pizza pizza = new Pizza();
		pizza.setTopping(newTopping);
		return pizza;
	}
}
public class OOPUseCooker{

	public static void main(String[] args){
		Cooker cooker = new Cooker();
		Pizza pizza = cooker.makePizza("°í±¸¸¶");
		System.out.println(pizza.getTopping());

	}
}
