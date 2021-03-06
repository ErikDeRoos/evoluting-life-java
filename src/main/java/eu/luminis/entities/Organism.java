package eu.luminis.entities;

import eu.luminis.genetics.Genome;
import eu.luminis.general.General;
import eu.luminis.general.EventType;

public abstract class Organism {

	public Genome genome;
	public Position position;
	public World world;
	public double age;
	
	public abstract double getHealth();
	public abstract double getSize();
	
	public double getOldAge() {
		return genome.life.oldAge;
	}
	
	public Organism(Genome genome, Position position, World world){
		this.genome = genome;
		this.position = position;
		this.world = world;
	}
	
	public boolean lives(){
        Position p = this.position;

        if (p.x > world.width || p.x < 0 || p.y > world.height || p.y < 0) {
        	General.getInstance().broadcast(EventType.WANDERED, 1);
        	return false;
        }

        // Kill eu.luminis.entities if it's exceeded starvation threshold
        if (this.getHealth() <= 0) {
			General.getInstance().broadcast(EventType.STARVED, 1);
        	return false;
        }

        // Randomly kill eu.luminis.entities who've entered old age
        if (this.age > this.getOldAge()) {
        	
        	// Vulnerable eu.luminis.entities have 1/100 chance of death
        	if (Math.random() * 100 <= 1) {
				General.getInstance().broadcast(EventType.DIED_OF_AGE, 1);
        		return false;
          	}
        }

        return true;
	}
	
}
