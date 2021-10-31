package Alternative2;

public enum StudentStatus {
	INSTATE{
		@Override public float getTuition(){
		return 1000;
		}
	},
	OUTSTATE{
		@Override public float getTuition(){
		return 2000;
		}
	},
	INTL{
		@Override public float getTuition(){
		return 3000;
		}
	};
	public abstract float getTuition();
}
