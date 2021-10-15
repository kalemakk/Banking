# Banking
Simple Demo for Bank Application


create customer: http://127.0.0.1:8080/api/customers ....POST with firstName,lastName and email.</br>
make a deposit: http://127.0.0.1:8080/api/deposit/?amount=1000&customerId=5&accNumber=6f62cec9-ab18-45e6-bac2-7be7096f9338 where customerId is got after creating a customer, accNumber created automatically after creating a customer, amount is the amount you wish to deposit.<br>

make a withdraw: http://127.0.0.1:8080/api/with-draw/?amount=1000&customerId=5&accNumber=6f62cec9-ab18-45e6-bac2-7be7096f9338 where customerId is got after creating a customer<br>

check transactions made by customer: http://127.0.0.1:8080/api/transactions?accNumber=6f62cec9-ab18-45e6-bac2-7be7096f9338.</br>
check customer's balance: http://127.0.0.1:8080/api/balance?accNumber=6f62cec9-ab18-45e6-bac2-7be7096f9338 ..where accNumber is the customers account Number got from the customer's table.<br> 

I used myqsl as the database.</br>

Issues<br>
Not yet minimised the amount of data to show for each entity.
