set JAVA_HOME=%JAVA17%

mvn clean package -P build-docker-image -Djib.to.auth.username="ismailfer" -Djib.to.auth.password="%dockerpass%" -Djib.from.auth.username="ismailfer" -Djib.from.auth.password="%dockerpass%"

pause