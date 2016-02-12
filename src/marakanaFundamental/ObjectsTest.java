package marakanaFundamental;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class ObjectsTest {

	@Test
	public void test() {

		//Storage[] storage={new Memory(4096,"DIMM"),new Memory(4096,"DIMM"),new Disk(512,"SATA")};
		List<Storage> storage=new ArrayList<Storage>();
		storage.add(new Memory(4096,"DIMM"));
		storage.add(new Memory(4096,"DIMM"));
		storage.add(new Disk(512,"SATA"));
		//storage.add(null);
		
		//Set<String> applications=new HashSet<String>();
		//applications.add("Word");
		//applications.add("Bit Torrent");
		
		Laptop lappy1 = new Laptop("Dell",15,storage);
		Laptop lappy2 = new Laptop("Dell",15,storage);
		assertEquals(lappy1, lappy2);

		lappy1.installApplication("bit torrent");
		lappy1.installApplication("Ms Word");
		
		
		lappy2.installApplication("bit torrent");
		lappy2.installApplication("Ms Word");

		assertEquals(lappy1, lappy2);

		
		assertEquals(520, lappy1.totalStorage());
		System.out.println("total storage is :"+lappy1.totalStorage());
		
		LaptopBag bag1=new LaptopBag(15);
		LaptopBag bag2=new LaptopBag(15);
		bag1.insertLaptop(lappy1);
		bag2.insertLaptop(lappy2);
		
		System.out.println("equals bag1 and bag2 ="+bag1.equals(bag2));
		
		//assertEquals(bag1, bag2);
		
		System.out.println("equals lappy1 and lappy2 "+lappy1.equals(lappy2));
		
//		System.out.println(bag);

	}

}
