package ui;

import java.util.Observable;
import java.util.Observer;

import main.Event;
import main.EventType;
import main.FoodSupply;
import main.Population;

public class StatsPrinter implements Observer {
	
	private int totalSarved;
	private int totalConsumed;
	private int totalWandered;
	private int totalDiedOfAge;
	private FoodSupply foodSupply;
	private Population population;
	
	public StatsPrinter(FoodSupply foodSupply, Population population) {
		this.foodSupply = foodSupply;
		this.population = population;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		Event event = (Event) arg;
	
		if (event.type.equals(EventType.CONSUMED)) {
			totalConsumed++;
		}
		else if (event.type.equals(EventType.EAT)) {
//			System.out.println("Eat");
		}
		else if (event.type.equals(EventType.STARVED)) {
			totalSarved++;
		}
		else if (event.type.equals(EventType.WANDERED)) {
			totalWandered++;
		}
		else if (event.type.equals(EventType.DIED_OF_AGE)) {
			totalDiedOfAge++;
		}
		else if (event.type.equals(EventType.CYCLE_END)) {
			if ((int)event.value % 100 == 0) {
				System.out.println(
						"totalConsumed:\t" + totalConsumed + "\t" +
						"totalSarved:\t" + totalSarved + "\t" +
						"totalWandered:\t" + totalWandered + "\t" +
						"totalDiedOfAge:\t" + totalDiedOfAge + "\t" +
						"best:\t" + population.winningEntity.rank() + "\t" 
						);
			}
		}
		
	}
}