package market.place.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
	private int id;
	private String image;
	private String userid;
	private String name;
	private String description;
	private int price;
	private int count;
	private String regdate;
}