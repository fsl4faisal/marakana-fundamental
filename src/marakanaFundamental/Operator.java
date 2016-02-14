package marakanaFundamental;

public enum Operator {
	ADD("+") {
		@Override
		public int operate(int lhs, int rhs) {

			return lhs + rhs;
		}

	},
	SUBTRACT("-") {
		@Override
		public int operate(int lhs, int rhs) {
			return lhs - rhs;
		}

		
	},
	DIVIDE("/") {
		@Override
		public int operate(int lhs, int rhs) {

			return lhs / rhs;
		}

		

	},
	MULTIPLY("*") {
		@Override
		public int operate(int lhs, int rhs) {

			return lhs * rhs;
		}


	};
	private final String token;
	private Operator(String token){
		this.token=token;
	}
	public String toString(){
		return token;
	}

	public abstract int operate(int lhs, int rhs);

}
