package pkg;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/*
 * SKU, Version, Quantity - Coding Task
Write a method that takes two inputs: a list of purchased product codes and
 a map of mappings for these codes.
 The method should return an aggregated list of purchased products and quantity 
based on the list of purchased products codes.

Inputs
List of products: ["CVCD", "SDFD", "DDDF", "SDFD"]
Mappings: {	"CVCD": {"version": 1,"edition": "X"},
			"SDFD": {"version": 2,"edition": "Z"},
			"DDDF": {"version": 1}	}

Expected Output
Purchased items: [	{"version":1,"edition":"X","quantity":1},
					{"version":1,"quantity":1},
					{"version":2,"edition":"Z","quantity":2}	]
 */
public class Solution {


	public static List<ProductDetails> aggregateProducts(List<String>  productsList ,Map<String,ProductDetails> mappings ){
		List<ProductDetails> purchasedItems = new ArrayList<ProductDetails>();

		productsList.stream()
					.filter(x-> x!=null)
					.collect(Collectors.groupingBy(e -> e.toString(), Collectors.counting()))
					.entrySet().stream()
					.forEach( entryset -> {
						if(mappings.containsKey(entryset.getKey())){
							ProductDetails pd = mappings.get(entryset.getKey());
							pd.setpQty(entryset.getValue());
							purchasedItems.add(pd);	
							}});

		return purchasedItems;

	}

	public static void main(String[] args) {

		List<String> productsList = new ArrayList<String>();
		productsList.add("CVCD");
		productsList.add("SDFD");
		productsList.add("DDDF");
		productsList.add("SDFD");
		//productsList.add(null);

		Map<String,ProductDetails> hm= new HashMap<String,ProductDetails>();
		hm.put("CVCD",new ProductDetails (1,"X"));
		hm.put("SDFD",new ProductDetails (2,"Z"));
		hm.put("DDDF",new ProductDetails (1,null));
		//hm.put(null,new ProductDetails (null,null));
		//hm.put("ABC",new ProductDetails (1,null));


		List<ProductDetails> result= aggregateProducts(productsList,hm);
		//System.out.println(result.size());

		System.out.print("[");
		for(int i  =0 ; i<result.size();i++) {
			System.out.print(result.get(i).toString());
			if(i != result.size()-1) {
				System.out.print(",");
			}

		}
		System.out.print("]");


	}
}
