package marakanaFundamental;

public class LaptopBag {
	private final int size;
	private Laptop laptop;

	public LaptopBag(int size) {
		super();
		this.size = size;
	}

	boolean insertLaptop(Laptop laptop) {
		if (laptop.getSize() > size)
			throw new IllegalArgumentException("laptop is too big");
		if (this.laptop != null)
			throw new IllegalStateException("the bag already contain a laptop");
		this.laptop=laptop;
		return true;

	}

	public Laptop getLaptop() {
		return laptop;
	}

	public void setLaptop(Laptop laptop) {
		this.laptop = laptop;
	}

	public int getSize() {
		return size;
	}

	
}
