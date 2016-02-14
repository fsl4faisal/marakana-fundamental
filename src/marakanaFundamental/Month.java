package marakanaFundamental;

public enum Month {

	JAN {
		@Override
		public int days() {
			
			return 31;
		}
	},
	FEB {
		@Override
		public int days() {
			
			return 28;
		}
	},
	MAR {
		@Override
		public int days() {
			
			return 31;
		}
	},
	APR {
		@Override
		public int days() {
			
			return 30;
		}
	};

	public abstract int days();

	/*
	 * {
	 * 
	 * switch(this){ case JAN:return 31; case FEB:return 28; case MAR:return 31;
	 * case APR:return 30; default:return 0; } }
	 */
	public static void main(String args[]) {
		System.out.println(JAN.days());

	}

}
