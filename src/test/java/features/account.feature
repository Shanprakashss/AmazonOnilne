Feature: Amazon validation

@Login
Scenario: Validate Amazon basic pages

Given User Navigate to amazon homepage
Then User click on fashion and click on Mens
And User use filter by average customer review of four stars an up
Then User select puma and allen solly in brands
And User count the number of results in first page
Then User second product and add it to cart and User validate number on the cart is increased by one
#Then User validate number on the cart is increased by one