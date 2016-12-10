package com.pizzashop.repositories;

import com.pizzashop.models.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by barte on 09/12/2016.
 */
public class DbInitializer {
    @Autowired
    IngredientRepository ingredientRepository;

    @Autowired
    PizzaRepository pizzaRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    ComplaintRepository complaintRepository;

    @Autowired
    ProductOrderRepository productOrderRepository;

    @Autowired
    OrderPositionRepository orderPositionRepository;

    @Autowired
            RebateRepository rebateRepository;

    Set<Ingredient> ingredients = new HashSet<>();

    Pizza p1;

    Rebate rebate;

    public DbInitializer() {


        Ingredient sos = new Ingredient();
        sos.setName("sos");

        Ingredient ser = new Ingredient();
        ser.setName("ser");

        Ingredient szynka = new Ingredient();
        szynka.setName("szynka");

        Ingredient pomidor = new Ingredient();
        szynka.setName("pomidor");

        Ingredient pieczarki = new Ingredient();
        szynka.setName("pieczarki");

        ingredients.add(sos);
        ingredients.add(ser);
        ingredients.add(szynka);
        ingredients.add(pomidor);
        ingredients.add(pieczarki);

        rebate = new Rebate();
        rebate.setName("2 w 1");

        p1 = new Pizza();
        p1.setName("marg");
        p1.setIngredients(ingredients);
        p1.setDoughPrice(new BigDecimal("12.43"));


    }

    @PostConstruct
    public void initialize() {
        List<Ingredient> ingredientList = ingredientRepository.findAll();
        {
            for (Ingredient ingredient : ingredients
                    ) {

                System.out.println(ingredient);

                if (!ingredientList.contains(ingredient))
                    ingredientRepository.save(ingredient);

            }
        }
        Set<Ingredient> ingredientSet = new HashSet<>(ingredientRepository.findAll());
        p1.setIngredients(ingredientSet);

        rebate=rebateRepository.save(rebate);
        p1.addRebate(rebate);
        p1=pizzaRepository.save(p1);

        Client client = new Client();
        client.setFirstName("bartosz");
        client.setSurname("ds");
        client.seteMail("bartek217a@wp.pl");
        client.setClientType(ClientType.normalny);

        client=clientRepository.save(client);

        //List<OrderPosition> orderPositions=new ArrayList<>();

        ProductOrder order = new ProductOrder();
        order.setProductOrderStatus(ProductOrderStatus.w_drodze);
        order.setPrice(new BigDecimal("32.34"));
        order.setAddress("sd");
        order.setClient(client);
        order.setReceiptDate(new java.sql.Date((new java.util.Date()).getTime()));
        order.setOrderDate(new java.sql.Date((new java.util.Date()).getTime()));

        order = productOrderRepository.save(order);

        OrderPosition op1 = new OrderPosition();
        op1.setCount(1);
        op1.setPrice(new BigDecimal("21.32"));
        op1.setProduct(p1);
        op1.setProductOrder(order);
        op1.setRebate(rebate);

        op1 = orderPositionRepository.save(op1);

        Complaint complaint = new Complaint();
        complaint.setComment("comment");
        complaint.setProductOrder(order);
        complaint.setSubmitDate(new java.sql.Date((new java.util.Date()).getTime()));
        complaint.setComplaintStatus(ComplaintStatus.odrzucone);

        complaint = complaintRepository.save(complaint);

        System.out.println(complaint);
        //op1.setProductOrder();
    }
}
