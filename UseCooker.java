class Pizza {
	private String topping;

	public void setTopping(String newTopping) {
		topping = newTopping;
	}
	public String getTopping() {
		return topping;
	}
}
class Cooker {
	public Pizza makePizza(String topping) {
		Pizza pizza = new Pizza();
		pizza.setTopping(topping);
		return pizza;
	}
}
class UseCooker {
	public static void main(String[] args) {
		Cooker c = new Cooker();
		Pizza pizza = c.makePizza("ºÒ°í±â");
		System.out.println(pizza.getTopping());
	}
}




















