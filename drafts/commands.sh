cf push barcelona-app -p reservation/target/reservation-0.0.1-SNAPSHOT.jar
cf create-service cleardb spark domain-mysql
cf bind-service barcelona-app domain-mysql
cf restage barcelona-app
