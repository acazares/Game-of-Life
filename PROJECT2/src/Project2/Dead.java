/**
 * 
 */
package Project2;

/**
 * @author Alexander Cazares
 *
 */
public class Dead implements Cell {

	private boolean state;
	
	public Dead(){
		this.state = false;
	}

	@Override
	public boolean isAlive() {
		// Always returns false
		return state;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (state ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Dead))
			return false;
		Dead other = (Dead) obj;
		if (state != other.state)
			return false;
		return true;
	}
}
