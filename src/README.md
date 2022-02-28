The Problem Statement:

SKU, Version, Quantity - Coding Task
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
					
					
How to Test ?

The method aggregateProducts takes in two inputs: 

a) a list of purchased product codes as a List<String>.
b)  a map of mappings for these codes as Map<String,ProductDetails>.

ProductDetails is a custom model class, which has the following properties :
a)  Product version as pVersion of Integer type
b)	Product Edition as pEdition of String type
c)	Product Quantity as pQty of long type


As an Output,the function  aggregateProducts()would return a List<ProductDetails>.

 