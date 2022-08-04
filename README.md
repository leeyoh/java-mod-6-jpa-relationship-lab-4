# JPA Relationship Lab 4

## Instruction

You are given the following database diagram:

![lab database diagram](https://curriculum-content.s3.amazonaws.com/java-spring-1/db-diagra-actors-characters-shows-networks.png)

We will a show, network, actor, and character model. They will be associated in
the following way:

- An actor has many characters and has many shows through characters.
- A character belongs to an actor and belongs to a show.
- A show has many characters and has many actors through characters.
- A show belongs to a network.
- A network has many shows.

Create the entities and relationship shown in the diagram.

The lab repository has the required dependencies defined in the `pom.xml` file.
Create your entities in the `models` package.


Shows 
- Many Characters ( one to many ) mapped By Characters 
* Network ( many to one), network_id
* String: name, day, season, genre 

Networks
- Many Shows ( one to many ) mapped by Network 
* String: call_letters
* integer: channel 

Actors 
- Many Characters (one to many) mappedBy Actors 
  * ArrayList of Characters 
* (String) first_name, last_name
* autogen ID, uuid 

Characters
- Actors ( many to one)
  - * Actor_ID
- Shows ( many to one )
  - * Show_ID
* autogen, UUID 
* String: name, catchphrase