# Springapp : Contact Management
Operations are performed usning the VAADIN. 
I used here CRUD Vaadin UI which provides an API to generate automatically CRUD like UI's for java Beans.

# API designed through 4 interfaces :
1.CrudComponent : Vaadin comp that can be added.
2.CrudLayout : encapsulates the CRUD operations.
3.CrudListener : Layout behavior, like spacing/margine
4.CrudFormFactory : Help to build required forms.



# So we have Contact bean class and also provided the validations using Annotation. 

# You can create a new CRUD component and add it into any Vaadin layout as follows:
GridCrud<Contact> crud = new GridCrud<>(Contact.class);
layout.addComponent(crud);

# You can enable Java Bean Validation as follows:
crud.getCrudFormFactory().setUseBeanValidation(true);

# Used lambda expressions or method references to delegate CRUD operations to your backend:
crud.setFindAllOperation(() -> backend.findAll());
crud.setAddOperation(backend::add);
crud.setUpdateOperation(backend::update);
crud.setDeleteOperation(backend::delete);


# How to Run Application : 

./mvnw spring-boot:run
Or
./gradlew bootRun
# open url: http://localhost:8084/
Default port is: 8084 can be changed from application.properties

