## spring-cassandra-flux-api
A Spring API service which uses Cassandra and webflux

## Usage

Start the application with the following maven command:
Be sure to first change the values in the application.properties.

```sh
mvn spring-boot:run
```

## Setting up locally

To develop this API locally you can set up a local Cassandra node with the following docker commands:

```
docker run --name cassandra-dev -d cassandra:3.11
```

`cqlsh` can be used to connect to a Cassandra cluster by using:
```
cqlsh <HOSTNAME> -u <USERNAME> -p PASSWORD>

 
# example:
cqlsh localhost -u cassandra -p cassandra
```

Then run the following commands to create the neccesary tables
```
CREATE KEYSPACE IF NOT EXISTS recommend WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 };
 
CREATE TABLE IF NOT EXISTS recommend.Product (
  sku text PRIMARY KEY,
  recommendations list<text>
);
 
CREATE TABLE IF NOT EXISTS recommend.User (
  userId text PRIMARY KEY,
  trigger text
);
```

## Endpoints
High level endpoints are:
* /recommend/user - User related endpoint
* /recommend/product - Product related endpoint
