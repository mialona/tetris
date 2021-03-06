package domain;

import java.io.Serializable;

public class Block implements Serializable{

	private static final long serialVersionUID = 823247191210438800L;
	private int x;
	private int y;
	private int color;
	
	public Block(int x, int y, int color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public int getColor() {
		return this.color;
	}

	public boolean moveUp() {
		this.y = this.y-1;
		return invalidValues();
	}

	public boolean moveDown() {
		this.y = this.y+1;
		return invalidValues();
	}

	public boolean moveRight() {
		this.x = this.x+1;
		return invalidValues();
	}

	public boolean moveLeft() {
		this.x = this.x-1;
		return invalidValues();
	}
	
	private boolean invalidValues() {
		return (this.x >= 0) && (this.x < 10) && (this.y >= 0) && (this.y < 20);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		
		Block other = (Block) obj;
		return (this.x == other.x) && (this.y == other.y);
	}
	
}
