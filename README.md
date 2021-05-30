# rest-json-quarkus project

El objetivo de este proyecto era conectar la api rest-json en quarkus con una base de datos utilizando el DAO-pattern.

Instalamos dependencias:

./mvnw quarkus:add-extension -Dextensions="quarkus-jbdc-mariadb, quarkus-resteasy-jsonb, quarkus-hibernate-orm"
 ./mvnw quarkus:add-extension -Dextensions=”quarkus-hibernate-orm-panache”
 
La clase repository implementa PanacheRepository:

@ApplicationScoped
public class RepoFruit implements PanacheRepository<Fruit> {

la clase Fruit: (como cuando utilizamos hibernate, ojo con el id)
  
@Entity
@Table(name="Fruit")
@JsonPropertyOrder({"name", "decription"})
public class Fruit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotBlank
    @Column(unique = true)
    public String name;
    
    @NotEmpty
    @Column
    public String description;


