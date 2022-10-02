package telran.collections.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import telran.collections.tests.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class Java8StreamTests {
	static class Programmer {
		public String getName() {
			return name;
		}
		public int getAge() {
			return age;
		}
		public String[] getTechnolgies() {
			return technolgies;
		}
		public Programmer(String name, int age, String[] technolgies) {
			super();
			this.name = name;
			this.age = age;
			this.technolgies = technolgies;
		}
		String name;
		int age;
		String [] technolgies;
		
	}
	List<Programmer> programmers;
	String[] technologies1 = {"Java", "SQL", "C++"};
	String[] technologies2 = {"Java"};
	String[] technologies3 = {"Java", "React", "SQL"};
	@BeforeEach
	void setUp() {
		programmers = Arrays.asList(new Programmer("Vasya", 30, technologies1),
				new Programmer("Petya", 25, technologies2),
				new Programmer("Sara", 35, technologies1));
	}

	@Test
	void testSumTwoDimArray() {
		int ar[][] = {{Integer.MAX_VALUE, 2}, {3, 4, 5}, {7}};
		assertEquals(Integer.MAX_VALUE + 21L, sumTwoDimArray(ar));
	}

	private Long sumTwoDimArray(int[][] ar) {
		
		return Arrays.stream(ar).flatMapToInt(a -> Arrays.stream(a)).asLongStream().sum();
	}
	@Test
	void averageProgrammersAgeTest() {
		assertEquals(30.0, getAverageAge());
	}

	private Double getAverageAge() {
		
//		return programmers.stream().mapToInt(p->p.getAge())
//				.average().getAsDouble();
		return programmers.stream().collect(Collectors.averagingInt(Programmer::getAge));
	}
	@Test
	void mostPopularTechnologyTest() {
		assertEquals("Java", getMostPopularTechnology());
	}

	private String getMostPopularTechnology() {
		
		return programmers.stream().flatMap(p->Arrays.stream(p.getTechnolgies()))
				.collect(Collectors.groupingBy(t -> t, Collectors.counting()))
				.entrySet().stream()
				.sorted((e1, e2)->Long.compare(e2.getValue(), e1.getValue()))
				.map(Map.Entry<String, Long>::getKey)
				.findFirst().orElse(null);
	}
	@Test
	void printDigitOccurrences() {
		ArrayList<Integer> randNumbers = new ArrayList<>();
		for(int i = 0; i < 1000000; i++) {
			randNumbers.add((int) (Math.random()*Integer.MAX_VALUE)); 
		}
		randNumbers.stream()
		.map(n->numbToDig(n).toArray())
		.flatMap(d-> Arrays.stream(d))
		.collect(Collectors.groupingBy(d->d, Collectors.counting()))
		.entrySet().stream()
		.sorted((e1, e2)->Long.compare(e2.getValue(), e1.getValue()))
		.forEach(digitsMap->System.out.println(digitsMap));
		
	}
	public static ArrayList<Integer> numbToDig(int numb) {
		ArrayList<Integer> res = new ArrayList<>();
		do {
			Integer n = numb%10;
			res.add(n);
			numb/=10;
		}while(numb>0);
		return  res;
	}
	
	

}