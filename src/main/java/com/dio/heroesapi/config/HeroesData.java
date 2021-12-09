package com.dio.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import static com.dio.heroesapi.constans.HeroesConstant.REGION_DYNAMO;
import static com.dio.heroesapi.constans.HeroesConstant.ENDPOINT_DYNAMO;

public class HeroesData {
    public static void main(String[] args) throws Exception {
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table_Demo");
        Item hero1 = new Item()
                .withPrimaryKey("id", 1)
                .withString("name", "Wonder Woman")
                .withString("universe", "DC Comics")
                .withNumber("films", 3);

        Item hero2 = new Item()
                .withPrimaryKey("id", 2)
                .withString("name", "Spider Man")
                .withString("universe", "Marvel")
                .withNumber("films", 6);

        Item hero3 = new Item()
                .withPrimaryKey("id", 3)
                .withString("name", "Iron Man")
                .withString("universe", "Marvel")
                .withNumber("films", 3);

        Item hero4 = new Item()
                .withPrimaryKey("id", 4)
                .withString("name", "Antman")
                .withString("universe", "Marvel")
                .withNumber("films", 2);

        Item hero5 = new Item()
                .withPrimaryKey("id", 5)
                .withString("name", "Black Panther")
                .withString("universe", "Marvel")
                .withNumber("films", 1);

        Item hero6 = new Item()
                .withPrimaryKey("id", 6)
                .withString("name", "Black Widow")
                .withString("universe", "Marvel")
                .withNumber("films", 1);

        PutItemOutcome outcome1 = table.putItem(hero1);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);
        PutItemOutcome outcome4 = table.putItem(hero4);
        PutItemOutcome outcome5 = table.putItem(hero5);
        PutItemOutcome outcome6 = table.putItem(hero6);
    }
}
