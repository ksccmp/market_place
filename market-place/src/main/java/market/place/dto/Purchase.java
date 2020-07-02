package market.place.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Purchase {
	private int id;
	private String userid;
	private int pid;
	private int count;
	String datetime;
}
