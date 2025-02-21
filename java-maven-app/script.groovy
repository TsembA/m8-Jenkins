def buildjar() {
    echo "Building JAR file..."
    sh "mvn clean package"
}
return this
