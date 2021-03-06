package domain;

import java.util.ArrayList;
import java.util.List;

public class Structure {

	private List<Block> blocks;

	public Structure() {
		this.blocks = new ArrayList<Block>();
	}

	public void addBlock(Block block) {
		this.blocks.add(block);
	}

	public List<Block> getBlocks() {
		return blocks;
	}

	public boolean containsBlock(Block block) {
		for(Block listBlock : blocks) {
			if(listBlock.equals(block)) {
				return true;
			}
		}
		
		return false;
	}

	public int deleteRows() {
		int rows = 0;
		
		for (int i = 0; i < 20; i++) {
			if (this.isRow(i)) {
				ArrayList<Block> list = new ArrayList<Block>();
				for (int j = 0; j < this.blocks.size(); j++) {
					if (this.blocks.get(j).getY() == i) {
						this.blocks.remove(j);
						j--;
					}
				}
				for (int k = 0; k < this.blocks.size(); k++) {
					if (this.blocks.get(k).getY() < i) {
						this.blocks.get(k).moveDown();
						list.add(new Block(this.blocks.get(k).getX(),
								this.blocks.get(k).getY(),this.blocks.get(k).getColor()));
						this.blocks.remove(k);
						k--;
					}
				}
				this.blocks.addAll(list);
				rows++;
			}
		}
		
		return rows;
	}

	private boolean isRow(int rowNumber) {
		boolean isRow;
		
		for (int i = 0; i < 10; i++) {
			isRow = false;
			for (Block block : this.blocks) {
				if ((block.getX() == i) & block.getY() == rowNumber) {
					isRow = true;
				}
			}
			if (!isRow) {
				return false;
			}
		}
		
		return true;
	}

	public boolean outOfLimit() {
		for (Block block : this.blocks) {
			if (block.getY() <= 1) {
				return true;
			}
		}
		
		return false;
	}

}
