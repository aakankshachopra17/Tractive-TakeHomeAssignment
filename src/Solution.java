package src;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution {


	public List<ProductDetails> aggregateProducts(List<String>  productsList ,Map<String,ProductDetails> mappings ){
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
		Solution obj = new Solution();

		List<String> productsList = new ArrayList<String>();
		productsList.add("CVCD");productsList.add("SDFD");productsList.add("DDDF");productsList.add("SDFD");

		Map<String,ProductDetails> hm= new HashMap<String,ProductDetails>();
		hm.put("CVCD",new ProductDetails (1,"X"));hm.put("SDFD",new ProductDetails (2,"Z"));hm.put("DDDF",new ProductDetails (1,null));

		List<ProductDetails> result= obj.aggregateProducts(productsList,hm);

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
