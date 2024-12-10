# PROYECTO4_VSP_20241210-
PROYECTO4_VSP Entregable Final

PROYECTO4 ENTREGABLE DIA 10 12 2024

Proyecto

Descripcion: Consta basicamente de 6 microservicios o unidades de negocio (accountservice, creditservice, customer, transactionservice, apiregistry, gateway).

Objetos:

UML: -BorradorSistemaAPPProyecto1.drawio (modelo general del sistema draft) -DiagramaSecuenciaAPPBanco_GENERALSISTEMA.drawio -DiagramaSecuenciaAPPBanco_PORMICROSERVICIO.drawio -UMLAPPBanco.drawio -DIAGRAMADESECUENCIAAPPBANCARIO_GENERALSISTEMA.png -DIAGRAMASECUENCIAAPPBANCARIO_PORMICROSERVICIO.png

contratos (open api diseño de app a nivel de interface rest): -accounts.yml -credits.yml -customers.yml -transactions.yml

App (codigo fuente): -accountservice -creditservice -customer -transactionservice -apiregistry (eurekaserver) - gateway

Avances por dia:

Avance PROYECTO 1: Diagrama UML -Diagrama de Secuencia, unidades de servicio accountservice, creditservice, customer. -Mejoras Diagramas UML y Secuencia. -Contratos no integrados de Open Api para las unidades de negociom, se agrega la Unidad de servicio transactionservice, se agregan las funcionalidades obligatorias requeridas, se finalizan el diagrama UML y los diagramas de secuencia, se agrega LockBack y comentarios a uno de los proyectos, se generan los contraton open api en limpio y se hacen ultimos ajustes a los proyectos.

Avance PROYECTO2, funconalidades añadidas, eureka server (apiregystry), docker compose, checkstyle, llamadas entre microservicios con feignclient.

Avance PROYECTO3, se agregam pruebas unitarias de la capa controlador con mockito para los mircoservicios -accountservice -creditservice -customer -transactionservice , se ajustan funcionalidades

Avance PROYECTO 4, Se agregan las configuracion para cada microservicio  (accountservice, creditservice, customer, transactionservice, apiregistry, gateway), estas configuraciones habilitan lo siguiente:
-Srping Security, (en el caso de gateway el sera un authorization server y en el caso de accountservice, creditservice, customer, transactionservice seran resource server e implementan la autenticacion JWT).
-Redis Cache Database, cada microservicio tiene configurado redis y ademas programada una clase de servicio para realizar operaciones de lectura y escritura.
-Kafka , cada microservicio tiene configurado kafka para ser un consumer o un publisher segun se requiera. El circuito debe orquestarse mediante el uso del kafka server cuya instalacion se indica en el docker-compose.yml
-Todos los servicios de los microservicios son reactivos y tienen sus repspectivas pruebas unitarias en la carpeta de test utilizando Junit y Mockito.
-El diagrama SistemaAPPProyecto3.drawio, muestra una vision macro del sistema y los diagramas DIAGRAMASECUENCIAAPPBANCARIO_PORMICROSERVICIO.* y DIAGRAMADESECUENCIAAPPBANCARIO_GENERALSISTEMA.* muestran las funcionalidades del sistema con diagramas de secuencia.


Otras consideraciones adicionales:

NO se han agregado servicios en la nube, sonarlint tampoco pero checkstyle y si han sido agregados al proyecto.
