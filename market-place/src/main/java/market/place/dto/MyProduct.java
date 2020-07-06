package market.place.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyProduct {
	private String image;
	private String name;
	private String description;
	private int price;
	private int count;
	private String regdate;
}
